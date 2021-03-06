package com.whl.offer.question12;

/**
 * 矩阵中的路径
 * <p>
 * 题目：
 * 请设计一个函数，用来判断矩阵中是否存在一条包含某个字符串所有字符的路径。
 * 路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向上、下、左、右移动一格。
 * 如果一条路径经过了某一格，那么该路径不能再次进入该格子。
 * 例如下面3x4的矩阵中包含一条字符串"bfce"的路径，但矩阵中不包含字符串"abfb的路径"
 * a b t g
 * c f c s
 * j d e h
 *
 *
 * 回溯法:
 * 标志位：用来判断该路径是否是重复经过
 */
public class RouteInMatrix {

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows < 1 || cols < 1 || str == null) {
            return false;
        }
        //标志位，初始化为false，如果某个标志位为true，说明该路径已经经过，不可二次经过
        boolean[] isVisited = new boolean[rows * cols];
        for (boolean v : isVisited) {
            v = false;
        }

        int pathLength = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (hasPathCore(matrix, rows, cols, row, col, str, pathLength, isVisited)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param matrix  要判断的矩阵
     * @param rows  矩阵行数
     * @param cols  矩阵列数
     * @param row   节点的行下标
     * @param col   节点的列下标
     * @param str   要判断的字符串
     * @param pathLength  路径长度
     * @param isVisited  标志位
     * @return
     */
    private boolean hasPathCore(char[] matrix, int rows, int cols, int row, int col, char[] str, int pathLength, boolean[] isVisited) {
        if (row < 0 || col < 0 || row >= rows || col >= cols ||
                //如果该路径已经经过了，返回false
                isVisited[row * cols + col] == true ||
                //如果该节点的值不等于字符串中指定位置的值，则匹配失败，返回false
                str[pathLength] != matrix[row * cols + col]) {
            return false;
        }

        //如果已经匹配到的路径长度等于字符串的长度，则匹配完毕，可以认为已经找到了目标路径
        if (pathLength == str.length - 1) {
            return true;
        }

        boolean hasPath = false;
        isVisited[row * cols + col] = true;
        hasPath = hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, isVisited) ||
                hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, isVisited) ||
                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, isVisited) ||
                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, isVisited);
        if (!hasPath) {
            isVisited[row * cols + col] = false;
        }
        return hasPath;
    }


    public static void main(String[] args) {
        char[] matrix = "ABTGCFCSJDEH".toCharArray();
        int rows = 3;
        int cols = 4;
        char[] str = "CFCS".toCharArray();
        RouteInMatrix routeInMatrix = new RouteInMatrix();
        System.out.println(routeInMatrix.hasPath(matrix,3,4,str));

    }
}

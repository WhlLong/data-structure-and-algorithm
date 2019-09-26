package com.whl.offer.question13;

/**
 * 机器人的运动范围
 * 题目描述;
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class TheRangeOfMotionOfTheRobot {

    public int movingCount(int threshold, int rows, int cols) {


        return 0;
    }


    /**
     * 计算位数和
     *
     * @param row
     * @param col
     * @return
     */
    public int indexSum(int row, int col) {


/*         sum += num % 10;
       (num % 10 - sum) / 1
        (num % 100 - sum) / 10
        (num % 1000 - sum) / 100*/

        //个位
        int rowSum = 0;
        int rowd = 1;
        while (row / rowd > 0) {
            rowSum += (row % (10 * rowd) - rowSum) / rowd;
            rowd *= 10;
        }

        int colSum = 0;
        int cold = 1;
        while (col / cold > 0) {
            colSum += (col % (10 * cold) - colSum) / cold;
            cold *= 10;
        }

        return rowSum + colSum;
    }


    public static void main(String[] args) {
        TheRangeOfMotionOfTheRobot s = new TheRangeOfMotionOfTheRobot();
        System.out.println(s.indexSum(35, 38));
    }

}

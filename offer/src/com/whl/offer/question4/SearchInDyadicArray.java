package com.whl.offer.question4;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 * <p>
 * 解题思路:
 * 每一行从左到右递增，每一列从上到下递增
 * 1.如果小于[0][0]或者大于[colLength-1][rowLength-1],那么一定是不存在的
 * 2.从二维数组的左下角或者右上角开始，
 * 2.1从左下角开始，如果给定的数小于左下角的数，将列下标减一，如果给定的数大于左下角的数，将行下标加一
 * 2.2从右上角开始，如果给定的数小于右上角的数，将行下标减一，如果给定的数大于右上角的数，将行下标加一
 */
public class SearchInDyadicArray {

    public static void main(String[] args) {
        int arr[][] = {{1, 2, 3}, {4, 6, 7}, {5, 8, 9}, {11, 13, 14}};
        System.out.println(SearchInDyadicArray.search1(arr, 5) ? "5存在！" : "5不存在！");
        System.out.println(SearchInDyadicArray.search1(arr, 15) ? "15存在！" : "15不存在！");
        System.out.println(SearchInDyadicArray.search1(arr, 0) ? "0存在！" : "0不存在！");
        System.out.println(SearchInDyadicArray.search1(arr, 3) ? "3存在！" : "3不存在！");
    }

    public static boolean search1(int[][] array, int target) {
        if(array == null){
            return false;
        }

        int colLength = array.length;
        int rowLength = array[0].length;

        if (target < array[0][0] || target > array[colLength - 1][rowLength - 1]) {
            return false;
        }

        //从左下角开始
        int colIndex = colLength - 1;
        int rowIndex = 0;
        while (colIndex >= 0 && rowIndex <= rowLength - 1) {
            if (target > array[colIndex][rowIndex] ){
                rowIndex++;
                continue;
            }
            if (target < array[colIndex][rowIndex]){
                colIndex--;
            }

            return true;
        }


        return false;
    }


    public static boolean search2(int[][] array, int target) {
        if(array == null){
            return false;
        }

        int colLength = array.length;
        int rowLength = array[0].length;

        if (target < array[0][0] || target > array[colLength - 1][rowLength - 1]) {
            return false;
        }

        //从右上角开始
        int colIndex = 0;
        int rowIndex = rowLength - 1;
        while (colIndex <= colLength - 1 && rowIndex >= 0) {
            if (target > array[colIndex][rowIndex] ){
                colIndex++;
                continue;
            }
            if (target < array[colIndex][rowIndex]){
                rowIndex--;
            }

            return true;
        }


        return false;
    }

}

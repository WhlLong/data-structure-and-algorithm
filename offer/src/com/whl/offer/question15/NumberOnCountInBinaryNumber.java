package com.whl.offer.question15;

/**
 * 二进制中1的个数
 * 题目:
 * 请实现一个函数，输入一个整数，输出该整数二进制表示中1的数量，
 * 比如9的二进制表示为1001,1的个数为2.
 * 9: 1001
 * 8: 1000
 * 7: 0111
 *
 * 解题思路：
 * 任何一个数，转换成二进制以后，每一次将它和比它小1的数的二进制表示进行与运算，都能将最右边的一个1去除，
 * 那么在它的成为0之前能够进行多少次与运算，它就包含多少个1
 */
public class NumberOnCountInBinaryNumber {


    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(9));

    }

    private static int solution(int num) {

        if (num == 0) {
            return 0;
        }

        int count = 0;
        while (num != 0) {
            count++;
            num = num & (num - 1);
        }

        return count;
    }


}

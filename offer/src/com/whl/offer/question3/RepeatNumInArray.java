package com.whl.offer.question3;

import java.util.BitSet;

/**
 * 数组中重复的数字
 * 题目：
 * 在一个长度为n的数组里的所有数字都在0-n-1的范围内。
 * 数组中某些数字是重复的，但是不知道哪几个字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * 例如，输入长度为7的数组{2,3,1,0,2,5,3},那么对应的输出是重复的数字2或者3.
 * <p>
 * 思路:
 * 1. 创建一个长度为n的新数组，遍历数组中的数据，将数据的值填入新数组以数据的值为下标的对应的位置，
 * 根据新数组中的数据判断是否是重复的数。
 */
public class RepeatNumInArray {

    public static void main(String[] args) {
        int[] numbers = {2,3,1,0,2,5,3};
        int duplication[] = new int[1];

        RepeatNumInArray repeatNumInArray = new RepeatNumInArray();
        boolean result = repeatNumInArray.duplicate2(numbers, numbers == null ? 0 : numbers.length, duplication);
        if (result) {
            System.out.println(duplication[0]);
        }
    }

    /**
     * 牛客网
     * 使用数组来解决问题
     *
     * @param numbers
     * @param length      数组的长度
     * @param duplication 如果有重复的值，赋值到duplication[0]
     * @return 如果输入的参数有效，并且数组中含有重复的数字，返回true，否则返回false
     */
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0 || duplication == null || duplication.length == 0) {
            return false;
        }

        int[] newArray = new int[length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = -1;
        }
        for (int number : numbers) {
            if (newArray[number] == number) {
                duplication[0] = number;
                return true;
            } else {
                newArray[number] = number;
            }
        }

        return false;
    }


    /**
     * 牛客网
     * 使用位图法
     *
     * @param numbers
     * @param length      数组的长度
     * @param duplication 如果有重复的值，赋值到duplication[0]
     * @return 如果输入的参数有效，并且数组中含有重复的数字，返回true，否则返回false
     */
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || numbers.length == 0 || length <= 0 || duplication == null || duplication.length == 0) {
            return false;
        }

        BitSet bitSet = new BitSet(length);
        for (int number : numbers) {
            if (bitSet.get(number)) {
                duplication[0] = number;
                return true;
            } else {
                bitSet.set(number, true);
            }
        }
        return false;
    }
}

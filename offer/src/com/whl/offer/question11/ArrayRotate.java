package com.whl.offer.question11;

/**
 * 旋转数组的最小数字
 * 题目：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素
 * 例如{3,4,5,1,2}是数组{1,2,3,4,5}的一个旋转，该数组的最小值为1
 * 给出的所有元素都大于0，若数组大小为0，请返回0。
 * <p>
 * 解题思路:
 * mid = low + (high - low) / 2
 * array[mid] > array[high]:
 * 出现这种情况的array类似[3,4,5,6,0,1,2]，此时最小数字一定在mid的右边。
 * low = mid + 1
 * <p>
 * array[mid] == array[high]:
 * 出现这种情况的array类似 [1,0,1,1,1] 或者[1,1,1,0,1]，此时最小数字不好判断在mid左边还是右边,这时只好一个一个试
 * high = high - 1
 * <p>
 * array[mid] < array[high]:
 * 出现这种情况的array类似[2,2,3,4,5,6,6],此时最小数字一定就是array[mid]或者在mid的左边。因为右边必然都是递增的。
 * high = mid
 */
public class ArrayRotate {

    public static void main(String[] args) {
        int[] arr1 = {3, 4, 5, 6, 0, 1, 2};
        System.out.println(minNumberInRotateArray(arr1));

        System.out.println("============");

        int[] arr2 = {1, 0, 1, 1, 1};
        System.out.println(minNumberInRotateArray(arr2));

        System.out.println("============");

        int[] arr3 = {2, 2, 3, 4, 5, 6, 6};
        System.out.println(minNumberInRotateArray(arr3));

        System.out.println("============");

        int[] arr4 = {6,4};
        System.out.println(minNumberInRotateArray(arr4));
    }


    private static int minNumberInRotateArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
//            int mid = low + (high - low) / 2;
            int mid = (high + low) / 2;

            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else if (arr[mid] == arr[high]) {
                high--;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }

}

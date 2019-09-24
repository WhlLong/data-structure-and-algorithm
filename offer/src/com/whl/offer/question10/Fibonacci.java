package com.whl.offer.question10;

/**
 * 写一个函数，输入n，求斐波那契数列的第n项。
 * 斐波那契数列的定义如下：
 * f(n) = n, n <= 1
 * f(n) = f(n-1) + f(n-2), n > 1
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibonacci1(1));
        System.out.println(fibonacci1(2));
        System.out.println(fibonacci1(3));
        System.out.println(fibonacci1(4));
        System.out.println(fibonacci1(5));
        System.out.println(fibonacci1(39));

        System.out.println("============");

        System.out.println(fibonacci2(1));
        System.out.println(fibonacci2(2));
        System.out.println(fibonacci2(3));
        System.out.println(fibonacci2(4));
        System.out.println(fibonacci2(5));
        System.out.println(fibonacci2(39));
        System.out.println(fibonacci2(100));
    }


    /**
     * 递归
     * 递归解法右效率问题，这里面有大量的重复计算，当n越来越大时，
     * 计算所需要的时间复杂度是以n的指数方式递增的
     */
    private static long fibonacci1(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }


    private static long fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }

        long resultOne = 0;
        long resultTwo = 1;
        long resultN = 0;
        for (int i = 2; i <= n; i++) {
            resultN = resultOne + resultTwo;
            resultOne = resultTwo;
            resultTwo = resultN;
        }
        return resultN;
    }

}

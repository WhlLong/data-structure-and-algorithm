package com.whl.offer.question11;

import java.math.BigDecimal;

/**
 * 数值的整数次方
 * 题目:
 * 实现函数double Power(double base,int exponent),求base的exponenet次方。
 * 不得使用库函数，同时不需要考虑大数值问题
 *
 * 解题思路:
 * 如果指数是整数，就比较容易做，只需要一个循环就能解决，
 * 但是如果不是正数，就需要好好考虑了：
 * 如果指数是0，那么最后的值一定是1,需要 注意的是0的0次方是没有意义的
 * 如果指数是负数，那么最后的值等于base分之一的n次幂，n等于指数的绝对值。
 *
 *
 * 上面的代码还是不够优雅，这题可以用递归的方式来处理
 * 优化：
 * 如果exponent为偶数：
 * result = base^(exponent/2) * base^(exponent/2)
 * 如果exponent为奇数:
 * result = base^(exponent/2) * base^(exponent/2)* base
 *
 *
 * 此外:
 * 除以2的操作可以用右移来代替，这样性能更好
 * 取余的操作可以用与运算来代替
 */
public class WholeNumberPowerOfVal {

    public static void main(String[] args) {

//        System.out.println(0 == 0.000000000000000000000000000000000000000000000000000000000000000000000000000001);

//        System.out.println( solution1(2,-1));
//        System.out.println( solution1(2,5));
//        System.out.println( solution1(0,-1));
//        System.out.println( solution1(2,0));
//        System.out.println( solution1(-2,0));
//        System.out.println( solution1(0,0));

        System.out.println("====================");

        System.out.println( solution1(2,-1));
        System.out.println( solution1(2,5));
        System.out.println( solution1(0,-1));
        System.out.println( solution1(2,0));
        System.out.println( solution1(-2,0));
        System.out.println( solution1(0,0));


    }



    public static double solution1(double base,int exponent){

        double result = 1;

        if(exponent > 0){
            for(int i=0;i<exponent;i++){
                result = result * base;
            }
        }

        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }

        if(exponent < 0){
            for(int i=0;i<-exponent;i++){
                result *= base;
            }

            return 1.0 / base;
        }

        return result;
    }


    public static double solution2(double base,int exponent){


        if(base == 0){
            return 0;
        }
        if(exponent == 0){
            return 1;
        }
        if(exponent == 1){
            return base;
        }
        double result = solution2(base,exponent >> 1)*solution2(base,exponent >> 1);
        if((exponent & 1) == 1){
            result *= base;
        }

        return result;
    }
}

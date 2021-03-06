package com.whl.offer.question17;

import java.util.Arrays;

/**
 * 打印1到最大的n位数
 * <p>
 * 题目:
 * 输入数字n，打印1到最大的n位十进制数，比如输入3，就打印1，2,3....999(最大的三位数)
 * <p>
 * 解题思路:
 * 这题乍一看很简单，如print1方法，但是这种解法没有考虑大数问题，
 * 如果n比较大，计算出的n位数的最大值已经超出了整数能表示的范围从而导致溢出。
 * <p>
 * 思路一:
 * 通过数组或者字符串来表示最大值
 * <p>
 * 思路二:使用全排列的思路来打印1到最大n位数
 * <p>
 * 打印的时候也需要注意，前面的0就不需要打印出来了
 * <p>
 * java中char类型在计算时会被转换成int数值，这个转换是根据ASCII码表来进行转换的，
 * 比如字符‘0’转换成int类型以后的值是48
 * int类型的值如果强转成char类型，也是按照ASCII码表来进行转换，比如‘0’会被转换成空字符
 */
public class PrintNumOneToN {

    public static void main(String[] args) {
//        print1(2);

        System.out.println("===========");

//        print2(2);
        print3(2);
    }


    public static void print1(int n) {
        if (n <= 0) {
            return;
        }
        long maxAddOne = 1;
        for (int i = 0; i < n; i++) {
            maxAddOne = maxAddOne * 10;
        }
        for (int i = 1; i < maxAddOne; i++) {
            System.out.println(i);
        }
    }

    /**
     * 使用字符串来处理，解决大数问题
     *
     * @param n
     */
    public static void print2(int n) {
        if (n <= 0) {
            return;
        }

        StringBuilder sb = new StringBuilder();
        // 初始化字符串,全部初始化为0，比如n==3时初始化为"000",n==4时初始化为"0000"
        for (int i = 0; i < n; i++) {
            sb.append("0");
        }

        while (stillIncrease(sb, n)) {
            print2Print(sb);
        }

        System.out.println();
    }

    private static boolean stillIncrease(StringBuilder sb, int len) {
        // 进位
        int toTen = 0;
        // 从个位开始加，如果有进位就看十位,如果到最高位还有进位，说明太长溢出了
        for (int i = len - 1; i >= 0; i--) {
            // 加上进位toTen
            int sum = sb.charAt(i) - '0' + toTen;
            // 在个位上，先自增
            if (i == len - 1) {
                sum++;
            }

            if (sum == 10) {
                // 进位溢出
                if (i == 0) {
                    return false;
                } else {
                    // 需要进位，当前位设为0
                    sb.setCharAt(i, '0');
                    // 进位了
                    toTen = 1;
                }
            } else {
                sb.setCharAt(i, (char) (sum + '0'));
                // 在某位上自增后不再进位，自增完成立即退出循环
                break;
            }
        }
        return true;
    }

    private static void print2Print(StringBuilder sb) {
        int start = sb.length();
        // 找到第一个不为0的索引
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                start = i;
                break;
            }
        }
        // 如果全是0，就不会打印
        if (start < sb.length()) {
            System.out.print(sb.substring(start) + " ");
        }
    }


    /**
     * 全排列
     */

    /**字符每一位进行全排列
     *
     * @param n
     */
    public static void print3(int n){
        if(n <= 0) {
            return;
        }
        char[] number = new char[n];
        Arrays.fill(number, '0');
        printOrder(number,n,0);
    }
    public static void printOrder(char[] number, int n, int loc){
        if(loc == n) {
            return;
        }
        for(int i = 0; i <= 9; i++){
            number[loc] = (char)('0' + i);
            if(loc == n - 1){
                printNumber(number);
            }
            printOrder(number,n,loc + 1);
        }
    }

    public static void printNumber(char[] num){
        int size = num.length;
        int i = 0;
        while(i < size && num[i] == '0') {
            i++;
        }

        if(i == size) {
            //全是0不打印
            return;
        }
        char[] printNum = Arrays.copyOfRange(num, i, size);//复制数组
        System.out.println(printNum);
    }


}

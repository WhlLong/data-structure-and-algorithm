package com.whl.offer.question14;

/**
 * 剪绳子
 * 题目：
 * 给你一根长度为n的绳子，请把绳子剪成m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。
 * 请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * <p>
 * 考察点： 动态规划和贪心算法
 * <p>
 * 动态规划:
 * 动态规划求解问题的四个特征：
 * ①求一个问题的最优解；
 * ②整体的问题的最优解是依赖于各个子问题的最优解；
 * ③小问题之间还有相互重叠的更小的子问题；
 * ④从上往下分析问题，从下往上求解问题
 * <p>
 * 贪心算法:
 */
public class CutRope {

    /**
     * 动态规划
     *
     * @param target
     * @return
     */
    public int cutRope(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        /**
         * n=2时，因为必须要剪一刀，只能剪成1和1，所以最大乘积是1，
         * 但是初始化f(2)的时候，是为了计算n>3的情况，因此如果有长度为2的肯定至少剪了一刀，
         * 这时候长度为2的最大乘积是2，初始化f(3)也是同理。
         */
        int[] length = new int[target + 1];
        length[0] = 0;
        length[1] = 1;
        length[2] = 2;
        length[3] = 3;


        int max = 0;
        for (int i = 4; i <= target; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (max < length[j] * length[i - j]) {
                    max = length[j] * length[i - j];
                    length[i] = max;
                }
            }
        }

        return max;
    }


    /**
     * 贪心算法
     * @param target
     * @return
     */
    public int cutRope2(int target) {

        int max = 0;


        return max;
    }

    public static void main(String[] args) {
        CutRope cutRope = new CutRope();
        System.out.println(cutRope.cutRope(2));
        System.out.println(cutRope.cutRope(3));
        System.out.println(cutRope.cutRope(5));
        System.out.println(cutRope.cutRope(8));

    }

}

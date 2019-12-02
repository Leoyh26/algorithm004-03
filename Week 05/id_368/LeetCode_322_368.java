/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/12/2
 */
public class LeetCode_322_368 {

    /*给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
    如果没有任何一种硬币组合能组成总金额，返回 -1。
    链接：https://leetcode-cn.com/problems/coin-change*/

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        //1、定义状态数组：dp[i]代表金额为i时所需的最少硬币数；
        //2、定义状态转移方程：dp[i] = dp[i-amount] + 1;
        //3、定义初始值：dp[0] = 0
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            for (int coin : coins) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];

    }
}

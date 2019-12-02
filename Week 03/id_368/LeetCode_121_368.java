public class LeetCode_121_368 {

    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    注意你不能在买入股票前卖出股票。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock*/

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                if (prices[i] - minPrice > max) {
                    max = prices[i] - minPrice;
                }
            }
        }
        return max;
    }

    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }
        return dp[n - 1][0];
    }

    // 1、定义状态数组：dp[i][k][l]: 0 <= k <= n-1, 1 <= k <= K, l = 0 or 1;
    // 2、定义状态转移方程：
    //        dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
    //        dp[i][k][1] = max(dp[i-1][k][1], dp[i-1)[k-1][0] - prices[i];
    //    base case:
    //        dp[-1][k][0] = 0;
    //        dp[-1][k][1] = -infinity;
    //        dp[i][0][0] = 0;
    //        dp[i][0][1] = -infinity;

    public int maxProfitDP02(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, - prices[i]);
        }
        return dp_i0;
    }
}

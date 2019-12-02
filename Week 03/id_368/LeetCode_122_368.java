public class LeetCode_122_368 {

    /*给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii*/

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                sum += prices[i] - prices[i-1];
            }
        }
        return sum;
    }

    public int maxProfitDP(int[] prices) {
        int n = prices.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }

    // 状态转移方程：
    //      dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
    //      dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices(i));
    //  base case:
    //      dp[-1][k][0] = dp[i][0][0] = 0;
    //      dp[-1][k][1] = dp[i][0][1] = -infinity;

    public int maxProfitDP02(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int dp_i0_cur = Math.max(dp_i0, dp_i1 + prices[i]);
            int dp_i1_cur = Math.max(dp_i1, dp_i0 - prices[i]);
            dp_i0 = dp_i0_cur;
            dp_i1 = dp_i1_cur;
        }
        return dp_i0;
    }
}

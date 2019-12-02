/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/12/2
 */
public class LeetCode_309_368 {

    /*给定一个整数数组，其中第 i 个元素代表了第 i 天的股票价格 。​
    设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
    你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
    链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown*/

    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        int dp_pre0 = 0;
        for (int i = 0; i < n; i++) {
            int temp = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_pre0 - prices[i]);
            dp_pre0 = temp;
        }
        return dp_i0;
    }
}

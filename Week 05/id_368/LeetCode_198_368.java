/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/12/2
 */
public class LeetCode_198_368 {

    /*你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
    影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
    如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
    给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
    链接：https://leetcode-cn.com/problems/house-robber*/

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], dp[0]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i]);
        }
        return dp[nums.length-1];
    }

    public int robDP(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int preMax = 0;
        int curMax = 0;
        for (int num : nums) {
            int temp = curMax;
            curMax = Math.max(curMax, preMax + num);
            preMax = temp;
        }
        return curMax;
    }

    public int robDP02(int[] nums) {
        if (nums.length == 0) {
            return 0 ;
        }

        int dp[] = new int[2];
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; ++i) {
            dp[i % 2] = Math.max(nums[i - 1] + dp[(i - 2)%2], dp[(i - 1)%2]);
        }

        return dp[nums.length % 2];
    }
}

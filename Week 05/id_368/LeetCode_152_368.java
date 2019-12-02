/**
 * @author: liuyanhui@daojia-inc.com
 * @date: 2019/12/2
 */
public class LeetCode_152_368 {
    /*给定一个整数数组 nums ，找出一个序列中乘积最大的连续子序列（该序列至少包含一个数）。
    https://leetcode-cn.com/problems/maximum-product-subarray/*/

    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[] dpMax = new int[nums.length];
        int[] dpMin = new int[nums.length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int max = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
            dpMax[i] = Math.max(Math.max(dpMax[i-1] * nums[i], nums[i]), dpMin[i-1] * nums[i]);
            dpMin[i] = Math.min(Math.min(dpMin[i-1] * nums[i], nums[i]), dpMax[i-1] * nums[i]);
            max = Math.max(max, dpMax[i]);
        }
        return max;
    }

    public int maxProductDP(int[] nums) {
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int curMax = Math.max(Math.max(dpMax * nums[i], nums[i]), dpMin * nums[i]);
            int curMin = Math.min(Math.min(dpMin * nums[i], nums[i]), dpMax * nums[i]);
            max = Math.max(max, curMax);
            dpMax = curMax;
            dpMin = curMin;
        }
        return max;
    }

    public int maxProductDP02(int[] nums) {
        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = dpMax;
                dpMax = dpMin;
                dpMin = temp;
            }
            dpMax = Math.max(dpMax * nums[i], nums[i]);
            dpMin = Math.min(dpMin * nums[i], nums[i]);
            max = Math.max(max, dpMax);
        }
        return max;
    }
}

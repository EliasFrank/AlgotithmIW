//给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。 
//
// 返回这三个数的和。 
//
// 假定每组输入只存在恰好一个解。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,0,0], target = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 3 <= nums.length <= 1000 
// -1000 <= nums[i] <= 1000 
// -10⁴ <= target <= 10⁴ 
// 
// Related Topics 数组 双指针 排序 👍 1265 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Map;

/**
 * 最接近的三数之和
 * @author HL
 * @date 2022-10-17 21:09:41
 */
class P16_ThreeSumClosest{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P16_ThreeSumClosest().new Solution();
		 int[] nums = new int[]{4,0,5,-5,3,3,0,-4,-5};
		 int i = solution.threeSumClosest(nums, -2);
		 System.out.println(i);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int result = 100000;
		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target) return target;
				if (Math.abs(target - result) > Math.abs(target - sum)) {
					result = sum;
				}
				if (sum > target) {
					int k0 = k - 1;
					while (j < k0 && nums[k] == nums[k0]) k0--;
					k = k0;
				} else if (sum < target) {
					int j0 = j + 1;
					while (j0 < k && nums[j] == nums[j0]) j0++;
					j = j0;
				}
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//整数数组的一个 排列 就是将其所有成员以序列或线性顺序排列。 
//
// 
// 例如，arr = [1,2,3] ，以下这些都可以视作 arr 的排列：[1,2,3]、[1,3,2]、[3,1,2]、[2,3,1] 。 
// 
//
// 整数数组的 下一个排列 是指其整数的下一个字典序更大的排列。更正式地，如果数组的所有排列根据其字典顺序从小到大排列在一个容器中，那么数组的 下一个排列 就
//是在这个有序容器中排在它后面的那个排列。如果不存在下一个更大的排列，那么这个数组必须重排为字典序最小的排列（即，其元素按升序排列）。 
//
// 
// 例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。 
// 类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。 
// 而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。 
// 
//
// 给你一个整数数组 nums ，找出 nums 的下一个排列。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 👍 1968 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 下一个排列
 * @author HL
 * @date 2022-11-09 21:54:37
 */
class P31_NextPermutation{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P31_NextPermutation().new Solution();
	     int[] nums = {3,2,1};
//	     int[] nums = {4,7,6,5,3,2,1};
//	     int[] nums = {1,2,3,4,7,6,5};
	     solution.nextPermutation(nums);
		 for (int i = 0; i < nums.length; i++) {
			 System.out.print(nums[i] + " ");
		 }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public void nextPermutation(int[] nums) {
		int i = nums.length - 1;
		while (i > 0 && nums[i] <= nums[i - 1]) {
			i--;
		}
		int small = i - 1;
		i = nums.length - 1;
		if (small >= 0) {
			while (i > 0 && nums[i] <= nums[small]) {
				i--;
			}
			int big = i;
			int temp = nums[small];
			nums[small] = nums[big];
			nums[big] = temp;
		}

		reverse(nums, small + 1, nums.length);
	}
	private void reverse(int[] nums, int start, int end) {
		int left = start, right = end - 1;
		while (left < right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}

	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

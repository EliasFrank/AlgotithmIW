//给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[
//b], nums[c], nums[d]] （若两个四元组元素一一对应，则认为两个四元组重复）： 
//
// 
// 0 <= a, b, c, d < n 
// a、b、c 和 d 互不相同 
// nums[a] + nums[b] + nums[c] + nums[d] == target 
// 
//
// 你可以按 任意顺序 返回答案 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,0,-1,0,-2,2], target = 0
//输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,2,2,2], target = 8
//输出：[[2,2,2,2]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 200 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 双指针 排序 👍 1413 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 四数之和
 * @author HL
 * @date 2022-10-30 13:16:50
 */
class P18_FourSum{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P18_FourSum().new Solution();
//	     int[] nums = {1,0,-1,0,-2,2};
	     int[] nums = {1000000000,1000000000,1000000000,1000000000};
	     int target = -294967296;
		 List<List<Integer>> lists = solution.fourSum(nums, target);
		 for (int i = 0; i < lists.size(); i++) {
			 lists.get(i).forEach(num -> System.out.print(num + " "));
			 System.out.println();
		 }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<>();
		long longTarget = target;
//		int scope = (int)Math.pow(10, 9);
//    	if (target < -scope || target > scope) return results;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j =  i + 1; j < nums.length - 1; j++) {
				int s = j + 1;
				int e = nums.length - 1;
				long tmpTarget = longTarget - nums[i] - nums[j];
				while (s < e) {
					int tmpSum = nums[s] + nums[e];
					if (tmpSum > tmpTarget) {
						e--;
					} else if (tmpSum < tmpTarget) {
						s++;
					} else {
						results.add(Arrays.asList(nums[i],nums[j],nums[s],nums[e]));
						while (s < e && nums[s] == nums[s + 1]) s++;
						while (s < e && nums[e] == nums[e - 1]) e--;
						s++;
					}
				}
				while (j < nums.length - 1 && nums[j] == nums[j + 1]) j++;
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1]) i++;
		}
		return results;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

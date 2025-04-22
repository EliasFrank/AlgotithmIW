//给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。 
//
// 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 返回容器可以储存的最大水量。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 2 <= n <= 10⁵ 
// 0 <= height[i] <= 10⁴ 
// 
// Related Topics 贪心 数组 双指针 👍 3817 👎 0


package leetcode.editor.cn;

/**
 * 盛最多水的容器
 * @author HL
 * @date 2022-10-05 19:10:21
 */
class P11_ContainerWithMostWater{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P11_ContainerWithMostWater().new Solution();
		 int[] height = new int[]{1,1};
//		 int[] height = new int[]{1,8,6,2,5,4,8,3,7};
		 System.out.println(solution.maxArea(height));
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int maxArea(int[] height) {
		int left = 0, right = height.length - 1;
		int reuslt = 0;
		int min = 0;
		while (left < right) {
			if (height[left] > height[right]) {
				min = height[right];
				right--;
			} else {
				min = height[left];
				left++;
			}
			reuslt = Math.max(reuslt, min * (right - left + 1));
		}
		return reuslt;
    }

    /*public int maxArea(int[] height) {
    	int start = 0;
    	int end = height.length - 1;
    	int max = Integer.MIN_VALUE;
    	while (start < end) {
    		int tmpMin = 0;
    		if (height[start] > height[end]) {
    			tmpMin = height[end];
    			end--;
			} else {
    			tmpMin = height[start];
    			start++;
			}
			max = Math.max(max, (end - start + 1) * tmpMin);
		}
		return max;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}

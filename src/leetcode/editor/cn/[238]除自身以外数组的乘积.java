package leetcode.editor.cn;
//给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。 
//
// 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在 32 位 整数范围内。 
//
// 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [1,2,3,4]
//输出: [24,12,8,6]
// 
//
// 示例 2: 
//
// 
//输入: nums = [-1,1,0,-3,3]
//输出: [0,0,9,0,0]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁵ 
// -30 <= nums[i] <= 30 
// 输入 保证 数组 answer[i] 在 32 位 整数范围内 
// 
//
// 
//
// 进阶：你可以在 O(1) 的额外空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组 不被视为 额外空间。） 
//
// Related Topics 数组 前缀和 👍 1974 👎 0


class ProductOfArrayExceptSelf{
    public static void main(String[] args) {
        Solution solution = new ProductOfArrayExceptSelf().new Solution();
        int[] nums = new int[]{1,2,3,4};
//        int[] nums = new int[]{-1,1,0,-3,3};
        int[] ints = solution.productExceptSelf(nums);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i] + " ");
        }
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = nums[i - 1] * result[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }

        return result;
    }
//    public int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length], left = new int[nums.length], right = new int[nums.length];
//        left[0] = 1;
//        right[nums.length - 1] = 1;
//        for (int i = 1; i < nums.length; i++) {
//            left[i] = nums[i - 1] * left[i - 1];
//        }
//        for (int i = nums.length - 2; i >= 0; i--) {
//            right[i] = nums[i + 1] * right[i + 1];
//        }
//        for (int i = 0; i < result.length; i++) {
//            result[i] = left[i] * right[i];
//        }
//        return result;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

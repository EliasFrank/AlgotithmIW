package leetcode.editor.cn;
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 2630 👎 0


class FindFirstAndLastPositionOfElementInSortedArray{
    public static void main(String[] args) {
      Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
      int[] nums = new int[]{5,7,7,8,8,9,9,9,10};
//      int[] nums = new int[]{8,9,9,9,10};
//      int[] nums = new int[]{8};
      int target = 8;
        int[] ints = solution.searchRange(nums, target);
        System.out.println(ints[0] + " " + ints[1]);
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       public int[] searchRange(int[] nums, int target) {
           int[] result = new int[]{-1, -1};
           if (nums.length == 0) return result;
           result[0] = binarySearch(nums, target, 0, nums.length - 1, true);
           result[1] = binarySearch(nums, target, 0, nums.length - 1, false);
           return result;
       }
       public int binarySearch(int[] nums, int target, int left, int right, boolean isLeft) {
           int tempIndex = -1;
           int mid = left + (right - left) / 2;
           while (left <= right) {
               if (nums[mid] == target) {
                   tempIndex = mid;
                   if (isLeft)
                       right = mid - 1;
                   else left = mid + 1;
               } else if (nums[mid] <= target) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
               mid = left + (right - left) / 2;
           }
           return tempIndex;
       }
       public int binarySearch_IamSB(int[] nums, int target, int left, int right, boolean isLeft) {
           int mid = left + (right - left) / 2;
           while (left <= right) {
               if (nums[mid] == target) {
                   int tempIndex = -1;
                   //都二分了，还nm搁这分治呢，傻逼
                   if (isLeft) tempIndex = binarySearch(nums, target, left, mid - 1, isLeft);
                   else tempIndex = binarySearch(nums, target, mid + 1, right, isLeft);
                   return tempIndex == -1 ? mid : tempIndex;
               } else if (nums[mid] <= target) {
                   left = mid + 1;
               } else {
                   right = mid - 1;
               }
               mid = left + (right - left) / 2;
           }
           return -1;
       }

    public int[] searchRange1(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        if (nums.length == 0) return result;
        int left = 0, right = nums.length - 1;
        int mid = left + (right - left) / 2;
        while (left <= right) {
            if (nums[mid] == target) {
                result[0] = result[1] = mid;
                while (result[0] >= left && nums[result[0]] == target) result[0]--;
                while (result[1] <= right && nums[result[1]] == target) result[1]++;
                result[0]++;
                result[1]--;
                return result;
            } else if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = left + (right - left) / 2;
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

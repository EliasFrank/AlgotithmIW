package leetcode.editor.cn;
//给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//提示：
//
// 
// n == nums.length 
// 1 <= n <= 5 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
//
// 
//
// 进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
//
// Related Topics 数组 哈希表 分治 计数 排序 👍 2389 👎 0


class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
        int[] nums = {1,2,0,0,1,1,1};
        System.out.println(solution.majorityElement(nums));
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                num = nums[i];
            }
            count += (num == nums[i]) ? 1 : -1;
        }
        return num;
    }
    /*public int majorityElement(int[] nums) {
        int n = nums.length/2;
        if (n == 0) return nums[0];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int tempNum = map.get(nums[i]) + 1;
                if (tempNum > n) return nums[i];
                map.put(nums[i], tempNum);
            } else {
                map.put(nums[i], 1);
            }
        }
        return 0;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}

package leetcode.editor.cn;
//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。 
//
// 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处: 
//
// 
// 0 <= j <= nums[i] 
// i + j < n 
// 
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 示例 2: 
//
// 
//输入: nums = [2,3,0,1,4]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= nums.length <= 10⁴ 
// 0 <= nums[i] <= 1000 
// 题目保证可以到达 nums[n-1] 
// 
//
// Related Topics 贪心 数组 动态规划 👍 2464 👎 0

 
class JumpGameIi{
    public static void main(String[] args) {
        Solution solution = new JumpGameIi().new Solution();
//        int[] nums = new int[]{2,3,1,1,4};
//        int[] nums = new int[]{10,9,8,7,6,5,4,3,2,1,1,0};
//        int[] nums = new int[]{3,2,1,1};
//        int[] nums = new int[]{2,1,1,1,1};
//        int[] nums = new int[]{1,2,3};
        int[] nums = new int[]{2,3,1};
        int jump = solution.jump(nums);
        System.out.println(jump);
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        int step = 0;
        for (int i = 0; i < n - 1; ) {
            int j = i + 1, next = i;
            int max = nums[i];
            while (j - i <= nums[i] && j <= n - 1) {
                int temp = j + nums[j];
                if (j >= n - 1) return step + 1;
                if (temp >= max) {
                    next = j;
                    max = temp;
                }
                j++;
            }
            step++;
            i = next;
        }
        return step;
    }

//    public int jump(int[] nums) {
//        int n = nums.length - 1;
//        if (n == 0) return 0;
//        int maxIndex = 1, step = 0;
//        for (int i = 0; i < nums.length - 1; ) {
//            int max = Integer.MIN_VALUE;
//            int nowIndex = i;
//            for (int j = 1; nowIndex < n && j <= nums[i]; j++) {
//                nowIndex = i + j;
//                if (nowIndex >= n) return ++step;
//                if ((nums[nowIndex] + nowIndex) >= max) {
//                    maxIndex = nowIndex;
//                    max = nums[nowIndex] + nowIndex;
//                }
//            }
//            i = maxIndex;
//            step++;
//        }
//        return step;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package leetcode.editor.cn;
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
//
// Related Topics 数组 回溯 👍 1548 👎 0


import java.util.*;

class PermutationsIi{
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        int[] nums = new int[]{3,3,0,3};
//      int[] nums = new int[]{1};
        List<List<Integer>> permute = solution.permuteUnique(nums);
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(64);
        List<Integer> output = new ArrayList<>();
        Arrays.sort(nums);
        boolean[] vis = new boolean[nums.length];
        find(nums, output, result, vis);
        return result;
    }

    private void find(int[] nums, List<Integer> output, List<List<Integer>> result, boolean[] vis) {
        if (output.size() >= nums.length) {
            result.add(new ArrayList<>(output));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            if (vis[j] || (j > 0 && nums[j] == nums[j - 1] && !vis[j - 1])) continue;
            output.add(nums[j]);
            vis[j] = true;
            find(nums, output, result, vis);
            vis[j] = false;
            output.remove(output.size() - 1);
        }
    }
   }
//leetcode submit region end(Prohibit modification and deletion)

}

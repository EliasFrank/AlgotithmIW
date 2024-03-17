package leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
//
// Related Topics 数组 回溯 👍 2836 👎 0


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutations{
    public static void main(String[] args) {
      Solution solution = new Permutations().new Solution();
      int[] nums = new int[]{1,2,3};
//      int[] nums = new int[]{1};
        List<List<Integer>> permute = solution.permute(nums);
        for (List<Integer> integers : permute) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>(64);
        List<Integer> temp = new ArrayList<>();
        for (int num : nums) {
            temp.add(num);
        }
        find(nums.length - 1, temp, result, 0);
        return result;
    }

       private void find(int length, List<Integer> temp, List<List<Integer>> result, int index) {
           if (index >= length) {
               result.add(new ArrayList<>(temp));
               return;
           }
           for (int j = index; j < temp.size(); j++) {
               Collections.swap(temp, j, index);
               find(length, temp, result, index + 1);
               Collections.swap(temp, j, index);
           }
       }
//       private void find(int[] nums, List<Integer> temp, List<List<Integer>> result) {
//           if (temp.size() >= nums.length) {
//               result.add(new ArrayList<>(temp));
//               return;
//           }
//           for (int j = 0; j < nums.length; j++) {
//               if (temp.contains(nums[j])) continue;
//               temp.add(nums[j]);
//               find(nums, temp, result);
//               temp.remove(temp.size() - 1);
//           }
//       }
   }
//leetcode submit region end(Prohibit modification and deletion)

}

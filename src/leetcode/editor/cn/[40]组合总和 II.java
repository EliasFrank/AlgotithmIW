package leetcode.editor.cn;
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
//
// Related Topics 数组 回溯 👍 1524 👎 0


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class CombinationSumIi{
    public static void main(String[] args) {
      Solution solution = new CombinationSumIi().new Solution();
        int[] candidates = new int[] {7};
        int target = 7;
        List<List<Integer>> lists = solution.combinationSum2(candidates, target);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + "");
            }
            System.out.println();
        }
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        combinationSum(candidates, target, 0, new LinkedList<>());
        return result;
    }
       public void combinationSum(int[] candidates, int target, int index, List<Integer> nums) {
           if (target == 0) {
               List<Integer> temp = new LinkedList<>(nums);
               result.add(temp);
           }
           for (int i = index; i < candidates.length; i++) {
               if (target - candidates[i] < 0) break;
               nums.add(candidates[i]);
               combinationSum(candidates, target - candidates[i], i + 1, nums);
               int nextInteger = i + 1;
               while (nextInteger < candidates.length && candidates[i] == candidates[nextInteger]) nextInteger++;
               i = nextInteger - 1;
               nums.remove(nums.size() - 1);
           }
       }
}
//leetcode submit region end(Prohibit modification and deletion)

}

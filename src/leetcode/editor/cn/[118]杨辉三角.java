//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 👍 868 👎 0


package leetcode.editor.cn;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角
 * @author HL
 * @date 2022-11-13 21:27:24
 */
class P118_PascalsTriangle{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P118_PascalsTriangle().new Solution();
		 List<List<Integer>> generate = solution.generate(1);
		 for (int i = 0; i < generate.size(); i++) {
			 for (int j = 0; j < generate.get(i).size(); j++) {
				 System.out.print(generate.get(i).get(j) + " ");
			 }
			 System.out.println();
		 }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		result.add(Collections.singletonList(1));
		for (int i = 2; i <= numRows; i++) {
			ArrayList<Integer> row = new ArrayList<>(i);
			row.add(1);
			List<Integer> above = result.get(i - 2);
			for (int j = 1; j < i - 1; j++) {
				row.add(above.get(j) + above.get(j - 1));
			}
			row.add(1);
			result.add(row);
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

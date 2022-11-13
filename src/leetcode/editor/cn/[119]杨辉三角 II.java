//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。 
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
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 439 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 杨辉三角 II
 * @author HL
 * @date 2022-11-13 21:42:00
 */
class P119_PascalsTriangleIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P119_PascalsTriangleIi().new Solution();
		 List<Integer> generate = solution.getRow(4);
		 for (int j = 0; j < generate.size(); j++) {
			 System.out.print(generate.get(j) + " ");
		 }
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> getRow(int rowIndex) {
		List<Integer> result = new ArrayList<>();
		result.add(1);
		for (int i = 1; i <= rowIndex; i++) {
			result.add(1);
			for (int j = i - 1; j > 0; j--) {
				result.set(j, result.get(j) + result.get(j - 1));
			}
		}
		return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ["2", "9"] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 2162 👎 0


package leetcode.editor.cn;

import java.util.*;

/**
 * 电话号码的字母组合
 * @author HL
 * @date 2022-10-24 18:57:43
 */
class P17_LetterCombinationsOfAPhoneNumber{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P17_LetterCombinationsOfAPhoneNumber().new Solution();
		 List<String> list = solution.letterCombinations("2345");
		 list.forEach(System.out::println);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits.length() == 0) return result;
		Map<Character, List<String>> nums = new HashMap<>(){{
			put('2', Arrays.asList("a", "b", "c"));
			put('3', Arrays.asList("d", "e", "f"));
			put('4', Arrays.asList("g", "h", "i"));
			put('5', Arrays.asList("j", "k", "l"));
			put('6', Arrays.asList("m", "n", "o"));
			put('7', Arrays.asList("p", "q", "r", "s"));
			put('8', Arrays.asList("t", "u", "v"));
			put('9', Arrays.asList("w", "x", "y", "z"));
		}};
		get(digits, nums, new StringBuilder(), result, 0);
		return result;
    }
    public void get(String digits, Map<Character, List<String>> nums, StringBuilder tempString, List<String> result, int index) {
    	if (tempString.length() == digits.length()) {
			result.add(tempString.toString());
			return;
		}
		for (int i = index; i < digits.length(); i++) {
			List<String> list = nums.get(digits.charAt(i));
			for (int j = 0; j <list.size(); j++) {
				tempString.append(list.get(j));
				get(digits, nums, tempString, result, i + 1);
				tempString.deleteCharAt(tempString.length() - 1);
			}
		}
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

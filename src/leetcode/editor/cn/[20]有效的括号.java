//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 每个右括号都有一个对应的相同类型的左括号。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 👍 3536 👎 0


package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 有效的括号
 * @author HL
 * @date 2022-10-06 18:29:46
 */
class P20_ValidParentheses{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P20_ValidParentheses().new Solution();

		 boolean valid = solution.isValid("]");
		 System.out.println(valid);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
		LinkedList<Character> stack = new LinkedList<>();
		for (int i = 0; i < s.length(); i++) {
			char tmp = s.charAt(i);
			if (tmp == '(' || tmp == '{' || tmp == '[') {
				stack.offer(tmp);
			} else {
				Character character = stack.peekLast();
				if(remove(tmp, character, stack))
					return false;
			}
		}
		return stack.isEmpty();
    }

	private boolean remove(char tmp, Character character, LinkedList<Character> stack) {
    	if (stack.isEmpty()) return true;
    	int i = stack.size();
		if (tmp == ')' && character == '(') stack.pollLast();
		if (tmp == ']' && character == '[') stack.pollLast();
		if (tmp == '}' && character == '{') stack.pollLast();
		return i == stack.size();
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

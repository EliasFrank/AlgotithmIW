package leetcode.editor.cn;
//如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。 
//
// 字母和数字都属于字母数字字符。 
//
// 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入: s = "A man, a plan, a canal: Panama"
//输出：true
//解释："amanaplanacanalpanama" 是回文串。
// 
//
// 示例 2： 
//
// 
//输入：s = "race a car"
//输出：false
//解释："raceacar" 不是回文串。
// 
//
// 示例 3： 
//
// 
//输入：s = " "
//输出：true
//解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
//由于空字符串正着反着读都一样，所以是回文串。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 2 * 10⁵ 
// s 仅由可打印的 ASCII 字符组成 
// 
//
// Related Topics 双指针 字符串 👍 811 👎 0

 
class ValidPalindrome{
    public static void main(String[] args) {
        Solution solution = new ValidPalindrome().new Solution();
//        String s =  "A man, a plan, a canal: Panama";
        String s =  "0P";
        System.out.println(solution.isPalindrome(s));
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            while (left <= right && !(isBigChar(s.charAt(left)) || isSmallChar(s.charAt(left)) || isNumber(s.charAt(left)))) left++;
            while (right >= left && !(isBigChar(s.charAt(right)) || isSmallChar(s.charAt(right))|| isNumber(s.charAt(right)))) right--;
            if (right <= left) return true;
            char tl = s.charAt(left++), tr = s.charAt(right--);
            if (isSmallChar(tl)) tl -= 32;
            if (isSmallChar(tr)) tr -= 32;
            if (tl != tr) return false;
        }
        return true;
    }
    private boolean isBigChar(char c) {
        return 'A' <= c && c <= 'Z';
    }
    private boolean isSmallChar(char c) {
        return 'a' <= c && c <= 'z';
    }
    private boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

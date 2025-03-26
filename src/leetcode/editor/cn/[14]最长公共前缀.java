package leetcode.editor.cn;
//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 如果非空，则仅由小写英文字母组成 
// 
//
// Related Topics 字典树 字符串 👍 3306 👎 0

 
class LongestCommonPrefix{
    public static void main(String[] args) {
        Solution solution = new LongestCommonPrefix().new Solution();
//        String[] strs = new String[]{"abc"};
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       public String longestCommonPrefix(String[] strs) {
           if (strs.length == 0 || strs[0].length() == 0) return "";
           StringBuilder sb = new StringBuilder();
           int index = 0;
           while (strs[0].length() > index) {
               char tmp = strs[0].charAt(index);
               int i = 0;
               for (; i < strs.length; i++) {
                   if (index >= strs[i].length() || strs[i].charAt(index) != tmp) break;
               }
               if (i == strs.length) {
                   sb.append(tmp);
                   index++;
               } else {
                   break;
               }
           }
           return sb.toString();
       }
}
//leetcode submit region end(Prohibit modification and deletion)

}

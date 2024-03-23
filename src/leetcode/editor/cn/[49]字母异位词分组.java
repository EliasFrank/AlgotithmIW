package leetcode.editor.cn;
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 10⁴ 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
//
// Related Topics 数组 哈希表 字符串 排序 👍 1857 👎 0


import java.util.*;

class GroupAnagrams{
    public static void main(String[] args) {
      Solution solution = new GroupAnagrams().new Solution();
//      String[] strs = new String[]{"ddddddddddg","dgggggggggg"};
      String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "z"};
//      String[] strs = new String[]{""};
        List<List<String>> lists = solution.groupAnagrams(strs);
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length <= 1) {
            return new ArrayList<>(){{add(Collections.singletonList(strs[0]));}};
        }
        Map<String, List<String>> result = new HashMap<>();
        for (String str : strs) {
            StringBuilder temp = new StringBuilder();
            int[] charIndex = new int[123];
            for (int i = 0; i < str.length(); i++) {
                charIndex[str.charAt(i)]++;
            }
            for (int i = 97; i < charIndex.length; i++) {
                if (charIndex[i] > 0) temp.append(i).append(charIndex[i]);
            }
            String key = temp.toString();
            List<String> tempResult = result.getOrDefault(key, new ArrayList<>());
            tempResult.add(str);
            result.put(key, tempResult);
        }
        return new ArrayList<>(){{addAll(result.values());}};
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

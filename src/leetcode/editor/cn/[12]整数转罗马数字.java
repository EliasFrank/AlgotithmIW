 //罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
//
// 
//字符          数值
//I             1
//V             5
//X             10
//L             50
//C             100
//D             500
//M             1000 
//
// 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做 XXVII, 即为 XX + V + 
//II 。 
//
// 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5
// 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况： 
//
// 
// I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。 
// X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
// C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。 
// 
//
// 给你一个整数，将其转为罗马数字。 
//
// 
//
// 示例 1: 
//
// 
//输入: num = 3
//输出: "III" 
//
// 示例 2: 
//
// 
//输入: num = 4
//输出: "IV" 
//
// 示例 3: 
//
// 
//输入: num = 9
//输出: "IX" 
//
// 示例 4: 
//
// 
//输入: num = 58
//输出: "LVIII"
//解释: L = 50, V = 5, III = 3.
// 
//
// 示例 5: 
//
// 
//输入: num = 1994
//输出: "MCMXCIV"
//解释: M = 1000, CM = 900, XC = 90, IV = 4. 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 3999 
// 
// Related Topics 哈希表 数学 字符串 👍 980 👎 0


package leetcode.editor.cn;

 import java.util.HashMap;
 import java.util.Map;
 import java.util.Set;

 /**
 * 整数转罗马数字
 * @author HL
 * @date 2022-10-16 20:54:38
 */
class P12_IntegerToRoman{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P12_IntegerToRoman().new Solution();
		 String s = solution.intToRoman(3999);
		 System.out.println(s);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String intToRoman(int num) {
		String[] thousands = {"", "M", "MM", "MMM"};
		String[] hundreds  = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
		String[] tens      = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
		String[] ones      = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
		StringBuilder sb = new StringBuilder();
		sb.append(thousands[num / 1000]);
		sb.append(hundreds[(num % 1000) / 100]);
		sb.append(tens[(num % 100) / 10]);
		sb.append(ones[(num % 10)]);
		return sb.toString();
	}
	/*public String intToRoman(int num) {
		Map<Integer, String> map = new HashMap<>(16){{
			put(1,"I");
			put(4,"IV");
			put(5,"V");
			put(9,"IX");
			put(10,"X");
			put(40,"XL");
			put(50,"L");
			put(90,"XC");
			put(100,"C");
			put(400,"CD");
			put(500,"D");
			put(900,"CM");
			put(1000,"M");
		}};
		StringBuilder sb = new StringBuilder();
		for (int i : new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1}) {
			int temp = num / i;
			for (; temp > 0; temp--) {
				sb.append(map.get(i));
			}
			num %= i;
		}
		return sb.toString();
	}*/
}
//leetcode submit region end(Prohibit modification and deletion)

}

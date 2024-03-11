package leetcode.editor.cn;
//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。 
//
// 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。 
//
// 
//
// 示例 1: 
//
// 
//输入: num1 = "2", num2 = "3"
//输出: "6" 
//
// 示例 2: 
//
// 
//输入: num1 = "123", num2 = "456"
//输出: "56088" 
//
// 
//
// 提示： 
//
// 
// 1 <= num1.length, num2.length <= 200 
// num1 和 num2 只能由数字组成。 
// num1 和 num2 都不包含任何前导零，除了数字0本身。 
// 
//
// Related Topics 数学 字符串 模拟 👍 1326 👎 0

 
class MultiplyStrings{
    public static void main(String[] args) {
        Solution solution = new MultiplyStrings().new Solution();
        String num1 = "2";
        String num2 = "3";
//        String num1 = "123456789";
//        String num2 = "987654321";
        String multiply = solution.multiply(num1, num2);
        System.out.println(multiply.toString());

//        StringBuilder multiply = solution.multiply(num1, '5',0);
//        StringBuilder add = solution.add(new StringBuilder("944977892635269"), new StringBuilder("9876543120000000"));
//        System.out.println(add.toString());
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;
        int len1 = num1.length();
        int len2 = num2.length();
        int[] resArray = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                resArray[i + j + 1] += x * y;
            }
        }
        for (int i = resArray.length - 1; i >= 1; i--) {
            resArray[i - 1] += resArray[i] / 10;
            resArray[i] = resArray[i] % 10;
        }
        int i = resArray[0] == 0 ? 1 : 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (; i < resArray.length; i++) {
            stringBuilder.append(resArray[i]);
        }
        return stringBuilder.toString();
    }
    public String multiplyUseAdd(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) return "0";
        if ("1".equals(num1)) return num2;
        if ("1".equals(num2)) return num1;
        StringBuilder sb = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0 ; i--) {
            if (num2.charAt(i) == '0') continue;
            StringBuilder multiply = multiply(num1, num2.charAt(i), num2.length() - 1 - i);
//            System.out.println("temp num = " + multiply.toString());
            sb = add(sb, multiply);
//            System.out.println("total num = " + sb.toString());
        }
        return sb.toString();
    }
    public StringBuilder multiply(String num1, char num2, int hundred) {
        StringBuilder sb = new StringBuilder();
        if (num2 == '1') {
            sb.append(num1);
            for (int i = 0; i < hundred; i++) {
                sb.append(0);
            }
            return sb;
        }
        int temp = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int num = (num1.charAt(i) - '0') * (num2 - '0') + temp;
            sb.append(num % 10);
            temp = num / 10;
        }
        if (temp != 0) sb.append(temp);
        sb.reverse();
        for (int i = 0; i < hundred; i++) {
            sb.append(0);
        }
        return sb;
    }
    public StringBuilder add(StringBuilder num1, StringBuilder num2) {
        StringBuilder sb = new StringBuilder();
        int temp = 0;

        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;

        for (; len1 >= 0 && len2 >= 0; len1--, len2--) {
            int num = (num1.charAt(len1) - '0') + (num2.charAt(len2) - '0') + temp;
            sb.append(num % 10);
            temp = num / 10;
        }
        while (len1 >= 0) {
            int tmp = num1.charAt(len1) - '0' + temp;
            sb.append(tmp % 10);
            temp = tmp / 10;
            len1--;
        }
        while (len2 >= 0) {
            int tmp = num2.charAt(len2) - '0' + temp;
            sb.append(tmp % 10);
            temp = tmp / 10;
            len2--;
        }
        if (temp != 0) sb.append(temp);
        sb.reverse();
        return sb;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

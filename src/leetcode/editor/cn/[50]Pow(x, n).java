//实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xⁿ ）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xⁿ <= 104 
// 
// Related Topics 递归 数学 👍 1054 👎 0


package leetcode.editor.cn;

/**
 * Pow(x, n)
 * @author HL
 * @date 2022-10-10 20:34:59
 */
class P50_PowxN{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P50_PowxN().new Solution();
		 double v = solution.myPow(2, -2147483648);
		 System.out.println(v);
	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public double myPow(double x, int n) {
		//n = -2147483648的情况，转换为正数会越界
	 	long N = n;
    	if (n == 0) return 1;
    	else if (N < 0) {
    		x = 1 / x;
			N  = -N;
		}
    	double ans = 1;
    	double tmp = x;
    	while (N > 0) {
			if (N % 2 == 1) {
				ans *= tmp;
			}
			tmp *= tmp;
			N /= 2;
		}
    	return ans;
    }
    /*public double myPow(double x, int n) {
    	if (n == 0) return 1;
    	if (n == 1) return x;
    	else if (n < 0) {
    		x = 1 / x;
    		n  = -n;
		}
    	return pow(x, n);
    }*/

    /*private double pow(double x, int n) {
		if (n == 0)
			return 1;

		double y = pow(x, n / 2);
		return n % 2 == 0 ? y * y : y * y * x;
	}*/
	/*private double pow(double x, int n) {
		if (n == 1)
			return x;
		if (n % 2 == 1) {
			n--;
			return x * pow(x * x, n/2);
		}
		return pow(x * x, n / 2);
	}*/
}
//leetcode submit region end(Prohibit modification and deletion)

}

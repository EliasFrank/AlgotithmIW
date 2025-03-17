package leetcode.editor.cn;
//在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。 
//
// 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。 
//
// 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的
//。 
//
// 
//
// 示例 1: 
//
// 
//输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
//输出: 3
//解释:
//从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
//开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
//开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
//开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
//开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
//开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
//因此，3 可为起始索引。 
//
// 示例 2: 
//
// 
//输入: gas = [2,3,4], cost = [3,4,3]
//输出: -1
//解释:
//你不能从 0 号或 1 号加油站出发，因为没有足够的汽油可以让你行驶到下一个加油站。
//我们从 2 号加油站出发，可以获得 4 升汽油。 此时油箱有 = 0 + 4 = 4 升汽油
//开往 0 号加油站，此时油箱有 4 - 3 + 2 = 3 升汽油
//开往 1 号加油站，此时油箱有 3 - 3 + 3 = 3 升汽油
//你无法返回 2 号加油站，因为返程需要消耗 4 升汽油，但是你的油箱只有 3 升汽油。
//因此，无论怎样，你都不可能绕环路行驶一周。 
//
// 
//
// 提示: 
//
// 
// gas.length == n 
// cost.length == n 
// 1 <= n <= 10⁵ 
// 0 <= gas[i], cost[i] <= 10⁴ 
// 
//
// Related Topics 贪心 数组 👍 1820 👎 0

 
class GasStation{
    public static void main(String[] args) {
        Solution solution = new GasStation().new Solution();
//        int[] gas = new int[] {1,2,3,4,5};
//        int[] cost = new int[] {3,4,5,1,2};
        int[] gas = new int[] {4,5,3,1,4};
        int[] cost = new int[] {5,4,3,4,2};
        System.out.println(solution.canCompleteCircuit(gas, cost));
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
       for (int i = 0; i < gas.length; ) {
           int start = i, left = 0, step = 0;
           while (step < gas.length) {
               left = left + gas[start] - cost[start];
               start++;
               if (left < 0) {
                   break;
               }
               step++;
               if (start >= gas.length) start = 0;
           }
           if (step == gas.length) return i;
           else i = i + step + 1; // 优化下一步，如果从a到不了c，那么ac中间的b也到不了，直接从c=1开始走。如果i大于数组长度，则说明无解
       }
       return -1;
    }
    /*public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if (nextStep(gas, cost, 0, i, 0, gas.length - 1)) {
                return i;
            };
        }
        return -1;
    }
    private boolean nextStep(int[] gas, int[] cost, int start, int cur, int left, int length) {
        if (start == gas.length) {
            return true;
        }
        if (cur > length) {
            cur = 0;
        }
        left += gas[cur];
        if (left >= cost[cur]) {
            return nextStep(gas, cost, start + 1, cur + 1, left - cost[cur], length);
        } else {
            return false;
        }
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}

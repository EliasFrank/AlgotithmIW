//给定链表头结点 head，该链表上的每个结点都有一个 唯一的整型值 。同时给定列表 nums，该列表是上述链表中整型值的一个子集。 
//
// 返回列表 nums 中组件的个数，这里对组件的定义为：链表中一段最长连续结点的值（该值必须在列表 nums 中）构成的集合。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [0,1,2,3], nums = [0,1,3]
//输出: 2
//解释: 链表中,0 和 1 是相连接的，且 nums 中不包含 2，所以 [0, 1] 是 nums 的一个组件，同理 [3] 也是一个组件，故返回 2。 
//
//
// 示例 2： 
//
// 
//
// 
//输入: head = [0,1,2,3,4], nums = [0,3,1,4]
//输出: 2
//解释: 链表中，0 和 1 是相连接的，3 和 4 是相连接的，所以 [0, 1] 和 [3, 4] 是两个组件，故返回 2。 
//
// 
//
// 提示： 
//
// 
// 链表中节点数为n 
// 1 <= n <= 10⁴ 
// 0 <= Node.val < n 
// Node.val 中所有值 不同 
// 1 <= nums.length <= n 
// 0 <= nums[i] < n 
// nums 中所有值 不同 
// 
// Related Topics 数组 哈希表 链表 👍 163 👎 0


package leetcode.editor.cn;

import com.datastruct.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 链表组件
 * @author HL
 * @date 2022-10-12 19:27:36
 */
class P817_LinkedListComponents{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P817_LinkedListComponents().new Solution();
		 ListNode listNode = new ListNode(0);
		 listNode.next = new ListNode(1);
		 listNode.next.next = new ListNode(2);
		 listNode.next.next.next = new ListNode(3);
		 listNode.next.next.next.next = new ListNode(4);
		 int i = solution.numComponents(listNode, new int[]{0,1,3,4});
		 System.out.println(i);

	 }
	 
//力扣代码
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int numComponents(ListNode head, int[] nums) {
		Set<Integer> set = new HashSet<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		int max = 0, count = 0;
		while (head != null) {
			if (set.contains(head.val)) {
				count++;
			} else {
				if (count > 0) max++;
				count = 0;
			}
			head = head.next;
		}
		if (count > 0) max++;
		return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

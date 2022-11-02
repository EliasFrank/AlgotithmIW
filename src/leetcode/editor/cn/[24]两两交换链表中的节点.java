//给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
// Related Topics 递归 链表 👍 1615 👎 0


package leetcode.editor.cn;

import com.datastruct.ListNode;

/**
 * 两两交换链表中的节点
 * @author HL
 * @date 2022-11-02 21:23:45
 */
class P24_SwapNodesInPairs{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P24_SwapNodesInPairs().new Solution();
	     ListNode list = new ListNode(1);
	     list.next = new ListNode(2);
	     list.next.next = new ListNode(3);
	     list.next.next.next = new ListNode(4);
	     list.next.next.next.next = new ListNode(5);
		 ListNode listNode = solution.swapPairs(list);
		 while (listNode != null) {
			 System.out.print(listNode.val + " ");
			 listNode = listNode.next;
		 }
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
    public ListNode swapPairs(ListNode head) {
    	if (head == null) return null;
    	ListNode next = head.next;
    	if (next == null) return head;
    	ListNode pre = new ListNode(-1);
		ListNode newHead = pre;
    	while (next != null) {
    		head.next = next.next;
    		next.next = head;
			pre.next = next;
			pre = head;
    		head = head.next;
			if (head == null) break;
    		next = head.next;
		}
		return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

//给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
//
// 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针 👍 2255 👎 0


package leetcode.editor.cn;

import com.datastruct.ListNode;

/**
 * 删除链表的倒数第 N 个结点
 * @author HL
 * @date 2022-10-09 21:06:18
 */
class P19_RemoveNthNodeFromEndOfList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P19_RemoveNthNodeFromEndOfList().new Solution();
		 ListNode listNode = new ListNode(1);
		 listNode.next = new ListNode(2);
		 listNode.next.next = new ListNode(3);
		 listNode.next.next.next = new ListNode(4);
		 listNode.next.next.next.next = new ListNode(5);
		 ListNode listNode1 = solution.removeNthFromEnd(listNode, 5);
		 while (listNode1 != null) {
			 System.out.print(listNode1.val + " ");
			 listNode1 = listNode1.next;
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
		int i = find(head, n);
		if (i == n) head = head.next;
		return head;
    }

	private int find(ListNode head, int n) {
		if (head == null) return 0;
		int num = find(head.next, n);
		if (num == n) {
			head.next = head.next.next;
		}
		return num + 1;
	}
}
//leetcode submit region end(Prohibit modification and deletion)

}

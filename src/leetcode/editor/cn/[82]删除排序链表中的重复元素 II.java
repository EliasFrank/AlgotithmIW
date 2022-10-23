//给定一个已排序的链表的头 head ， 删除原始链表中所有重复数字的节点，只留下不同的数字 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序 排列 
// 
// Related Topics 链表 双指针 👍 1007 👎 0


package leetcode.editor.cn;

import com.datastruct.ListNode;

/**
 * 删除排序链表中的重复元素 II
 * @author HL
 * @date 2022-10-22 20:08:13
 */
class P82_RemoveDuplicatesFromSortedListIi{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P82_RemoveDuplicatesFromSortedListIi().new Solution();
		 ListNode listNode = new ListNode(1);
		 listNode.next = new ListNode(2);
		 listNode.next.next = new ListNode(3);
		 listNode.next.next.next = new ListNode(3);
		 listNode.next.next.next.next = new ListNode(4);
		 listNode.next.next.next.next.next = new ListNode(4);
		 listNode.next.next.next.next.next.next = new ListNode(5);
		 ListNode listNode1 = solution.deleteDuplicates(listNode);
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
    public ListNode deleteDuplicates(ListNode head) {
    	if (head == null) return null;
		ListNode newHead = new ListNode(0, head);
		ListNode cur = newHead;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				int tmp = head.val;
				while (head != null && tmp == head.val) {
					head = head.next;
				}
				cur.next = head;
			} else {
				head = head.next;
				cur = cur.next;
			}
		}
		return newHead.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

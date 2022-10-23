//给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,1,2]
//输出：[1,2]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,2,3,3]
//输出：[1,2,3]
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
// Related Topics 链表 👍 874 👎 0


package leetcode.editor.cn;

import com.datastruct.ListNode;

/**
 * 删除排序链表中的重复元素
 * @author HL
 * @date 2022-10-22 20:00:14
 */
class P83_RemoveDuplicatesFromSortedList{
	 public static void main(String[] args) {
	 	 //测试代码
	 	 Solution solution = new P83_RemoveDuplicatesFromSortedList().new Solution();
		 ListNode listNode = new ListNode(1);
		 listNode.next = new ListNode(1);
		 listNode.next.next = new ListNode(2);
		 listNode.next.next.next = new ListNode(3);
		 listNode.next.next.next.next = new ListNode(3);
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
    	ListNode newHead = head;
    	ListNode pre = head;
		while (head != null) {
			head = head.next;
			while (head != null && pre.val == head.val) {
				head = head.next;
			}
			pre.next = head;
			pre = head;
		}
		return newHead;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

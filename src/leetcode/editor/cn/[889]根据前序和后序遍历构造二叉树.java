package leetcode.editor.cn;
//给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵
//树的后序遍历，重构并返回二叉树。 
//
// 如果存在多个答案，您可以返回其中 任何 一个。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
//输出：[1,2,3,4,5,6,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [1], postorder = [1]
//输出: [1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= preorder.length <= 30 
// 1 <= preorder[i] <= preorder.length 
// preorder 中所有值都 不同 
// postorder.length == preorder.length 
// 1 <= postorder[i] <= postorder.length 
// postorder 中所有值都 不同 
// 保证 preorder 和 postorder 是同一棵二叉树的前序遍历和后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 370 👎 0


import com.datastruct.TreeNode;

import java.util.HashMap;
import java.util.Map;

class ConstructBinaryTreeFromPreorderAndPostorderTraversal{
    public static void main(String[] args) {
      Solution solution = new ConstructBinaryTreeFromPreorderAndPostorderTraversal().new Solution();
      int[] preorder = new int[]{1,2,4,5,3,6,7};
//      int[] preorder = new int[]{2,1,3};
      int[] postorder = new int[]{4,5,2,6,7,3,1};
//      int[] postorder = new int[]{3,1,2};
        TreeNode treeNode = solution.constructFromPrePost(preorder, postorder);
        System.out.println(treeNode);
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)

class Solution {
        int i = 0;
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postMap = new HashMap<>();
        for (int i1 = 0; i1 < postorder.length; i1++) {
            postMap.put(postorder[i1], i1);
        }
        return construct(preorder, postorder, 0, postorder.length - 2, postMap);
    }
    public TreeNode construct(int[] preorder, int[] postorder, int begin, int end, Map<Integer, Integer> postMap) {
        TreeNode treeNode = new TreeNode(preorder[i]);
        if (begin > end) return treeNode;
        if (i >= postorder.length - 1) return treeNode;
        i++;
        int index = postMap.get(preorder[i]);
        treeNode.left = construct(preorder, postorder, begin, index - 1, postMap);
        if (index >= end) return treeNode;
        i++;
        begin = index + 1;
        index = postMap.get(preorder[i]);
        treeNode.right = construct(preorder, postorder, begin, index - 1, postMap);
        return treeNode;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

package leetcode.editor.cn;
//给定一个 n 叉树的根节点
// root ，返回 其节点值的 后序遍历 。 
//
// n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[5,6,3,2,4,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[2,6,14,11,7,3,12,8,4,13,9,10,5,1]
// 
//
// 
//
// 提示： 
//
// 
// 节点总数在范围 [0, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// n 叉树的高度小于或等于 1000 
// 
//
// 
//
// 进阶：递归法很简单，你可以使用迭代法完成此题吗? 
//
// Related Topics 栈 树 深度优先搜索 👍 318 👎 0

import java.util.ArrayList;
import java.util.List;

class NAryTreePostorderTraversal{
  public static void main(String[] args) {
      NAryTreePostorderTraversal obj = new NAryTreePostorderTraversal();
      Solution solution = obj.new Solution();
      Node root = obj.new Node(1);
      root.children = new ArrayList<Node>(){{
         add(obj.new Node(3));
         add(obj.new Node(2));
         add(obj.new Node(4));
      }};
      root.children.get(0).children = new ArrayList<Node>(){{
          add(obj.new Node(5));
          add(obj.new Node(6));
      }};
      List<Integer> postorder = solution.postorder(root);
      for (int i = 0; i < postorder.size(); i++) {
          System.out.print(postorder.get(i) + " ");
      }
  }
 
 //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        for (int i = 0; root.children != null && i < root.children.size(); i++) {
            result.addAll(postorder(root.children.get(i)));
        }
        result.add(root.val);
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
}

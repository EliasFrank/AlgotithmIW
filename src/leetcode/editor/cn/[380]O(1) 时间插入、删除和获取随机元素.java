package leetcode.editor.cn;
//实现RandomizedSet 类： 
//
// 
// 
// 
// RandomizedSet() 初始化 RandomizedSet 对象 
// bool insert(int val) 当元素 val 不存在时，向集合中插入该项，并返回 true ；否则，返回 false 。 
// bool remove(int val) 当元素 val 存在时，从集合中移除该项，并返回 true ；否则，返回 false 。 
// int getRandom() 随机返回现有集合中的一项（测试用例保证调用此方法时集合中至少存在一个元素）。每个元素应该有 相同的概率 被返回。 
// 
// 
// 
//
// 你必须实现类的所有函数，并满足每个函数的 平均 时间复杂度为 O(1) 。 
//
// 
//
// 示例： 
//
// 
//输入
//["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", 
//"insert", "getRandom"]
//[[], [1], [2], [2], [], [1], [2], []]
//输出
//[null, true, false, true, 2, true, false, 2]
//
//解释
//RandomizedSet randomizedSet = new RandomizedSet();
//randomizedSet.insert(1); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//randomizedSet.remove(2); // 返回 false ，表示集合中不存在 2 。
//randomizedSet.insert(2); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//randomizedSet.getRandom(); // getRandom 应随机返回 1 或 2 。
//randomizedSet.remove(1); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//randomizedSet.insert(2); // 2 已在集合中，所以返回 false 。
//randomizedSet.getRandom(); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
// 
//
// 
//
// 提示： 
//
// 
// -2³¹ <= val <= 2³¹ - 1 
// 最多调用 insert、remove 和 getRandom 函数 2 * 10⁵ 次 
// 在调用 getRandom 方法时，数据结构中 至少存在一个 元素。 
// 
//
// Related Topics 设计 数组 哈希表 数学 随机化 👍 921 👎 0


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class InsertDeleteGetrandomO1{
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new InsertDeleteGetrandomO1().new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
        System.out.println(randomizedSet.remove(2)); // 返回 false ，表示集合中不存在 2 。
        System.out.println(randomizedSet.insert(2)); // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
        System.out.println(randomizedSet.getRandom()); // getRandom 应随机返回 1 或 2 。
        System.out.println(randomizedSet.remove(1)); // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
        System.out.println(randomizedSet.insert(2)); // 2 已在集合中，所以返回 false 。
        System.out.println(randomizedSet.getRandom()); // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class RandomizedSet {
        Node[] element;
        List<Integer> nums = new ArrayList();
        int size = 1000;
        Random random = new Random();
        public RandomizedSet() {
            element = new Node[1000];
        }

        public boolean insert(int val) {
            int hash = Math.abs(Integer.valueOf(val).hashCode() % size);
            if (element[hash] == null) {
                element[hash] = new Node(val);
                nums.add(val);
            } else {
                Node tmp = element[hash];
                while (tmp.val != val && tmp.next != null) tmp = tmp.next;
                if (tmp.val == val) return false;
                else {
                    tmp.next = new Node(val);
                    nums.add(val);
                }
            }
            return true;
        }

        public boolean remove(int val) {
            int hash = Math.abs(Integer.valueOf(val).hashCode() % size);
            Node tmp = element[hash];
            if (tmp == null) return false;
            if (tmp.val == val) {
                element[hash] = tmp.next;
                nums.remove(Integer.valueOf(val));
                return true;
            }
            while (tmp.next != null && tmp.next.val != val) tmp = tmp.next;
            if (tmp.next == null && tmp.val != val) return false;
            else {
                tmp.next = tmp.next.next;
                nums.remove(Integer.valueOf(val));
            }
            return true;
        }

        public int getRandom() {
            int i = random.nextInt(nums.size());
            return nums.get(i);
        }
        class Node {
            int val;
            Node next;
            Node(int val) {
                this.val = val;
            }
        }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
//leetcode submit region end(Prohibit modification and deletion)

}

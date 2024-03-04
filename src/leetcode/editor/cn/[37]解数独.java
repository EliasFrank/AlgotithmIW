package leetcode.editor.cn;
//编写一个程序，通过填充空格来解决数独问题。 
//
// 数独的解法需 遵循如下规则： 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。 
//
// 
//
// 
// 
// 
// 示例 1： 
// 
// 
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
// 
// 
// 
// 
//
//
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字或者 '.' 
// 题目数据 保证 输入数独仅有一个解 
// 
//
// Related Topics 数组 哈希表 回溯 矩阵 👍 1801 👎 0


import java.util.ArrayList;
import java.util.List;

class SudokuSolver{
    public static void main(String[] args) {
      Solution solution = new SudokuSolver().new Solution();
      char[][] board = new char[][] {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
      solution.solveSudoku(board);
      System.out.println(111);
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       int[][] rows = new int[9][9];
       int[][] cols = new int[9][9];
       int[][][] grids = new int[3][3][9];
       /* 自己写的时候不知道终止条件在哪，怎么跳出递归调用
          迷宫的回溯是每一步i和j都会变换，直到走到了终点就结束了
          但是数独不是，他必须每一格都遍历，填上需要的数字，直到所有格子都填完才算结束
          所以用space数组记录需要填充的格子下标，并衡量是否所有空格都填完了
          并新增了一个valid变量判断所有格子是否填完，填完就不往下走了
       */
       boolean valid = false;
       List<int[]> space = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp == '.') {
                    space.add(new int[] {i, j});
                } else {
                    int index = temp - '1';
                    rows[i][index]++;
                    cols[j][index]++;
                    grids[i/3][j/3][index]++;
                }
            }
        }
        solveSudokuOne(board, 0);
        for (int i = 0; i < board.length; i++) {
            for (int i1 = 0; i1 < board[i].length; i1++) {
                System.out.print(board[i][i1] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public void solveSudokuOne(char[][] board, int pos) {
        if (pos == space.size()) {
            valid = true;
            return;
        }
        int[] ints = space.get(pos);
        int i = ints[0];
        int j = ints[1];
        List<Integer> nums = new ArrayList<>(8);
        for (int k = 0; k < 9; k++) {
            if (rows[i][k] == 0 && cols[j][k] == 0 && grids[i/3][j/3][k] == 0) nums.add(k);
        }
        for (int i1 = 0; i1 < nums.size() && !valid; i1++) {
            int tempNum = nums.get(i1);
            board[i][j] =  (char)(tempNum + '1');
            rows[i][tempNum]++;
            cols[j][tempNum]++;
            grids[i/3][j/3][tempNum]++;
            solveSudokuOne(board, pos + 1);
            if (!valid) {
                rows[i][tempNum]--;
                cols[j][tempNum]--;
                grids[i/3][j/3][tempNum]--;
                board[i][j] = '.';
            } else break;
        }
        return;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

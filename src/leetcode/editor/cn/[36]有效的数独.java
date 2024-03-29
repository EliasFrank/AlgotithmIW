package leetcode.editor.cn;
//请你判断一个 9 x 9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。 
//
// 
// 数字 1-9 在每一行只能出现一次。 
// 数字 1-9 在每一列只能出现一次。 
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图） 
// 
//
// 
//
// 注意： 
//
// 
// 一个有效的数独（部分已被填充）不一定是可解的。 
// 只需要根据以上规则，验证已经填入的数字是否有效即可。 
// 空白格用 '.' 表示。 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：board = 
//[["5","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = 
//[["8","3",".",".","7",".",".",".","."]
//,["6",".",".","1","9","5",".",".","."]
//,[".","9","8",".",".",".",".","6","."]
//,["8",".",".",".","6",".",".",".","3"]
//,["4",".",".","8",".","3",".",".","1"]
//,["7",".",".",".","2",".",".",".","6"]
//,[".","6",".",".",".",".","2","8","."]
//,[".",".",".","4","1","9",".",".","5"]
//,[".",".",".",".","8",".",".","7","9"]]
//输出：false
//解释：除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无
//效的。 
//
// 
//
// 提示： 
//
// 
// board.length == 9 
// board[i].length == 9 
// board[i][j] 是一位数字（1-9）或者 '.' 
// 
//
// Related Topics 数组 哈希表 矩阵 👍 1214 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ValidSudoku{
    public static void main(String[] args) {
      Solution solution = new ValidSudoku().new Solution();
      char[][] map = new char[][] {{'5','3','.','.','7','.','.','.','.'}
              ,{'6','.','.','1','9','5','.','.','.'}
              ,{'.','9','8','.','.','.','.','6','.'}
              ,{'8','.','.','.','6','.','.','.','3'}
              ,{'4','.','.','8','.','3','.','.','1'}
              ,{'7','.','.','.','2','.','.','.','6'}
              ,{'.','6','.','.','.','.','2','8','.'}
              ,{'.','.','.','4','1','9','.','.','5'}
              ,{'.','.','.','.','8','.','.','7','9'}};
//        char[][] map = new char[][] {{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
      System.out.println(solution.isValidSudoku(map));
    }
 
   //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
       public boolean isValidSudoku(char[][] board) {
            int[][] row = new int[9][9];
            int[][] col = new int[9][9];
            int[][][] grid = new int[9][3][3];
           for (int i = 0; i < board.length; i++) {
               for (int j = 0; j < board[i].length; j++) {
                   char temp = board[i][j];
                   if (temp == '.') continue;
                   int index = temp - '1';
                   row[index][i]++;
                   col[index][j]++;
                   grid[index][i/3][j/3]++;
                   if (row[index][i] > 1 || col[index][j] > 1 || grid[index][i/3][j/3] > 1) return false;
               }
           }
           return true;
       }
    public boolean isValidSudoku_IamSB(char[][] board) {
        boolean result = true;
        HashMap<Character, List<Integer[]>> map = new HashMap();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (map.get(board[i][j]) == null) {
                    List<Integer[]> temp = new ArrayList<>();
                    temp.add(new Integer[]{i, j});
                    map.put(board[i][j], temp);
                } else {
                    List<Integer[]> temp = map.get(board[i][j]);
                    temp.add(new Integer[]{i, j});
                }
            }
        }
        for (char i = '1'; i <= '9'; i++) {
            List<Integer[]> pos = map.get(i);
            if (pos == null)  continue;
            int[] row = new int[9];
            int[] col = new int[9];
            int[][] grid = new int[3][3];
            for (Integer[] p : pos) {
                row[p[0]]++;
                col[p[1]]++;
                grid[p[0]/3][p[1]/3]++;
            }
            for (int j = 0; j < 9; j++) {
                if (row[j] > 1) return false;
                if (col[j] > 1) return false;
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (grid[j][k] > 1) return false;
                }
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}


// lc 1267. Count Servers that Communicate
// potd: 8th novemeber 2026(diwali) 

public class Countservers {
    // optimized approach: count the number of servers in each row and column, then
    // iterate through the grid again to count the servers that can communicate with
    // at least one other server.
    // o(m*n) time complexity, o(m+n) space complexity
    
    class Solution {
        public int countServers(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int[] rowCount = new int[m];
            int[] colCount = new int[n];

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        rowCount[i]++;
                        colCount[j]++;
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1 && (rowCount[i] > 1 || colCount[j] > 1)) {
                        count++;
                    }
                }
            }

            return count;
        }
    }

    // brute force approach: for each server, check if there is another server in the same row or column. If so, count it. This approach has a time complexity of O(m*n*(m+n)), where m is the number of rows and n is the number of columns.

    public int countServers(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == 1 && check(grid, i, j)) {
                    count++;
                }
            }
        }

        return count;
    }

    boolean check(int[][] grid, int row, int col) {

        // Check same row
        for (int j = 0; j < grid[row].length; j++) {
            if (j != col && grid[row][j] == 1) {
                return true;
            }
        }

        // Check same column
        for (int i = 0; i < grid.length; i++) {
            if (i != row && grid[i][col] == 1) {
                return true;
            }
        }

        return false;
    }
}
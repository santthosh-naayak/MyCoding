package dsa.Patterns.GraphAndDFS;

/*Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 
Constraints:
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'. */
public class GraphAndDfs {
    public int numIslands(char[][] grid) {
        // Initial Island
        int islands = 0;
        // Traverse through whole grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                // If Island is found
                if (grid[row][col] == '1') {
                    // Increment the island cound
                    islands++;
                    // Mark Entire Island as Visited
                    dfs(grid, row, col);
                }
            }
        }
        return islands;
    }

    private void dfs(char[][] grid, int row, int col) {
        // edge case 1: If row is outside the grid
        if (row < 0 || row >= grid.length) {
            return;
        }
        // edge case 2: If column is outside the grid
        if (col < 0 || col >= grid[0].length) {
            return;
        }
        // If Water is found return
        if (grid[row][col] == '0') {
            return;
        }
        // Mark the current cell as visited
        grid[row][col] = '0';
        // Visit all four directions and mark as visited
        dfs(grid, row - 1, col);// Up
        dfs(grid, row + 1, col);// Down
        dfs(grid, row, col - 1);// left
        dfs(grid, row, col + 1);// Right
    }

    public static void main(String[] args) {
        GraphAndDfs graphAndDfs = new GraphAndDfs();
        char[][] grid1 = {
                { '1', '1', '1', '1', '0' },
                { '1', '1', '0', '1', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '0', '0', '0' },
        };

        char[][] grid2 = {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' },
        };

        int result1 = graphAndDfs.numIslands(grid1);
        System.out.println(result1);
        int result2 = graphAndDfs.numIslands(grid2);
        System.out.println(result2);
    }
}

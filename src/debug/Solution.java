public class Solution {
    public long rec(int [][] points, int row, int col, int offset, long ans) {
        if(row == points.length) {
            return ans;
        }
        ans+=(points[row][col] - offset);
        for(int i=0;i<points[row].length;i++) {
            ans = Math.max(ans, rec(points, row+1, i, Math.abs(col- i), ans));
        }
        return ans;
    }
    public long maxPoints(int[][] points) {
        long ans =0;
        for(int i=0;i<points[0].length;i++) {
            ans = Math.max(ans, rec(points, 0, i, 0, 0));
        }
        return ans;
    }

    public static void main(String args[]) {
        int[][] points = new int[][]{{1,2,3},{1,5,1},{3,1,1}};
        Solution solution = new Solution();
        System.out.println("Running Main" + solution.maxPoints(points));
    
    }
}
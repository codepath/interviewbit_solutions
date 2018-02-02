public class Interview1 {
    /**
        This is a dynamic programing problem. The way to look at it is that you will create a 2-D array to keep track
        of the minEdit for each element comparison of the start string and the target string.  If the characters are
        different, you take the min steps of neighbors and add 1 change (whether it's a insert, update or replace). 
        If its the same, that means you don't have to do anything.  You will just update the dp array with the min
        steps of the neighbors.


        if(str1[i] != str2[2])
            dp[i][j] = 1 + Min(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])
        else
            dp[i][j] = dp[i - 1][j - 1])
        
        Sample of the dp array

            "" A n s h u m a n   (j)
        ""  0 1 2 3 4 5 6 7 8 
        A   1 0 1 2 3 4 5 6 7
        n   2 1 0 1 2 3 4 5 5
        t   3 2 1 1 2 3 4 5 6
        i   4 3 2 2 2 3 4 5 6
        h   5 4 3 3 2 3 4 5 6
        u   6 5 4 4 3 2 3 4 5
        m   7 6 5 5 4 3 2 3 4
        a   8 7 6 6 5 4 3 2 3
        n   9 8 7 7 6 5 4 3 2
        (i)

        Runtime: O(n*m)
        Space: O(n*m)
     */

    public int minDistance(String start, String target) {
        int n = start.length();
        int m = target.length();
        int[][] dp = new int[n + 1][m + 1];
        
        //initialize first row and column
        for(int i = 0; i <= n; i++)
            dp[i][0] = i;

        for(int j = 0; j <= m; j++) {
            dp[0][j] = j;
        } 

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j]));
                if(start.charAt(i - 1) != target.charAt(j - 1))
                dp[i][j] += 1;
            }
        }
        return dp[n][m];
    }
}
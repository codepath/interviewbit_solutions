// Longest Palindromic Substring
// https://www.interviewbit.com/problems/longest-palindromic-substring/
public class Solution {
	public String longestPalindrome(String A) {
	    
	    int n;
	    boolean [][] dp;
	    int i;
	    
	    n = A.length();
	    
	    dp = new boolean[n][n];
    	    
    	for (i = 0; i < n; i++)
    	    dp[i][i] = true;
	    
	    for (int len = 2; len <= n; len++) {
	        
	        int j;
	        
	        for (i = 0; i < n - len + 1; i++) {
	            
	            j = i + len - 1;
	               
                if (len == 2) {
                    if (A.charAt(i) == A.charAt(j)) {
                        dp[i][j] = true;
                    }
                } else {
                    if (A.charAt(i) == A.charAt(j) && dp[i + 1][j - 1])
                        dp[i][j] = true;
                }
	            
	        }
	        
	    }
	    
	    int start = -1;
	    int len = -1;
	    
	    for (i = 0; i < n; i++) {
	        for (int j = i; j < n; j++) {
	            if (dp[i][j] && j - i + 1 > len) {
	                len = j - i + 1;
	                start = i;
	            }
	        }
	    }
	    
	    
	    return A.substring(start, start + len);
	}
}

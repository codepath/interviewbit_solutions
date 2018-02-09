// Palindrome String
// https://www.interviewbit.com/problems/palindrome-string/
public class Solution {
	public int isPalindrome(String A) {
	    
	    StringBuffer strBuf = new StringBuffer();
	    
	    for (int i = 0; i < A.length(); i++) {
	        if ((A.charAt(i) >= 'a' && A.charAt(i) <= 'z') || (A.charAt(i) >= 'A' && A.charAt(i) <= 'Z') || (A.charAt(i) >= '0' && A.charAt(i) <= '9'))
	            strBuf.append(Character.toLowerCase(A.charAt(i)));
	    }
	    
	    String str = strBuf.toString();
	    int n = str.length();
	    
	    for (int i = 0; i < n / 2; i++) {
	        if (str.charAt(i) != str.charAt(n - i - 1))
	            return 0;
	    }
	    
	    return 1;
	    
	}
	
}

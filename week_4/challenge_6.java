// Number of 1 Bits
// https://www.interviewbit.com/problems/number-of-1-bits/
public class Solution {
	public int numSetBits(long A) {

	    int count = 0;

	    while (A > 0) {
	        if ( (A & 1) != 0)
	            count++;
	        A >>= 1;
	    }

	    return count;

	}
}

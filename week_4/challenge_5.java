// Single Number
// https://www.interviewbit.com/problems/single-number/
public class Solution {
	// DO NOT MODIFY THE LIST
	public int singleNumber(final List<Integer> A) {
	    int num = 0;

	    for (int val : A) {
	        num ^= val;
	    }

	    return num;

	}
}

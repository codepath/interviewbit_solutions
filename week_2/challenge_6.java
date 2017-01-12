// Longest non-repeating substring
// https://www.interviewbit.com/problems/longest-substring-without-repeat/
public class Solution {
	public int lengthOfLongestSubstring(String A) {

        int count = 0;
        int max = 0;
	    int n = A.length();
	    HashMap<Character, Integer> hashMap = new HashMap<>();
	    char c;
	    int prevIndex;

	    for (int i = 0; i < n; i++) {

	        c = A.charAt(i);

	        if (hashMap.containsKey(c)) {
	            prevIndex = hashMap.get(c);
	            count = Math.min(count + 1, i - prevIndex);
	            hashMap.put(c, i);
	        } else {
	            count++;
	            hashMap.put(c, i);
	        }

	        max = Math.max(max, count);
	    }

	    return max;
	}
}

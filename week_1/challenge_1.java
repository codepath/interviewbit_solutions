// Remove Duplicates from Sorted ArrayBookmark Suggest Edit
// https://www.interviewbit.com/problems/remove-duplicates-from-sorted-array/
public class Solution {
	public int removeDuplicates(ArrayList<Integer> A) {
	    int index = 1;
	    int n = A.size();
	    
	    if (A == null || A.size() == 0)
	        return 0;
	    
	    for (int i = 1; i < n; i++) {
	        
	        if (A.get(i).intValue() != A.get(i - 1).intValue()) {
	            int temp = A.get(index);
	            A.set(index, A.get(i));
	            index++;
	        }
	    }
	    
	    return index;
	    
	}
}

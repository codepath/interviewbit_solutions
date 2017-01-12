// Prime Numbers
// https://www.interviewbit.com/problems/prime-numbers/
public class Solution {
	public ArrayList<Integer> sieve(int A) {
	    boolean prime [] = new boolean[A + 1];
	    Arrays.fill(prime, true);
	    prime[0] = prime[1] = false;
	    
	    for (int i = 2; i <= A; i++) {
	        if (!prime[i])
	            continue;
	            
	        for (long j = 1L * i * i; j <= (long) A; j += i)
	            prime[(int) j] = false;
	    }
	    
	    ArrayList<Integer> res = new ArrayList<>();
	    
	    for (int i = 0; i <= A; i++) {
	        if (prime[i])
	            res.add(i);
	    }
	    
	    return res;
	}
}

// Interview Question 2: Calculating n choose k

import java.util.HashMap;

public class interview_2 {
	
	public static long nChooseKRecursive(int n, int k) {
		if (k >= n) {
			return 1L;
		} else if (k == 1) {
			return (long) n;
		}
		return nChooseKRecursive(n - 1, k - 1) + nChooseKRecursive(n - 1, k);
	}

	public static long nChooseKRecursiveWithMemoization(int n, int k) {
		HashMap<String, Long> map = new HashMap<>();		
		return nChooseKRecursiveWithMemoizationHelper(n, k, map);
	}

	private static long nChooseKRecursiveWithMemoizationHelper(int n, int k, HashMap<String, Long> map) {
		if (k >= n) {			
			return 1L;
		} else if (k == 1) {
			return (long) n;
		}

		String key = n + "" + k;
		if (map.containsKey(key)) {
			return map.get(key);
		}
		long sum = nChooseKRecursive(n - 1, k - 1) + nChooseKRecursive(n - 1, k);
		map.put(key, sum);
		return sum;
	}

	public static void main(String[] args) {
		long sum2 = nChooseKRecursiveWithMemoization(20, 4);  // 4845
		System.out.println(sum2);

		long sum = nChooseKRecursive(20, 4);  // 4845
		System.out.println(sum);
	}

}
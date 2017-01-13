// Compute factorial of an integer

public class Solution {
    int computeFactorial(int n) {
        if (n <= 1) {
            return 1;
        } else {
            return n * computeFactorial(n - 1);
        }
    }
}
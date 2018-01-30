
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjacent {
    public int adjacent(ArrayList<ArrayList<Integer>> A) {
        ArrayList<Integer> topArray = A.get(0);
        ArrayList<Integer> botArray = A.get(1);

        int size = topArray.size();
        if (size == 0) {
            return 0;
        }

        int[] topResult = new int[size];
        int[] botResult = new int[size];

        for (int i = 0; i < size; i++) {
            if (i < 2) {
                topResult[i] = topArray.get(i);
                botResult[i] = botArray.get(i);
                continue;
            }
            // consider the 4 entries from column -1 and column -2
            int maxSum = 0;
            if (i - 2 >= 0) {
                if (topResult[i - 2] > maxSum) {
                    maxSum = topResult[i - 2];
                }
                if (botResult[i - 2] > maxSum) {
                    maxSum = botResult[i - 2];
                }
            }

            if (i - 3 >= 0) {
                if (topResult[i - 3] > maxSum) {
                    maxSum = topResult[i - 3];
                }
                if (botResult[i - 3] > maxSum) {
                    maxSum = botResult[i - 3];
                }
            }

            System.out.println(Arrays.toString(topResult));
            System.out.println(Arrays.toString(botResult));
            System.out.println(maxSum);

            topResult[i] = topArray.get(i) + maxSum;
            botResult[i] = botArray.get(i) + maxSum;
        }

        int maxSum = 0;
        if (topResult[size - 1] > maxSum) {
            maxSum = topResult[size - 1];
        }
        if (botResult[size - 1] > maxSum) {
            maxSum = botResult[size - 1];
        }

        if (size > 1) {
            if (topResult[size - 2] > maxSum) {
                maxSum = topResult[size - 2];
            }

            if (botResult[size - 2] > maxSum) {
                maxSum = botResult[size - 2];
            }
        }

        System.out.println(Arrays.toString(topResult));
        System.out.println(Arrays.toString(botResult));
        return maxSum;
    }

    @Test
    public void testAdjacent() {
        Assert.assertEquals(8, adjacent(new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(1,2,3,4)),
                new ArrayList<Integer>(Arrays.asList(2,3,4,5))
        ))));

        Assert.assertEquals(156, adjacent(new ArrayList<>(Arrays.asList(
                new ArrayList<Integer>(Arrays.asList(74, 37, 82, 1)),
                new ArrayList<Integer>(Arrays.asList(66, 38, 16, 1))
        ))));
    }
}


import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxSumWithoutAdjacent {

    public int adjacent(ArrayList<ArrayList<Integer>> input) {
        if (input.isEmpty()) {
            return 0;
        }
        int size = input.get(0).size();
        if (size == 0) {
            return 0;
        }

        int priorSum = 0; // column i - 2
        int lastSum = 0;  // column i - 1

        for (int i = 0; i < input.get(0).size(); ++i) {
            // Consider to possibility, max sum using max value from the new column (i)
            // OR sum from previous column
            int total = Math.max(input.get(0).get(i), input.get(1).get(i)) + priorSum;
            int res = Math.max(total, lastSum);

            priorSum = lastSum;
            lastSum = res;
        }
        // Solution could be from last column or the one before that
        return Math.max(priorSum, lastSum);
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

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://www.hackerrank.com/challenges/torque-and-development/problem
 */
public class RoadsAndLibraries {
    static long roadsAndLibraries(int cityCount, int costLibrary, int costRoad, int[][] cities) {
        // First build adjacency list (neighbor that is connectible by road) for all cities
        List<List<Integer>> adjacent = new ArrayList<>();

        for (int i = 0; i < cityCount ; i ++) {
            adjacent.add(new ArrayList<>());
        }

        for (int i = 0; i < cities.length; i++) {
            adjacent.get(cities[i][0] -1).add(cities[i][1] -1);
            adjacent.get(cities[i][1] -1).add(cities[i][0] -1);
        }

        // Now we DFS the adjacent neighbors to find out the city groups
        boolean[] visited = new boolean[cityCount];

        ArrayList<Integer> groupSizes = new ArrayList<>();
        for (int i = 0; i < cityCount; i++) {
            if (visited[i]) {
                continue;
            }

            int groupSize = 0;
            Stack<Integer> stack = new Stack<>();
            stack.push(i);
            visited[i] = true;

            while (!stack.isEmpty()) {
                int city = stack.pop();
                groupSize++;

                for (int adj : adjacent.get(city)) {
                    if (!visited[adj]) {
                        stack.add(adj);
                        visited[adj] = true;
                    }
                }
            }

            groupSizes.add(groupSize);
        }

        /**
         * For each group, we will need at least one library. After that the decision would be
         * either to build library on each node
         * (size - 1) * costLibrary
         * OR to build road to connect all the nodes
         * (size - 1) * costRoad
         */
        long cost = 0;
        for (int size: groupSizes) {
            cost += costLibrary; // the initial library
            cost += (size - 1) * (costLibrary > costRoad ? costRoad : costLibrary);
        }

        return cost;
    }

    @Test
    public void testRoadsAndLibraies() {
        Assert.assertEquals(4, roadsAndLibraries(3, 2, 1, new int[][]{{1,2}, {3, 1}, {2, 3}}));
        Assert.assertEquals(12, roadsAndLibraries(6, 2, 5, new int[][]{{1, 3}, {3, 4}, {2, 4}, {1, 2}, {2, 3}, {5, 6}}));
    }

}
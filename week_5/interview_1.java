
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

// https://www.hackerrank.com/challenges/journey-to-the-moon/problem

public class JourneyToTheMoon {

    static long journeyToMoon(int astronautCount, int[][] astronauts) {
        // Complete this function
        List<List<Integer>> adjacent = new ArrayList<>();

        for (int i = 0; i < astronautCount ; i ++) {
            adjacent.add(new ArrayList<>());
        }

        // first is to build a list of astronaut and their adjacent/countryman
        for (int i = 0; i < astronauts.length; i++) {
            adjacent.get(astronauts[i][0]).add(astronauts[i][1]);
            adjacent.get(astronauts[i][1]).add(astronauts[i][0]);
        }


        /*
        Now we will DFS the adjacent list to build the graph of each country.
        Keep a list of visited astronaut so we would only visit each astronaut once.
        */

        boolean[] visited = new boolean[astronautCount];
        List<Integer> countrySizes = new ArrayList<Integer>();

        for (int i = 0; i < astronautCount; i++) {
            int size = 0;
            if (!visited[i]) {
                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int astronaut = stack.pop();
                    size++;

                    for (int adj: adjacent.get(astronaut)) {
                        if (!visited[adj]) {
                            visited[adj] = true;
                            stack.push(adj);
                        }
                    }
                }

                countrySizes.add(size);
            }
        }

        //Get number of possible pairs
        long numPairs = 0;
        int remainingAstronauts = astronautCount;
        for(int countrySize : countrySizes){
            remainingAstronauts -= countrySize;
            numPairs += countrySize * remainingAstronauts;
        }

        return numPairs;
    }

    @Test
    public void testJourney() {
        Assert.assertEquals(6, journeyToMoon(5, new int[][]{{0, 1},{2, 3},{0, 4}}));
        Assert.assertEquals(5, journeyToMoon(4, new int[][]{{0, 2}}));
        Assert.assertEquals(4999949998L, journeyToMoon(100000, new int[][]{{1, 2}, {3,4}}));
    }
}

// Interview Question 1: Gold Stars
import java.util.Arrays;

interface StarSoln  {
	
	int getMinimumNumberOfStars(int[] ratings, boolean bonusObjective);

}

class StarSolnImpl implements StarSoln {

	@Override
	public int getMinimumNumberOfStars(int[] ratings, boolean bonusObjective) {
		if (ratings == null || ratings.length == 0) return 0;
	 
		int[] stars = new int[ratings.length];
	 
		// from left to right
		for (int i = 0; i < ratings.length; i++) {
			// if the child's rating is higher than the preceding neighbor's
			if (i > 0 && ratings[i] > ratings[i - 1]) {
				// assign the child's star count to one more than preceding neighbor's
				stars[i] = stars[i - 1] + 1;
			} else { 
				// otherwise assign 1
				stars[i] = 1;
			}
		}
	 
		int result = 0;

		// from right to left
		for (int i = ratings.length - 1; i >= 0; i--) {
			int neighbor = i == ratings.length - 1 ? i - 1 : i + 1;
			int cur = stars[i];
			// if the child's rating is higher than the following neighbor's
			if (ratings[i] > ratings[neighbor]) {
				// temp. assign the child's star count to one more than the following neighbor's
				cur = stars[neighbor] + 1;
			} else if (bonusObjective) {
				if (ratings[i] == ratings[neighbor] && stars[i] < stars[neighbor]) {
					// if the neighbor's rating is the same but star count is different
					cur = stars[neighbor];
				}
			}
	 
			// increment the result by the greater of the two
			result += Math.max(cur, stars[i]);
			// update the child's star count
			stars[i] = cur;
		}
	 
		System.out.println(Arrays.toString(ratings) + " >> " + Arrays.toString(stars) + " == " + result);
		return result;
	}

}

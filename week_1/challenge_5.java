// Multimaps
public class Solution {
	public Map<Integer, Set<String>> multiMap(Map<String, Integer> wordCounts) {
		Map<Integer, Set<String>> multiMap = new HashMap<Integer, Set<String>>();
		for (Entry<String, Integer> wordCount : wordCounts.entrySet()) {
			String word = wordCount.getKey();
			Integer count = wordCount.getValue();

			Set<String> words = null;

			if (!multiMap.containsKey(count)) {
				words = new HashSet<String>();
				multiMap.put(count, words);
			} else {
				words = multiMap.get(count);
			}

			words.add(word);
		}
		return multiMap;
	}
}
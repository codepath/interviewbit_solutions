public class Solution {
    public int majorityElement(final List<Integer> a) {
        if (a == null || a.size() == 0){
            return 0;
        }

        if (a.size() == 1){
            return a.get(0);
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < a.size(); i++) {
            int temp = a.get(i);
            if (map.containsKey(temp)) {
                int count = map.get(temp) + 1;
                map.put(temp, count);
                if (count > a.size()/2) {
                    return temp;
                }
            } else {
                map.put(a.get(i), 1);
            }
        }

        return -1;
    }
}

// Hash table word count
public class Solution {
  public HashMap<String, Integer> wordCount(String s) {
    s = s.replaceAll("^[a-zA-Z]", " ").toLowerCase();
    String[] split = s.split(" ");
    
    HashMap<String, Integer> map = new HashMap();
    
    
    for (int i=0; i < split.length; i++) {
      String word = split[i];
      if (!word.equals("")) {
        if (map.containsKey(word)) {
          map.put(word, map.get(word) + 1);
        } else {
          map.put(word, 1);
        }
      }
    }
    
    return map;
  }
}

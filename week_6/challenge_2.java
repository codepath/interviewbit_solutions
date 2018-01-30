import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

// https://www.interviewbit.com/problems/word-break/
// https://www.programcreek.com/2012/12/leetcode-solution-word-break/

public class WordBreak {
    public int wordBreak(String A, ArrayList<String> B) {
        HashSet<String> wordDict = new HashSet<>();
        wordDict.addAll(B);

        int maxLen = 0;
        for (String word: B){
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }

        int[] pos = new int[A.length()+1];

        Arrays.fill(pos, -1);

        // Initial starting search position
        pos[0]=0;

        for(int i=0; i<A.length(); i++){
            // Only start searching from last "break" candidate
            if(pos[i]!=-1){
                // Search for possible break up to max dict word length
                for(int j=i+1; j<=A.length() && (j - i <= maxLen); j++){
                    String sub = A.substring(i, j);
                    if(wordDict.contains(sub)){
                        pos[j]=i;
                    }
                }
            }
        }

        return pos[A.length()]!=-1 ? 1 : 0;
    }

    @Test
    public void testWordBreak() {
        Assert.assertEquals(1, wordBreak("myinterviewmytrainerinterview", new ArrayList<>(Arrays.asList("mytrainer","trainer", "my", "interview"))));
        Assert.assertEquals(1, wordBreak("myinterviewtrainer", new ArrayList<>(Arrays.asList("trainer", "my", "interview"))));
        Assert.assertEquals(0, wordBreak("zzmyinterviewtrainer", new ArrayList<>(Arrays.asList("trainer", "my", "interview"))));
        Assert.assertEquals(1, wordBreak("zzmyinterviewtrainer", new ArrayList<>(Arrays.asList("trainer", "my", "interview","zz"))));
        Assert.assertEquals(1, wordBreak("aababaaabaaababbbabbbaabababaaabbaabaabbabbaabbbbbbbabbbbabaaabaabaabbaaaaabbabaababbbabbbbbbaaaabbbaaaaaabaaaaaabbbbbbbabbbbbbbbaaabaaababbbaaaabaaaabaaaabbabbbabaabbabbabaaaabbabaaabbabbabbbabbabbaabbbabaabaabbbbbbbaabababbbbbbababbbaabaabbbabababbbbbaaaababbbabaaabaabbaababbbabbbbbaabbaaaaabbbbbaaaaaaaaaaaabbabbbabbaaabaaaaaabaabababaabaaaabaaabbbbbaaabbaabbababbabbbbaabaabaabaaaabbbaababbaabbbbbabaaababbabbbabbbbbabaababbbbbaabbbbabaabbabbababaaaabbbbabbbaaaabaabbbbaaaaababaaabaabbabaababbabbbababaaababbaabbbaaabaabbbaabbbbbbaaabaabbbbbabaaababaaabbbbbbaaaabababaaabbbbbbaabbaaabbbabaabbabababbabaabbaaabbaaabbaabbbbbababbaabbabbb",
                new ArrayList<>(Arrays.asList("baaaaaabba", "babbaababb", "abb", "bababaabab", "baaa", "ab", "ab", "bb", "abbaaaa", "bbababa", "bbbbbbab", "abbaaabba", "aaaabbab", "abaaab", "babab", "aabaaab", "aabaabbabb", "aa", "bb", "ab", "a", "a", "bbaaab", "aba", "ba", "bbabbaabab", "aaabbbbbb", "abbaaaabbb", "aabaabbaa", "bbba", "abbabbba", "abbbbabb", "bbaaba", "abbbbaab", "bba", "bbbbaabba", "ababbabaab", "baabba", "ababbaabb", "bbaab", "a", "bbba", "aaaa", "aaabbbabba", "bab", "baaaabaa", "ab", "aaabbaab", "bab", "aa", "ababababab", "aabbaaaba", "abbaaba", "bbaabaa"))));
    }
}

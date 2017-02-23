// Compute all substrings
interface SubstringProvider {
	  java.util.Collection<String> getSubstrings(String s);
}

public class IterativeSubstringProvider implements SubstringProvider {

	@Override
	public Collection<String> getSubstrings(String s) {
		List<String> result = new ArrayList<>();
		
		int sLength = s.length();
		for (int i = 0; i < sLength; i++) {
			StringBuilder sBuilder = new StringBuilder();
			for (int j = i; j < sLength; j++) {
				sBuilder.append(s.charAt(j));
				result.add(sBuilder.toString());
			}
		}
		
		return result;
	}
}

public class RecursiveSubstringProvider implements SubstringProvider {

	@Override
	public Collection<String> getSubstrings(String s) {
		List<String> result = new ArrayList<>();
		addSubstrings(0, s, result);
		return result;
	}
	
	public void addSubstrings(int index, String s, List<String> result) {
		if (index < s.length()) {
			StringBuilder sb = new StringBuilder();
			addSubstrings(index, s, sb, result);
			addSubstrings(index+1, s, result);
		}
	}
	
	public void addSubstrings(int index, String s, StringBuilder sb, List<String> result) {
		if (index < s.length()) {
			sb.append(s.charAt(index));
			result.add(sb.toString());
			addSubstrings(index + 1, s, sb, result);
		}		
	}

}

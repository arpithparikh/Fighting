"the sky is blue"
"blue is sky the"
public class Solution {
	public String reverseWords(String s) {
		if(s == null || s.length() == 0) {
			return new String();
		}
		StringBuffer sb = new StringBuffer();
		s = s.trim();
		for(int start = s.length() - 1; start >= 0; start--) {
			if(s.charAt(start) == ' ') {
				continue;
			}
			int end = start;
			while(start >= 0 && s.charAt(start) != ' ') {
				start--;
			}
			sb.append(s.substring(start + 1, end + 1));
			sb.append(" ");
		}
		return sb.toString().trim();
	}
}

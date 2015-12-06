public class Palindrome {
	public static String longestPalindromeSubstring(String S) {
		if(S == null || S.length() == 0) {
			return new String();
		}
		//这一步真的很重要，切记
		String max = S.substring(0, 1);
		for(int i = 0; i < S.length() - 1; i++) {
			String temp = helper(S, i, i);
			if(temp.length() > max.length()) {
				max = temp;
			}
			temp = helper(S, i, i + 1);
			if(temp.length() > max.length()) {
				max = temp;
			}
		}
		return max;
	}
	private String helper(String s, int left, int right) {
		if(left < 0 || right >= s.length) {
			return new String();
		}
		while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
			left--;
			right++;
		}
		return s.substring(left + 1, right);
	}
}
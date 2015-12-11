input： "aaabb".
output: "3a2b"

input: "aaaabbba".
output:"4a3ba"


public class Compress {
	public String compress(String s) {
		if(s == null || s.length() == 0) {
			return new String();
		}
		StringBuffer sb = new StringBuffer();
		int left = 0;
		int right = 0;
		while(right < s.length()) {
			while(right < s.length() && s.charAt(left) == s.charAt(right)) {
				right++;
			}
			if(right - left > 1) {
				sb.append(right - left);
			}
			sb.append(s.charAt(left));
			left = right;
		}
		return sb.toString();
	}
	public static void main(String[] args) {
		Compress c = new Compress();
		String s1 = "aaaabbba";
		String s2 = "aaabb";
		System.out.println(s.compress(s1));
		System.out.println(s.compress(s2));
	}
}
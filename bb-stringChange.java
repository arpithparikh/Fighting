a#3bd#5 -》 aaabddddd
public class change {
	public String change(String s) {
		if(s == null || s.length() == 0) {
			return s;
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '#') {
				continue;
			}
			else {
				sb.apppend(s.charAt(i));
			}
		}
		if(sb.length() == 1) {
			return sb.toString();
		}
		StringBuffer res = new StringBuffer();
		int left = 0;
		int right = 1;
		while(right < sb.length()) {
			if(isChar(s.charAt(left)) && isNumber(s.charAt(right))) {
				int count = s.charAt(right) - '0';
				while(count-- > 0) {
					res.append(sb.charAt(left));
				}
				left += 2;
				right+= 2;
			}
			if(isChar(s.charAt(left)) && isChar(s.charAt(right))) {
				res.append(sb.charAt(left));
				left = right;
				right++;
			}
		}
		return res.toString();
	}
	private boolean isChar(char c) {
		if((c <= 'z' && c >= 'a') || (c <= 'Z' && c >= 'A')) {
			return true;
		}
		else {
			return false;
		}
	}
	private boolean isNumber(char c) {
		if(c <= '9' && c >= '0') {
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		change c = new change();
		String s = "a#3bd#5";
		System.out.print(c.change(s));
	}
}
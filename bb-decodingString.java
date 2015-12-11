a#3bd#5 -》 aaabddddd


public class decoding {
	public String decoding(String s) {
		if(s == null || s.length() < 3) {
			return new String();
		}
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '#') {
				char temp = s.charAt(i - 1);
				int count = s.charAt(i + 1) - '0';
				while(count-- > 0) {
					sb.append(temp);
				}
				i += 2;
			}
		}
		return sb.toString();
 	}
	public static void main(String[] args) {
		decoding d = new decoding();
		String s = "a#3b#1d#5";
		System.out.println(d.decoding(s));
	}
}

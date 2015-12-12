public class Solution {
	public void printWithComma(int nums) {
		StringBuffer sb = new StringBuffer();
		while(num > 0) {
			int digit = num % 10;
			if(sb.length() % 3 != 0) {
				sb.append(digit + "");
			}
			else {
				sb.append(",");
				sb.append(digit + "");
			}
			num /= 10;
		}
		int start = 0;
		int end = sb.length() - 1;
		for(int i = 0; start + i < end - i; i++) {
			char temp = sb.charAt(start + i);
			sb.setCharAt(start + i, sb.charAt(end - i));
			sb.setCharAt(end - i, sb.charAt(start + i));
		}
		return sb.toString();
	}
}
输入 一个String  s 在 s 后添加最少的  String s
 得到  新的  String  T 是一个 palindromic

public class Solution {
 	public String add(String s) {
 		if(s == null || s.length < 2) {
 			return s;
 		}
 		if(isPalindrome(s)) {
 			return s;
 		}
 		int start = 0;
 		while(start < s.length()) {
 			char c = s.charAt(start);
 			s += c;
 			if(isPalindrome(s)) {
 				return s;
 			}
 			else {
 				start++;
 			}
 		}
 		return null;
 	}
 	private boolean isPalindrome(String s) {
 		int start = 0;
 		int end = s.length() - 1;
 		for(int i = 0; start + i < end - i; i++) {
 			if(s.charAt(start + i) != s.charAt(end - i)) {
 				return false;
 			}
 		}
 		return true;
 	}
 }
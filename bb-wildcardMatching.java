'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

DFA solution
public class Solution {
	public boolean isMatch(String s, String p) {
		int savedP = -1;
		int savedS = -1;
		int indexP = 0;
		for(int indexS = 0; indexS < s.length();) {
			if(indexP < p.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')) {
				//match to single character
				indexP++;
				indexS++;
			}
			else if(indexP < p.length() && p.charAt(indexP) == '*') {
				// go into the * state, we need to save the P next position and save S next position
                // when any mismatch happen, we can revert the search to it previous state '*'
				savedP = indexP;
				 //move the saved_s, next time it should skip current one
				savedS = indexS + 1;
				indexP++;
			}
			else if(savedP != -1) {
				//means not match, we need to revert 
				indexP = savedP;
				indexS = savedS;
			}
			else {
				//means not match, but not wildcard
				return false;
			}
		}
		//examine the left char in the pattern
        //they should all be '*' if any char left
		for(int index = indexP; index < p.length(); index++) {
			if(p.charAt(index) != '*') {
				return false;
			}
		}
		return true;
	}
}
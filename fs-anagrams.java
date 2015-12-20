public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            }
            else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < t.length();i++) {
            char c = t.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.get(c) != 0) {
                return false;
            }
        }
        return true;
    }
}
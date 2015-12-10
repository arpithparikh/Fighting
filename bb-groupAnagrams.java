Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(strs == null || strs.length == 0) {
        	return res;
        }
        可以不加下面这个条件，加了仅仅是为了ac而已，让出现的单词按照字母先后排列
        Arrays.sort(strs);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for(int i = 0; i < strs.length; i++) {
        	char[] arr = strs[i].toCharAray();
        	Arrays.sort(arr);
        	String str1 = new String(arr);
        	if(map.containsKey(str1)) {
        		ArrayList<String> temp = map.get(str1);
        		temp.add(strs[i]);
        		map.put(str1, temp);
        	}
        	else {
        		ArrayList<String> temp = new ArrayList<String>();
        		temp.add(strs[i]);
        		map.put(str1, temp);
        	}
        }
        for(String str : map.keySet()) {
        	res.add(map.get(str));
        }
        return res;
    }
}
public class Solution {
	public String alienOrder(String[] words) {
		//step1 construct graph
		//step2 construct order
		//step3 traverse graph

		//initail graph
		HashMap<Character, HashSet<Character>> map = new HashMap<Character, HashSet<Character>>();
		for(int i = 0; i < words.length; i++) {
			for(int j = 0; j < words[i].length(); j++) {
				if(!map.containsKey(words[i].charAt(j))) {
					map.put(words[i].charAt(j), new HashSet<Character>());
				}
			}
			if(i > 0) {
				order(map, words[i - 1], words[i]);
			}
		}
		return topoSort(map);
	}
	public String topoSort(HashMap<Character, HashSet<Character>> graph) {
		Queue<Character> queue = new LinkedList<Character>();
		HashMap<Character, Integer> indegree = new HashMap<Character, Integer>();
		StringBuffer sb = new StringBuffer();
		int numNode = 0;
		for(char c : graph.keySet()) {
			for(char a : graph.get(c)) {
				int count = indegree.containsKey(a) ? indegree.get(a) + 1 : 1;
				indegree.put(a, count);
			}
		}
		for(char c : graph.keySet()) {
			if(!indegree.containsKey(c)) {
				queue.offer(c);
			}
		}
		while(!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);
			numNode++;
			for(char a : graph.get(c)) {
				indegree.put(a, indegree.get(a) - 1);
				if(indegree.get(a) == 0) {
					queue.offer(a);
				}
			}
		}
		if(numNode != graph.size()) {
			return "";
		}
		return sb.toString();
	}
	private void order(HashMap<Character, HashSet<Character>> map, String prev, String cur) {
		int minLength = Math.min(prev.length(), cur.length());
		for(int i = 0; i < minLength; i++) {
			char p = prev.charAt(i);
			char c = cur.charAt(i);
			if(p != c) {
				if(!map.get(p).contains(c)) {
					map.get(p).add(c);
				}
				break;
			}
		}
	}
}
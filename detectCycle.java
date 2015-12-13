假设给你了两个list，一个list是node，一个list是edge
假设图中允许单个node的存在
首先判断node数目和edge，如果假设n个点，但是有超过n-1条边，那么就一定有环的存在
public class Solution {
	public boolean hasCycle(ArrayList<Node> nodes, ArrayList<Edge> edges) {
		for(Node node : nodes) {
			if(detect(node : edges)) {
				return true;
			}
		}
		return false;
	}
	private boolean detect(Node node, ArrayList<Edge> edges) {
		HashSet<Node> set = new HashSet<Node>();
		if(set.contains(node)) {
			return true;
		}
		set.add(node);
		boolean res = false;
		for(Edge  edge: edges) {
			if(edge.start == node && !set.contains(edge.end)) {
				res = res || detect(edge.end, edges);
			}
		}
		return res;
	}
}
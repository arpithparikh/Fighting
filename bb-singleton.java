class Solution {
	private static Solution s = null;
	public static Solution getInstance() {
		if(s == null) {
			s = new Solution();
		}
		return s;
	}
}
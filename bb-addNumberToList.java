数字游戏 给一个list, list中有两个数. 
过程中可以一直往list中加数进去(append在最后), 
但必须一直遵守三个条件: 
1. list中所有数均需大于0 
2. list中所有数都必须为unique 
3. 新加入的数必须为已存在list中的某两数的差

要做的事情是把所有可能的过程(一直加到没办法加入新的数字为止)都给打印或是回传

ex. [30, 5], 则最新加入的数只能为25, list变为[30, 5, 25] 继续, 
只能再加入20, list成为[30, 5, 25, 20], 接着就有两种选择,
 可以加10(30-20) 或是15(20-5). 于是会分出两个branch [30, 5, 25, 20, 10] 跟[30, 5, 25, 20, 15], 
 然后再把最后一个可能补上之后变成 [30, 5, 25, 20, 10, 15]跟[30, 5, 25, 20, 15, 10]

 public class Solution {
 	public ArrayList<ArrayList<Integer>> find(int[] nums) {
 		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
 		if(nums == null || nums.length < 2) {
 			return res;
 		}
 		ArrayList<Integer> temp = new ArrayList<Integer>();
 		temp.add(nums[0]);
 		temp.add(nums[1]);
 		helper(res, temp);
 		return res;
 	}
 	private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> temp) {
 		HashSet<Integer> set = new HashSet<Integer>();
 		for(int i = 0; i < temp.size(); i++) {
 			int candidate = Math.abs(temp.get(i) - temp.get(temp.size() - 1));
 			if(!temp.contains(candidate) && !set.contains(candidate)) {
 				temp.add(candidate);
 				set.add(candidate);
 				helper(res, temp);
 				set.remove(candidate);
 				temp.remove(temp.size() - 1);
 			}
 		}
 		if(set.size() == 0) {
 			res.add(new ArrayList<Integer>(temp));
 		}
 	}
 }
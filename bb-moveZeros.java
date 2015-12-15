public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int nonZero = 0;
        int zero = 0;
        while(zero < nums.length) {
        	if(nums[zero] != 0) {
        		int temp = nums[zero];
        		nums[zero] = nums[nonZero];
        		nums[nonZero] = temp;
        		zero++;
        		nonZero++;
        	}
        	else {
        		zero++;
        	}
        }
    }
}


//这个做法是没有保留原有的顺序的
public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
        	return;
        }
        int nonZero = 0;
        int zero = nums.length - 1;
        while(nonZero < zero) {
        	if(nums[nonZero] != 0) {
        		nonZero++;
        	}
        	if(nums[zero] == 0) {
        		zero--;
        	}
        	else {
        		int temp = nums[nonZero];
        		nums[nonZero] = nums[zero];
        		nums[zero] = temp;
        		nonZero++;
        		zero--;
        	}
        }
    }
}
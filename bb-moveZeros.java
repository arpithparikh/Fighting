public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0) {
            return;
        }
        int zero = 0;
        int nonZero = 0;
        while(zero < nums.length) {
            if(nums[zero] != 0) {
                doSwap(nums, zero, nonZero);
                nonZero++;
                zero++;
            }
            else {
                zero++;
            }
        }
    }
    private void doSwap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
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
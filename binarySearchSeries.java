//first bad version
class Solution {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        // write your code here
        if(n < 1) {
            return 0;
        }
        int start = 1;
        int end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(SVNRepo.isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(SVNRepo.isBadVersion(start)) {
            return start;
        }
        else if(SVNRepo.isBadVersion(end)) {
            return end;
        }
        else {
            return 0;
        }
    }
}
//Search in Rotated Sorted Array II
public class Solution {
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return false;
        }
        for(Integer item : A) {
            if(item == target) {
                return true;
            }
        }
        return false;
    }
}

//Search in Rotated Sorted Array 
public class Solution {
    public int search(int[] A, int target) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == A[start]) {
                return mid;
            }
            else if(A[mid] > A[start]) {
                if(A[start] <= target && target <= A[mid]) {
                    end = mid;
                }
                else {
                    start = mid;
                }
            }
            else {
                if(A[mid] <= target && target <= A[end]) {
                    start = mid;
                }
                else {
                    end = mid;
                }
            }
        }
        if(A[start] == target) {
            return start;
        }
        else if(A[end] == target) {
            return end;
        }
        else {
            return -1;
        }
    }
}

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
//search for a range
public class Solution {
    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A == null || A.length == 0) {
            return res;
        }
        res[0] = findFirstIndex(A, target);
        res[1] = findLastIndex(A, target);
        return res;
    }
    private int findFirstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
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
    private int findLastIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}
//total occurence of target
public class Solution {
    /**
     * @param A an integer array sorted in ascending order
     * @param target an integer
     * @return an integer
     */
    public int totalOccurrence(int[] A, int target) {
        // Write your code here
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        if(A == null || A.length == 0) {
            return 0;
        }
        res[0] = findFirstIndex(A, target);
        res[1] = findLastIndex(A, target);
        if(res[0] == -1 || res[1] == -1) {
            return 0;
        }
        else {
            return res[1] - res[0] + 1;
        }
    }
     private int findFirstIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] >= target) {
                end = mid;
            }
            else {
                start = mid;
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
    private int findLastIndex(int[] A, int target) {
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] <= target) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[end] == target) {
            return end;
        }
        else if(A[start] == target) {
            return start;
        }
        else {
            return -1;
        }
    }
}
//search insert position
public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid] == target) {
                return mid;
            }
            else if(A[mid] > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(A[start] >= target) {
            return start;
        }
        else if(A[end] >= target) {
            return end;
        }
        else {
            return end + 1;
        }
    }
}

//find peak
class Solution {
    public int findPeak(int[] A) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int start = 0;
        int end = A.length - 1;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(A[mid - 1] < A[mid] && A[mid] > A[mid + 1]) {
                return mid;
            }
            else if(A[mid - 1] < A[mid]) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if(A[start] > A[end]) {
            return start;
        }
        else {
            return end;
        }
    }
}
//sqrt(x)
class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x < 1) {
            return 0;
        }
        long target = x;
        long start = 1;
        long end = x;
        while(start + 1 < end) {
            long mid = start + (end - start) / 2;
            if(mid * mid == target) {
                return (int)mid;
            }
            else if(mid * mid > target) {
                end = mid;
            }
            else {
                start = mid;
            }
        }
        if(end * end == target) {
            return (int)end;
        }
        else return (int)start;
    }
}
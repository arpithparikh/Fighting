public class Solution {
    public int hIndex(int[] citations) {
        if(citations == null || citations.length == 0) {
        	return 0;
        }
        Arrays.sort(citations);
        //这里的关键有两点，一点是需要知道
        for(int i = 0; i < citations.length; i++) {
        	int numCitations = citations[i];
        	int numPaper = citations.length - i;
        	if(numCitations >= numPaper) {
        		return numPaper;
        	}
        }
        return 0;
    }
}

//利用后缀和
public class Solution {
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0) {
			return 0;
		}
		int length = citations.length;
		int[] res = new int[length + 1];
		for(int i = 0; i < length; i++) {
			if(citations[i] >= length) {
				res[length]++;
			}
			else {
				res[citations[i]]++;
			}
		}
		for(int i = length - 1; i > 0; i--) {
			res[i] += res[i - 1];
		}
		for(int i = length; i > 0; i--) {
			if(res[i] >= i) {
				return i;
			}
		}
		return 0;
	}
}
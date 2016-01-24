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
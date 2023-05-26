class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        long start = 0 ;
        long end = (long)times[0]*n;
        long passPeopleNum ;
        
        while(start<=end){
            long mid = (start+end)/2;
            passPeopleNum=0 ;
            for(long time:times){
                passPeopleNum += (mid/time);
            }

            if(passPeopleNum>=n){
                answer = mid ;
                end = mid -1 ;
            }else{
                start = mid + 1 ;
            }
        }
        
        return start;
    }
}
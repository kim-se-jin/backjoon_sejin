import java.util.*;
import java.io.*;

class Solution {
    static long answer ;
    public long solution(int[] sequence) {
        answer = 0;
        int len = sequence.length;
        long[] plusSum = new long[len+1];
        long[] mSum = new long[len+1];
        int flag = 1 ;
        for(int i=0;i<len;i++){
            plusSum[i+1] += plusSum[i] + sequence[i]*flag;
            
            flag*= -1 ;
            mSum[i+1] += mSum[i]+ sequence[i]*flag;
        }
        
        twoPointer(plusSum,len);
        twoPointer(mSum,len);
        

        return answer;
    }
    
    public static void twoPointer(long[] arr, int len){
        int left = 0 ;
        int right = 1;
        while(right<=len){
            long sum = arr[right]-arr[left];
            if(sum > answer){
                answer = sum;
            }
            
            if(sum>0){
                right ++;
            }else{
                left=right++;
            }
        }
    }
}
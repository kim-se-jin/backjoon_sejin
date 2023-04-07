class Solution {
    public String solution(String s) {
        String answer = "";
        int maxA = Integer.MIN_VALUE;
        int minA = Integer.MAX_VALUE;
        
        String[] inputs = s.split(" ");
        for(int i=0;i<inputs.length;i++){
            int now = Integer.parseInt(inputs[i]);
            maxA = Math.max(maxA, now);
            minA = Math.min(minA, now);
                
        }
        answer = minA + " " + maxA;
        return answer;
    }
}
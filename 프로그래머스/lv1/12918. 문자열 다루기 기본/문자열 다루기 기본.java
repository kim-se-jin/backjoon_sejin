class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() ==4 || s.length()==6){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)-'0'> 9 || s.charAt(i)-'0'<0){
                answer = false;
                break;
            
            }
        }   
        }else answer = false;
        return answer;
    }
}
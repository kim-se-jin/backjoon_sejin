class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0;i<s.length();i++){
            s = s.substring(1,s.length()) + s.substring(0,1);
            if(check(s.split(""))){
                answer ++;
            }
        }
        
        return answer;
    }
    
    static int s,m,l;
    public static boolean check(String[] str){
        for(int i=0;i<str.length;i++){
            switch(str[i]){
                case "{":
                    l ++;
                    break;
                case "}":
                    if(l==0) return false;
                    else l--;
                    break;
                case "[":
                    m ++;
                    break;
                case "]":
                    if(m==0) return false;
                    else m--;
                    break;
                case "(":
                    s++;
                    break;
                case ")":
                    if(s==0) return false;
                    else s--;
                    break;    
            }
        }
        if(s==0 && m==0 && l==0) return true;
        else return false;
    }
}
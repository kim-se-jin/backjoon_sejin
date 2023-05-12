#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string s) {
    string answer = "";
    bool first = true ;
    for(int i=0;i<s.size();i++){
        
        if(s[i] == ' '){
            first = true ;
            answer += " ";
            continue ;
        }
        
        if(first){ // 공백 다음 문자
            answer += toupper(s[i]);
            first = false ;
        }else{
            answer += tolower(s[i]);
        }
        
    }
    return answer;
}
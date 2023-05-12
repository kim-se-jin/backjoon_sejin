#include <string>
#include <vector>

using namespace std;

string solution(string s) {
    string answer = "";

    answer += toupper(s[0]); // 첫번째 무조건 대문자
    for(int i=1; i<s.size(); i++){
        answer += (s[i-1] == ' ' ? toupper(s[i]):tolower(s[i]));
    }
    
    

    return answer;
}

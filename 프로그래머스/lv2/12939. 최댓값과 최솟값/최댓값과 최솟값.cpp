#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string solution(string s) {
    string answer = "";
    
    string tmp = "";
    vector<int> v ;
    for(int i=0;i<s.size();i++){
        if(s[i] == ' '){ // 공백으로 구문되어 있으므로
            v.push_back(stoi(tmp));
            tmp = "";
        }else{
            tmp += s[i];
        }
    }
    
    v.push_back(stoi(tmp)); // 마지막 요소는 공백X, 따로 추가
    sort(v.begin(), v.end());
    
    answer = to_string(v.front()) + " " + to_string(v.back());
    
    return answer;
}
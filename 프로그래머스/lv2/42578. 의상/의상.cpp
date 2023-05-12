#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> map ;
    for(int i=0;i<clothes.size();i++){
        string cate = clothes[i][1];
        map[cate] ++ ;
    }
    
    for(auto it=map.begin();it!=map.end();it++){
        answer *= (it->second+1);
    }
    
    return answer-1;
}
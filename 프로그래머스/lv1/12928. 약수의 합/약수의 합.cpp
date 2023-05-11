#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(int n) {
    int answer = 0;
    // 약수 구하는 방법
        // 1부터 n 까지 나누면서 나머지가 0 일 대
    for(int i=1;i<=n;i++){
        if(n%i == 0){
            // cout << i << "\n" ;
            answer += i ;
        }
    }
    
    return answer;
}
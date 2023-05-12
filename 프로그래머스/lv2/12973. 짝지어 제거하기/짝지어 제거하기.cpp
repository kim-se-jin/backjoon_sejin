#include <iostream>
#include<string>
#include<stack>
#include<iostream>
using namespace std;

int solution(string s)
{
    int answer = -1;
    int idx = 0;
    stack<char> stacks ;
    
    while(idx < s.length()){
        
        if(stacks.empty() || stacks.top() != s[idx]) stacks.push(s[idx]);
        else stacks.pop();
        
        idx ++ ;
        
        // stack<char> ss = stacks ;
        // while(!ss.empty()){
        //     cout << ss.top() << endl;
        //     ss.pop();
        // }
        // cout << "--" << endl;
    }
    
    if(stacks.empty()) return 1 ;
    else return 0;
}
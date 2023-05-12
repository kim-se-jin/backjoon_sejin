#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string, int> hash_map;

    // 각 의상의 종류별로 개수를 센다
    for (int i = 0; i < clothes.size(); i++) {
        string category = clothes[i][1];  // 의상의 종류
        hash_map[category]++;
    }

    // (의상의 종류별 개수 + 1)을 곱해준다
    for (auto it = hash_map.begin(); it != hash_map.end(); it++) {
        answer *= (it->second + 1);
    }

    // 아무것도 입지 않은 경우를 제외한다
    answer--;

    return answer;
}

int main() {
    vector<vector<string>> clothes = {
        {"yellow_hat", "headgear"},
        {"blue_sunglasses", "eyewear"},
        {"green_turban", "headgear"}
    };

    int result = solution(clothes);
    cout << "Number of possible combinations: " << result << endl;

    return 0;
}
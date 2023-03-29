import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
 
class Main {
    static char[] arr;
    static int[] result;
    static int N;
    static int M;
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        N = Integer.parseInt(str[0]);
        M = Integer.parseInt(str[1]);
        arr = new char[M];
        result = new int[M];
        str = br.readLine().split(" ");
        for (int i = 0; i < M; i++) {
            arr[i] = str[i].charAt(0);
        }
 
        Arrays.sort(arr);
        DFS(0, 0, 0, 0);
    }
 
    // 시작점, 선택된 문자갯수, 자음갯수, 모음갯수
    public static void DFS(int start, int depth, int ja, int mo) {
 
        for (int i = start; i < M; i++) {
            result[i] = 1; // 선택된 문자 확인용
            // 자음과 모음 갯수를 파악해서 다음으로 넘겨준다.
            DFS(i + 1, depth + 1, ja + (!check(arr[i]) ? 1 : 0), mo + (!check(arr[i]) ? 0 : 1));
 
            result[i] = 0; // 0이면 선택 안됨
        }
        // 문자갯수가 N개이며 자음과 모음의 갯수가 규칙에 맞을때만 출력한다.
        if (depth == N && ja >= 2 && mo >= 1) {
            print();
        }
    }
 
    public static void print() {
        for (int i = 0; i < M; i++) {
            // result가 0이라면 선택되지 않았기 때문에 넘긴다.
            if (result[i] == 1)
                System.out.print(arr[i]);
        }
        System.out.println();
    }
 
    // 자음 모음 파악 함수
    public static boolean check(char a) {
        if (a == 'a' || a == 'e' || a == 'i' || a == 'o' || a == 'u')
            return true;
        else
            return false;
    }
 
}
import java.util.*;
import java.io.*;
 
class Main {
    static int N;  // 마을 수
    static int[] person_nums; // 마을 주민 수 
    static ArrayList<Integer>[] graph ; // 지도
    static int[][] dp ;

    public static int stoi(String s){
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws Exception {
        // 값 입력받기 -->
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
        person_nums = new int[N];
        dp = new int[2][N];

        graph = new ArrayList[N];
        for(int i=0;i<N;i++) graph[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++)person_nums[i] = stoi(st.nextToken()); // 사람 수 받기
        
        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken()) -1;
            int y = stoi(st.nextToken()) -1;
            graph[x].add(y);
            graph[y].add(x);
        }
        // <--

        Find(0,0);
        System.out.println(Math.max(dp[0][0], dp[1][0]));
    }

    // dp[0][i] : 우수마을인 경우
    // dp[1][i] : 우수마을 X 인 경우
    public static void Find(int idx, int parent){
        for(int nxt : graph[idx]){
            if(nxt != parent){
                Find(nxt, idx);
                dp[0][idx] += Math.max(dp[1][nxt], dp[0][nxt]); // 연결마을이 우수마을X 일 때, 나 자신 우수마을
                dp[1][idx] += dp[0][nxt];
            }
        }
        dp[1][idx] += person_nums[idx];
    }

}


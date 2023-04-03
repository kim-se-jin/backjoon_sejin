import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
 
public class Main {
    static ArrayList<Integer>[] arr;
    static int[] dp;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken(); // -1 건너뛰기
        arr = new ArrayList[N];
        dp = new int[N];
        for(int i=0;i<N;i++)arr[i] = new ArrayList<>();
        for(int i=1;i<N;i++) arr[Integer.parseInt(st.nextToken())].add(i);

        System.out.println(DFS(0));

    }

    public static int DFS(int now){
        int cnt=0,max=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1,o2)->o2[1]-o1[1]); // 
        for(int nxt:arr[now]){
            dp[nxt] = DFS(nxt);
            q.add(new int[]{nxt, dp[nxt]});
        }

        while(!q.isEmpty()){
            int[] nowArr = q.poll();
            cnt++;
            max = Math.max(max, nowArr[1]+cnt);
        }

        return max ;
    }
 
}

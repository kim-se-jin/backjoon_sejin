import java.io.*;
import java.util.*;

public class Main {
    static int N,arr[],cnt[];
    public static int stoi(String str){return Integer.parseInt(str);}
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N+1];
        cnt = new int[1_000_001];

        for(int i=1;i<=N;i++)arr[i] = stoi(st.nextToken());
        System.out.println(twoPointer());
    }
   
    public static long twoPointer(){
        int left = 1 ;
        int right = 0 ;
        long ans = 0 ;

        while(left<=N){
            while(right+1<=N && cnt[arr[right+1]] == 0){
                right ++ ;
                cnt[arr[right]] ++ ;
            }

            ans += (right - left + 1);
            cnt[arr[left++]]--;
        }

        return ans ;
    }

}

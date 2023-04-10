import java.util.*;
import java.io.*;
public class Main {

    static int N,M,arr[];
    static HashMap<Integer, Integer> hm;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        M = stoi(st.nextToken());
        arr = new int[N];
        hm = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(twoPointer());

    }

    public static int twoPointer(){
        int start = 0 ;
        int end = 0 ;
        int ans = 0 ;

        while(end<N && start<N){
            // System.out.println("s : " + start + " ,e: " + end + ",hm: " + hm.toString());
            while(end<N && hm.getOrDefault(arr[end], 0)<M){
                // System.out.println("IN WHILE !! s : " + start + " ,e: " + end + ",hm: " + hm.toString());
                // System.out.println(hm.getOrDefault(arr[end], 0));
                hm.put(arr[end], hm.getOrDefault(arr[end], 0)+1);
                end ++ ; 
            }
            ans = Math.max(ans, end-start);
            hm.put(arr[start], hm.get(arr[start])-1);
            start ++ ;
            // hm.put(arr[start],hm.getOrDefault(arr[start], 0)+1);
        }

        if(ans == 0) ans = N ;
        return ans;
    }
}
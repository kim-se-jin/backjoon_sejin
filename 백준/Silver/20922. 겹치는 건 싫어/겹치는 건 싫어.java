import java.io.*;
import java.util.*;
 
public class Main {
    static int N, K;
    static int[] arr, numbers;
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
 
        arr = new int[N];
        numbers = new int[100001];
 
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            arr[i] = number;
        }
 
        int max = 0;
        int left = 0;
        int right = 0;
        numbers[arr[right]]++;
 
        while(right < N) {
            if(numbers[arr[right]] <= K) {
            	if(right - left + 1 > max) max = right - left + 1;
            	right++;
            	if(right == N) break;
            	numbers[arr[right]]++;
            }
            else {
            	numbers[arr[left]]--;
            	left++;
            }
        }
 
        System.out.println(max);
    }
}
import java.io.*;
import java.util.*;
public class Main {

	static int N, arr[], newArr[], ans;
	static boolean visited[];
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new int[N];
		visited = new boolean[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		newArr = new int[N];
		DFS(0,0);
		System.out.println(ans);
		
    }

	public static void DFS(int idx, int depth){

		if(depth == N){
			ans = Math.max(ans,cal(newArr));
			return;
		}

		for(int i=0;i<N;i++){
			if(!visited[i]){
				visited[i] = true;
				newArr[depth] = arr[i];
				DFS(i,depth+1);
				visited[i] = false;
			}
		}
	}

	public static int cal(int[] arr){
		int sum = 0 ;
		for(int i=1;i<N;i++){
			sum += Math.abs(arr[i-1]-arr[i]);
		}
		return sum;
	}
}
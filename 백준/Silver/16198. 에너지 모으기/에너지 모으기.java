import java.io.*;
import java.util.*;
 
public class Main {
	static int ans ;
	static ArrayList<Integer> arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			arr.add(Integer.parseInt(st.nextToken()));
		}

		DFS(arr, 0);

		System.out.print(ans);
	}

	public static void DFS(ArrayList<Integer> arr, int sum){
		if(arr.size() <= 2){
			ans = Math.max(ans, sum);
			return ;
		}

		for(int i=1;i<arr.size()-1;i++){
			int temp = arr.get(i);
			int nowNum = arr.get(i-1)*arr.get(i+1);
			arr.remove(i);
			DFS(arr, sum+nowNum);
			arr.add(i, temp);
		}
	}
 
}
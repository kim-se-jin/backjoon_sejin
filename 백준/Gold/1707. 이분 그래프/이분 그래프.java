import java.io.*;
import java.util.*;


public class Main{

	static int TC, N ;
	static int V,E;
	static ArrayList<Integer>[] arr ;
	static int[] colors ;
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TC = stoi(br.readLine());


		while(TC>0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = stoi(st.nextToken()); // 정점 개수
			E = stoi(st.nextToken()); // 간선 개수
			arr = new ArrayList[V];
			colors = new int[V];

			for(int i=0;i<V;i++) arr[i] = new ArrayList<>();

			for(int i=0;i<E;i++){
				st = new StringTokenizer(br.readLine());
				int x = stoi(st.nextToken())-1;
				int y = stoi(st.nextToken())-1;
				arr[x].add(y);
				arr[y].add(x);
			}
			//<-- 값 입력받기

			boolean flag = true;
			for(int i=0;i<V;i++){
				if(colors[i] == 0 )DFS(i,1);
			}
			// System.out.println(Arrays.toString(colors));

			for(int i=0;i<V;i++){
				for(int j : arr[i]){
					if(colors[i] == colors[j]) flag = false ;
				}
			}

			System.out.println(flag?"YES":"NO");
			TC--;
		}
	}

	public static void DFS(int idx, int nowColor){
		if(colors[idx] != 0 ) return ;
		colors[idx] = nowColor;
		for(int nowIdx : arr[idx]){
			if(colors[nowIdx] == 0 ){
				DFS(nowIdx, 3-nowColor);
			}
		}
	}
}


// Union-Find XX
// 1
// 4 5
// 1 2
// 2 3
// 3 4
// 4 1
// 1 4
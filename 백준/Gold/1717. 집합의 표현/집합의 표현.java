import java.io.*;
import java.util.*;

public class Main {

	static int N,M;
	static int[] parent ;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		for(int i=0;i<N+1;i++) parent[i] = i;

        StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			if(flag == 0 ){
				union(a,b);
			}else{
				int aParent = find(a);
				int bParent = find(b);
				if (aParent == bParent) sb.append("YES"+"\n");
				else sb.append("NO"+"\n");
			}
		}
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
	}

	public static void union(int x, int y){
		x = find(x);
		y = find(y);
		if(x==y) return;
		parent[y] = x ;
	}

	public static int find(int idx){
		if(idx == parent[idx]) return idx;
		parent[idx] = find(parent[idx]);
		return parent[idx];
	}
}
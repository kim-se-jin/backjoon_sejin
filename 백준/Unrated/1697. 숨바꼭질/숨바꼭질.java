import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{

	static int N , K ;
	static int[] check ;
	static int maxNum ;
	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		K = stoi(st.nextToken());
		check = new int[100001];
		maxNum = 100001;

		if(N==K)System.out.println(0);
		else BFS(N);

		}

	public static void BFS(int start){
		Queue<Integer> q = new LinkedList<>();
		// x는 idx, y는 count
		q.add(start);
		check[start] = 1 ;

		while(!q.isEmpty()){
			
			int now = q.poll();

			for(int i=0;i<3;i++){
				int xx = 0 ;
				if(i==0) xx = now - 1 ;
				else if(i==1) xx = now + 1 ;
				else xx = now * 2;
				// System.out.println(i+" , " + xx);
				if(xx == K ){
					System.out.println(check[now]);
					return;
				}			
	
				if(xx>=0 && xx<maxNum && check[xx]==0){
					q.add(xx);
					check[xx] = check[now]+1;
				}
			}

		}
	}
}
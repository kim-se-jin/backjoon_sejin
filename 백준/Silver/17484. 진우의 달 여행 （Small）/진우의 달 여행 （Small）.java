import java.io.*;
import java.util.*;

public class Main{

	static int N,M,arr[][],ans;
	static int[] dx={1,1,1},dy={-1,0,1};

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N][M];
		ans = Integer.MAX_VALUE;

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				arr[i][j] = stoi(st.nextToken());
			}
		}
		
		for(int i=0;i<M;i++){
			go(0,i,-1,0,arr[0][i]);
		}

		System.out.println(ans);
    }

	public static void go(int x, int y, int dist, int count, int sum){
		if(x==N-1){
			ans = Math.min(ans, sum);
			return ;
		}
		for(int i=0;i<3;i++){
			if(dist == i ) continue ;
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx<0 || yy<0 || xx>=N || yy>=M ) continue ;
			go(xx,yy,i,count+1,sum+arr[xx][yy]);
		}
	}


}

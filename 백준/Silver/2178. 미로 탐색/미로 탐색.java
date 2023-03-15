import java.io.*;
import java.util.*;
import java.awt.Point;

class shortCut implements Comparable<shortCut>{
	int start,end,dist;
	shortCut(int start, int end, int dist){
		this.start = start;
		this.end = end;
		this.dist = dist;
	}

	@Override
	public int compareTo(shortCut o) {
		if(this.start == o.start){
			return this.dist - o.dist ;
		}else if(this.end == o.end){
			return this.start - o.start ;
		}else return this.start - o.start;
	}

}

public class Main{

	static int N , M ;
	static int[][] arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N][M];

		for(int i=0;i<N;i++){
			char[] inputs = br.readLine().toCharArray();
			for(int j=0;j<M;j++){
				arr[i][j] = inputs[j]-'0';
			}
		}

		BFS(0,0);
		System.out.println(arr[N-1][M-1]);

		}

	static int[] dx = {-1,0,1,0},dy={0,1,0,-1};

	public static void BFS(int x, int y){
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(x,y));

		while(!q.isEmpty()){
			Point now = q.poll();
			for(int i=0;i<4;i++){
				int xx = now.x+dx[i];
				int yy = now.y+dy[i];
				if(xx<0 || xx>=N || yy<0 || yy>=M ) continue ;
				if(arr[xx][yy] == 1 ){
					arr[xx][yy] = arr[now.x][now.y] + 1;
					q.add(new Point(xx,yy));
				}
			}
		}
	}
}

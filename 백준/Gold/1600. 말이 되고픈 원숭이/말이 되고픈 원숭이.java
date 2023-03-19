import java.io.*;
import java.util.*;
import java.awt.Point;

class Node{
	int x,y,count,k;
	Node(int x, int y, int count, int k){
		this.x = x;
		this.y = y ;
		this.count = count;
		this.k = k;
	}
}

public class Main{

	static int K , N , M , count ;
	static int[][] map ;
    static int min = Integer.MAX_VALUE;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = stoi(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = stoi(st.nextToken());
		N = stoi(st.nextToken());
		map = new int[N][M];

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++){
				map[i][j] = stoi(st.nextToken());
			}
		}
		//<--
		min = startMove();
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

	}

	static int[] dx={-1,0,1,0},dy={0,-1,0,1};
	static int[] horseX={-2, -2, -1, -1, 1, 1, 2, 2},horseY={-1, 1, -2, 2, -2, 2, -1, 1};

	public static int startMove(){
		boolean[][][] visited = new boolean[N][M][K+1];

		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0,0,K));
		visited[0][0][K] = true ;

		while(!q.isEmpty()){
			Node now = q.poll();
			if(now.x == N-1 && now.y == M-1) return now.count ;

			for(int i=0;i<4;i++){
				int xx = now.x+dx[i];
				int yy = now.y+dy[i];
                if(xx >= 0 && yy >= 0 && xx < N && yy < M && !visited[xx][yy][now.k] && map[xx][yy] == 0) {
                    visited[xx][yy][now.k] = true;
                    q.offer(new Node(xx, yy, now.count + 1, now.k));
                }
	
			}

			if(now.k <= 0 ) continue ;
			for(int j=0;j<8;j++){
				int xx = now.x + horseX[j];
				int yy = now.y + horseY[j];
                if(xx >= 0 && yy >= 0 && xx < N && yy < M && !visited[xx][yy][now.k-1] && map[xx][yy] == 0) {
                    visited[xx][yy][now.k-1] = true;
                    q.offer(new Node(xx, yy, now.count + 1, now.k-1));
                }
			}
		}
		return min ;
	}
}
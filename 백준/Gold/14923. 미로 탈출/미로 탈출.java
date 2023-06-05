import java.io.*;
import java.util.*;

class Node{
	int x,y,cnt,used;
	Node(int x, int y, int cnt, int used){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
		this.used = used;// 0 : 씀, 1 : 안씀
	}
}

public class Main {
	
	static int N,M,arr[][],startX,startY,endX,endY;
	static boolean visited[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		visited = new boolean[2][N][M]; // 0 : 씀, 1 : 안씀

		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken())-1;
		startY = Integer.parseInt(st.nextToken())-1;

		st = new StringTokenizer(br.readLine());
		endX = Integer.parseInt(st.nextToken())-1;
		endY = Integer.parseInt(st.nextToken())-1;
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		
		if(!BFS()) System.out.println("-1");

		// for(boolean[] a : visited[0]){
		// 	System.out.println(Arrays.toString(a));
		// }

	}

	static int[]dx={-1,0,1,0},dy={0,-1,0,1};

	public static boolean BFS(){
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(startX, startY, 0, 1));
		visited[1][startX][startY] = true ;

		while(!q.isEmpty()){
			Node nowNode = q.poll();
			// System.out.println(nowNode.x + " , " + nowNode.y);
			if(nowNode.x == endX && nowNode.y == endY){
				System.out.println(nowNode.cnt);
				return true;
			}

			for(int i=0;i<4;i++){
				int xx=nowNode.x + dx[i];
				int yy=nowNode.y + dy[i];
	
				if(xx<0 || xx>=N || yy<0 || yy>=M) continue ;


				if(arr[xx][yy] == 0 && !visited[nowNode.used][xx][yy]){
					visited[nowNode.used][xx][yy] = true ;
					q.add(new Node(xx, yy, nowNode.cnt+1, nowNode.used));
				}else if(arr[xx][yy] == 1 && nowNode.used==1){
					visited[0][xx][yy] = true ;
					q.add(new Node(xx, yy, nowNode.cnt+1, 0));
				}

			}

		}
		return false ;
	}
}
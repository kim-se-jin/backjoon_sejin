import java.util.*;
import java.io.*;
import java.awt.Point;

public class Main {

    static int N;
    static int MaxSafeZone = Integer.MIN_VALUE;
    static int MaxHeight = Integer.MIN_VALUE;
    static int[][] map ;
    static boolean[][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Queue<Point> que = new LinkedList<>();

    public static void main(String[] args) throws Exception{

        // 값 입력받기 -- >
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
                MaxHeight = Math.max(MaxHeight,map[i][j]);
			}
		}
        // <-- 값 입력받기

        //높이 0~MaxHeight 까지
        for (int h=0;h<MaxHeight;h++){
            int SafeZone = 0;
            visited = new boolean[N][N];

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j]>h && !visited[i][j]){
                        FindSafeZone(i,j,h);
                        SafeZone += 1;
                    }
                }
            }
            MaxSafeZone = Math.max(MaxSafeZone, SafeZone);
        }
        System.out.println(MaxSafeZone);
    }

    public static void FindSafeZone(int x, int y, int Height){
        visited[x][y] = true;

        for(int k=0;k<4;k++){
            int xx = x+dx[k];
            int yy = y+dy[k];
            if (xx<0 || xx>=N || yy<0 || yy>=N) continue;
            if (map[xx][yy] > Height && !visited[xx][yy]){
                FindSafeZone(xx, yy, Height);
            }
        }
    }

}
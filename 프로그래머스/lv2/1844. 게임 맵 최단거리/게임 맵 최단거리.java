import java.io.*;
import java.util.*;
import java.awt.Point;

class Solution {
    
    static int N,M,answer,visited[][];
    
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        visited = new int[N][M];
        BFS(maps);
        return visited[N-1][M-1]==0?-1:visited[N-1][M-1];
    }
    
    // 최단 경로 : BFS !
    
    static int[] dx={-1,0,1,0},dy={0,-1,0,1};
    
    public static boolean BFS(int[][] map){
        visited[0][0] = 1 ;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        
        while(!q.isEmpty()){
            Point now = q.poll();
            if(now.x == N-1 && now.y == M-1) return true ;
            map[now.x][now.y] = 0 ;

            
            for(int i=0;i<4;i++){
                int xx=now.x+dx[i];
                int yy=now.y+dy[i];
                if(xx<0||xx>=N||yy<0||yy>=M)continue;

                if(visited[xx][yy] == 0 && map[xx][yy] == 1 ){
                    q.add(new Point(xx,yy));
                    visited[xx][yy] = visited[now.x][now.y] + 1 ;
                }
            }
        }
        return false ;
    }
    
}

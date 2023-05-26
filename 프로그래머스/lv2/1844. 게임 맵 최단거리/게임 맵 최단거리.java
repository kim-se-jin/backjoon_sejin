import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int answer = 0;

        int[] dy={0,0,-1,1};
        int[] dx={1,-1,0,0};
        int col = maps[0].length-1, row = maps.length-1;

        int[][] visited = new int[maps.length][maps[0].length];
        visited[0][0]=1;
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});

        while(queue.size()>0){
            int[] cur=queue.removeFirst();
            if(cur[0]==row&&cur[1]==col){
                return visited[row][col];
            }

            int x=cur[1];
            int y=cur[0];
            maps[y][x]=0;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];
                if(ny<0 || nx<0 || nx>col || ny> row)continue;
                if(maps[ny][nx]==1&&visited[ny][nx]==0){
                    queue.addLast(new int[]{ny,nx});
                    visited[ny][nx]=visited[y][x]+1;       
                }
            }
        }

        return -1;
    }
}
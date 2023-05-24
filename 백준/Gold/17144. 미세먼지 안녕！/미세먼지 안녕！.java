import java.io.*;
import java.util.*;
import java.awt.Point;

class dust{
    int x,y,w;
    dust(int x, int y, int w){
        this.x = x;
        this.y = y;
        this.w = w;
    }
}

public class Main {
    static int R,C,T, arr[][], cleaner;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 가로
        C = Integer.parseInt(st.nextToken()); // 세로
        T = Integer.parseInt(st.nextToken()); // T초 후
        arr = new int[R][C];
        cleaner = -1 ;

        for(int i=0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<C;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == -1 && cleaner == -1 ) cleaner = i ;
            }
        }

        while(T-->0){
            checkDust();
            AirCleaner();
        }

        int res = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(arr[i][j] == -1) continue;
                res += arr[i][j];
            }
        }
        
        System.out.print(res);

    }

    // 모든 칸에서 동시에.
    // 확산되는 양은 Ar,c/5, (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 
    static Queue<dust> q;
    public static void checkDust(){
        q = new LinkedList<>();
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                if(arr[i][j] > 0 ) q.add(new dust(i, j, arr[i][j]));
            }
        }
        
        spreadDust();
    }

    static int dx[] = {-1,0,1,0},dy[]={0,-1,0,1};
    public static void spreadDust(){
        while(!q.isEmpty()){
            dust now = q.poll();
            if(now.w < 5 ) continue ;

            int amountOfSpread = now.w/5 ;
            int cnt = 0;

            for(int i=0;i<4;i++){
                int xx =now.x+dx[i];
                int yy =now.y+dy[i];
                if(xx<0 || xx>=R || yy<0 || yy>=C || arr[xx][yy] == -1) continue ;
                arr[xx][yy] += amountOfSpread ;
                cnt ++ ;
            }

            arr[now.x][now.y] -= amountOfSpread*cnt;
        }

    }

    // 위쪽 공기청정기의 바람은 반시계방향으로 순환하고, 아래쪽 공기청정기의 바람은 시계방향으로 순환한다.
    // 바람이 불면 미세먼지가 바람의 방향대로 모두 한 칸씩 이동한다.
    // 공기청정기에서 부는 바람은 미세먼지가 없는 바람이고, 공기청정기로 들어간 미세먼지는 모두 정화된다.
    // (0,cleanerTop), (0,cleanerDown)
    public static void AirCleaner(){
        int top = cleaner;
        int down = cleaner + 1;

      // 위쪽 공기청정기의 바람은 반시계방향 순환,
        // 아래로 당기기
        for (int i = top - 1; i > 0; i--) arr[i][0] = arr[i-1][0];
            
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) arr[0][i] = arr[0][i+1];
           
        // 위로 당기기
        for (int i = 0; i < top; i++) arr[i][C - 1] = arr[i + 1][C - 1];
            
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) arr[top][i] = arr[top][i-1];
           
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        arr[top][1] = 0;

              
        // 아래쪽 공기청정기의 바람은 시계방향으로 순환
        // 위로 당기기
        for (int i = down + 1; i < R - 1; i++) arr[i][0] = arr[i + 1][0];
            
        // 왼쪽으로 당기기
        for (int i = 0; i < C - 1; i++) arr[R - 1][i] = arr[R - 1][i + 1]; 
            
        // 아래로 당기기
        for (int i = R - 1; i > down; i--)  arr[i][C - 1] = arr[i - 1][C - 1];
           
        // 오른쪽으로 당기기
        for (int i = C - 1; i > 1; i--) arr[down][i] = arr[down][i - 1];
            
        // 공기청정기에서 부는 바람은 미세먼지가 없는 바람
        arr[down][1] = 0;
    }

}
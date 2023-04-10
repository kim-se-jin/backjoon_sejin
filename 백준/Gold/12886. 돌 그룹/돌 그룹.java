import java.util.*;
import java.io.*;
public class Main {

    static int A,B,C;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = stoi(st.nextToken());
        B = stoi(st.nextToken());
        C = stoi(st.nextToken());
        
        DFS(A,B,C,0);
    }

    public static void DFS(int a, int b, int c,int depth){
        if(depth == 5000){
             System.out.println(0);
             System.exit(0);
        }
        if(!check(a,b,c)){
            if(a<b){
                DFS(a*2,b-a,c,depth+1);
            }
            if(a<c){
                DFS(a*2,b,c-a,depth+1);
            }
            if(b<c){
                DFS(a,b*2,c-b,depth+1);
            }

            if(c<a) DFS(a-c, b, c*2, depth+1);
            if(c<b) DFS(a, b-c, c*2, depth+1);
            if(b<a) DFS(a-b, b*2, c, depth+1);
        }else{
            System.out.println(1);
            System.exit(0);
        }
    }

    public static boolean check(int a, int b, int c){
        if(a==b && b==c) return true;
        return false;
    }
}
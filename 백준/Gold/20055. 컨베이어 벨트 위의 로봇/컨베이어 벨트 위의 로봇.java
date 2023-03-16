import java.io.*;
import java.util.*;

public class Main {

    static int N,K, beltLength;
    static int[] arr ;
    static boolean[] robots ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken()); // 벨트 길이
        beltLength = 2*N ;
        K = stoi(st.nextToken()); // 내구성이 K개가 되었을 때 끝
        arr = new int[beltLength];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<beltLength;i++) arr[i] = stoi(st.nextToken());

        int count = 0 ;
        robots = new boolean[N];

        while(checkZero()){
            RotateBelt(); // 벨트 회전
            onBoardRobot(); // 로봇 탑승
            count ++ ;
        }        

        System.out.println(count);


    }

    public static void RotateBelt(){
        int temp = arr[beltLength-1];

        for (int i = beltLength - 1; i > 0; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp ;
    }

    public static void onBoardRobot(){

        for (int i = N-1 ; i > 0; i--) {
            robots[i] = robots[i-1]; 
        }
        robots[0] = false ;
        robots[N - 1] = false; // 내리는 위치, 내려줌

        // 로봇 이동
        for (int i = N - 1; i > 0; i--) {  
            if (robots[i - 1] && !robots[i] && arr[i] >= 1) {
                robots[i] = true;
                robots[i - 1] = false;
                arr[i]--;
            }
        }

        // 로봇 올려
        if (arr[0] > 0) { 
            robots[0] = true;
            arr[0]--;
        }
        
    }

    public static boolean checkZero() {
        int cnt = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                cnt++;
            }
            if (cnt >= K) {
                return false;
            }
        }
        return true;
    }

}
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;
    static int[] calArr = new int[4];
    static int MinResult = Integer.MAX_VALUE;
    static int MaxResult = Integer.MIN_VALUE;
    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException{
        // 값 입력받기 -->
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<4;i++){
            calArr[i] = Integer.parseInt(st.nextToken());                        
        }
        //<-- 
        Calculator(arr[0],1,calArr[0],calArr[1],calArr[2],calArr[3]);
        System.out.println(MaxResult);
        System.out.println(MinResult);

    }

    public static void Calculator(int total, int idx, int plus, int minus, int multiply, int divide){
        if(idx==N){
            MinResult = Math.min(total, MinResult);
            MaxResult = Math.max(total, MaxResult);
            return;
        }
        if (plus>0){
            Calculator(total+arr[idx], idx+1,plus-1, minus, multiply, divide);
        }
        if (minus>0){
            Calculator(total-arr[idx], idx+1,plus, minus-1, multiply, divide);
        }
        if (multiply>0){
            Calculator(total*arr[idx], idx+1,plus, minus, multiply-1, divide);
        }
        if (divide>0){
            Calculator(total/arr[idx], idx+1,plus, minus, multiply, divide-1);
        }
    
    }

}
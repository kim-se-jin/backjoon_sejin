import java.io.*;
import java.util.*;

public class Main{

	static int N,X;
	static int[] sumArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        N = stoi(st.nextToken());
        X = stoi(st.nextToken());
        sumArr = new int[N+1];
        
		st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            sumArr[i] = sumArr[i-1] + Integer.parseInt(st.nextToken());
        }

		int maxVisitNum = 0 ;
		int count = 0 ;
		for(int i=X;i<=N;i++){
			int nowVisit = sumArr[i] - sumArr[i-X];
			if(nowVisit == maxVisitNum) count ++ ;
			else if(nowVisit > maxVisitNum){
				maxVisitNum = nowVisit;
				count = 1 ;
			}
			
		}

		if(maxVisitNum>0){
			System.out.println(maxVisitNum);
			System.out.println(count);
		}else System.out.println("SAD");
    }
}

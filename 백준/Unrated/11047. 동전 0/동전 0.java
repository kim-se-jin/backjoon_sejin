import java.io.*;
import java.util.*;

public class Main{

	static int N,allSum ;
	static int[] coinArr;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken());
		allSum = stoi(st.nextToken());
		coinArr = new int[N];

		for(int i=N-1;i>=0;i--){
			coinArr[i] = stoi(br.readLine());
		}
		//<--
		int count = 0 ;

		for(int i=0;i<N;i++){
			while(coinArr[i] <= allSum && allSum >= 0){
				if(allSum - coinArr[i] >= 0 ){
					allSum -= coinArr[i];
					count ++ ;
				}else break;
			}
			if(allSum == 0) break;
		}

		System.out.println(count);

	}
}
import java.io.*;
import java.util.*;

public class Main {

	static int N, MaxScore;
	static double AllScore; 
	static int[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine()); 
		arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		// 2. 전체합 구한 다음 /maxScore/N
		for(int i=0;i<N;i++){			
			arr[i] = stoi(st.nextToken());
			AllScore += arr[i];
		}

		Arrays.sort(arr);
		System.out.println(AllScore/arr[N-1]/N * 100);
	} 
}
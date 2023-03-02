import java.io.*;
import java.util.*;
import java.awt.Point ;

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
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());

		MaxScore = Arrays.stream(arr).max().getAsInt();

		for(int i=0;i<N;i++){
			AllScore += ((double)arr[i]/MaxScore)*100 ;

		}

		System.out.println(AllScore/N);
	} 


}

// 40 80 60
// 50 100 75
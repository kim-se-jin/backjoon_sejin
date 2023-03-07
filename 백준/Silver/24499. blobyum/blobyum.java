import java.io.*;
import java.util.*;

public class Main{

	static int N,K ;
	static int[] arr ;
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken()); // 애플파이 개수
		K = stoi(st.nextToken()); // 먹으려는 개수
		arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) arr[i] = stoi(st.nextToken());
		// N개의 파이 중 연속으로 K개의 애플파이 먹기
			// N이 10의5승 이므로 슬라이딩 윈도우

		System.out.println(Sliding());
    }

	public static int Sliding(){
		int nowTaste = 0 ;

		nowTaste = FirstEat();
		int MaxTaste = nowTaste ;
		// System.out.println(nowTaste);
		
		for(int i=1;i<N;i++){
			int removeIndx = i-1 ;
			int addIdx = (i+K-1)%N;
			// System.out.println("remove: " + removeIndx + " ,add: " + addIdx);
			// System.out.println("arr[removeIndx]: " + arr[removeIndx] + " , arr[addIdx]: " +  arr[addIdx]);

			nowTaste = nowTaste - arr[removeIndx] + arr[addIdx];
			// System.out.println(nowTaste);
			MaxTaste = Math.max(MaxTaste, nowTaste);
		}
		return MaxTaste;
	}

	public static int FirstEat(){
		int sum = 0 ;
		for(int i=0;i<K;i++) sum += arr[i];
		return sum;
	}
}
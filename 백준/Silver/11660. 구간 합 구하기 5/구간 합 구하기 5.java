import java.io.*;
import java.util.*;

// n층짜리 창고가진 회사
// m층짜리 창고 마련하여 이전

// 최대한 많은 물품, 크기 같음, 각 층에 몇 개
// k명의 인부 고용
// a번층으로 이동해서 한 개의 물품 들어올려 b번 층으로 이동 = a+b 의 시간 소요
// 많은 물품을 옮길 때 드는 최소 시간

public class Main {

	static int N,M;
	static int[][] arr,sumArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken());
		M = stoi(st.nextToken());
		arr = new int[N][N];
		sumArr = new int[N+1][N+1];

		// 값 입력받기
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[i][j] = stoi(st.nextToken());
			}
		}

		// 누적합 계산
		for(int i=1;i<N+1;i++){
			for(int j=1;j<N+1;j++){
				sumArr[i][j] = sumArr[i][j-1] + sumArr[i-1][j] - sumArr[i-1][j-1] + arr[i-1][j-1];
			}
		}

		// 누적합 구하기
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int x1 = stoi(st.nextToken());
			int y1 = stoi(st.nextToken());
			int x2 = stoi(st.nextToken());
			int y2 = stoi(st.nextToken());
			sb.append(prefixSum(x1,y1,x2,y2)+"\n");
		}
		System.out.println(sb.toString());

	} 

	public static int prefixSum(int x1, int y1, int x2, int y2){
		return sumArr[x2][y2] - sumArr[x1-1][y2] - sumArr[x2][y1-1] + sumArr[x1-1][y1-1];
	}

}
import java.io.*;
import java.util.*;

public class Main{

	static int TC, N , M , count ;
	static int[] aArr , bArr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		TC = stoi(br.readLine());

		for(int testCase = 0 ; testCase<TC; testCase++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken());
			M = stoi(st.nextToken());
			count = 0 ;
			aArr = new int[N];
			bArr = new int[M];

			// a배열, a의 모든 값과 b배열을 비교하므로 a배열은 정렬 필요X
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) aArr[i] = stoi(st.nextToken());

			// b배열
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) bArr[i] = stoi(st.nextToken());
			Arrays.sort(bArr);

			for(int nowNum : aArr){
				count += findIn_bArr(nowNum);
			}

			sb.append(count+"\n");

		}
		System.out.print(sb);
	}

	public static int findIn_bArr(int nowNum){
		int start = 0 ;
		int end = bArr.length -1 ;
		int nowIdx = -1 ;
		while(start<=end){
			int mid = (start+end)/2;
			if(bArr[mid] < nowNum){
				nowIdx = mid ; // end를 리턴하믄 되나?
				start = mid + 1 ;
			}else {
				end = mid - 1 ;
			}
		}

		return(nowIdx+1) ; // 0번 인덱스부터 시작이므로
	}

}
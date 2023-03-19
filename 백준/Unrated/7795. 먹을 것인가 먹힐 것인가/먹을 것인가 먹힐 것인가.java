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

			// a배열 : TreeSet을 활용한 중복없이, 순서대로 저장하기
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) aArr[i] = stoi(st.nextToken());
			Arrays.sort(aArr);
			// b배열
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<M;i++) bArr[i] = stoi(st.nextToken());
			Arrays.sort(bArr);

			// System.out.println(Arrays.toString(aArr));
			// System.out.println(Arrays.toString(bArr));

			for(int nowNum : aArr){
				// System.out.println("start a : " + nowNum);
				count += findIn_bArr(nowNum);
				// System.out.println();
			}

			sb.append(count+"\n");

		}
		System.out.print(sb);
	}

	public static int findIn_bArr(int nowNum){
		int start = 0 ;
		int end = bArr.length -1 ;
		int nowIdx = 0 ;
		boolean flag = false;
		while(start<=end){
			int mid = (start+end)/2;
			// System.out.println("bef : "+mid);
			// System.out.println("bArr[mid] : "+bArr[mid] + " ,nowNum: " + nowNum);

			if(bArr[mid] < nowNum){
				// System.out.println("true");
				flag = true ;
				nowIdx = mid ; // end를 리턴하믄 되나?
				start = mid + 1 ;
			}else {
				end = mid - 1 ;
			}
			// System.out.println("end : "+start + " , " + end + " , "  + nowNum);

		}

		return flag?(nowIdx+1):0 ; // 0번 인덱스부터 시작이므로
	}

}
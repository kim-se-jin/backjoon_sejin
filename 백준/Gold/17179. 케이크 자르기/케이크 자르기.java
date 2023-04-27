import java.io.*;
import java.util.*;
public class Main {
	static int N,M,L, arr[];
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken()); // 자르는 횟수 길이
		M = stoi(st.nextToken()); // 자를 수 있는 지점 개수
		L = stoi(st.nextToken()); // 롤케이크 길이
		arr = new int[M+2];
		
		for(int i=1;i<M+1;i++) arr[i] = stoi(br.readLine()); // cut 정보
		arr[M+1]=L;
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<N;i++){
			int idx = stoi(br.readLine());
			sb.append(binarySearch(idx)+"\n");
		}
		System.out.print(sb);
    }

	public static int binarySearch(int wantPiece){
		// 최소 길이를 기준으로 계산 !!!!
		// 몇등분이냐가 들어오지만, 
			// 0~70까지 최소길이를 계산하여 최소길이가 n일 때, idx 등분이 된다면 return ~~~
		int ans = Integer.MIN_VALUE ;
		int left = 0 ;
		int right = L ;
		while(left<=right){
			int mid = (left+right)/2;
			int piece = calPiece(mid);
			// System.out.println("l : " + left +" ,r : " + right+ " ,p : " + piece);
			if(piece > wantPiece){
				ans = Math.max(ans, mid);
				left = mid+1;
			}else{
				right = mid -1 ;
			}
		}
		return ans ;
	}

	public static int calPiece(int minLen){
		int cnt = 0 ;
		int bef = arr[0] ;

		for(int i=1;i<M+2;i++){
			if(arr[i]-bef >= minLen){
				cnt ++;
				bef = arr[i];
			}
		}

		return cnt ;
	}
}
import java.io.*;
import java.util.*;
public class Main {

	static int N,start,end ;
	static long arr[], ans ;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = stoi(br.readLine());
		arr = new long[N+1];
		arr[0] = 1 ;
		start = 0 ;
		end = N-1;

		recur(N);
		System.out.print(arr[N]);
    }

	public static long recur(int idx){
		if(idx == 0 ) return 1 ;
		if(arr[idx] != 0 ) return arr[idx];
		
		ans = 0 ;
		for(int i=0;i<idx;i++){
			if(arr[i] == 0 ) arr[i] = recur(i);
			if(arr[idx-i-1] == 0) arr[idx-i-1] = recur(idx-i-1);
			// System.out.println(i + " , " + (idx-i-1));
			arr[idx] += (arr[i] * arr[idx-i-1]);
			// System.out.println("now idx : " + idx + " ,now ans : " + ans);

			// System.out.println();
		}
		// System.out.println("return  ! "+ arr[idx]);
		return arr[idx];
	}

	// public static long recur(int num){
	// 	if(arr[num] != 0) return arr[num];
	// 	if(start == N-1) return arr[start] ;
	// 	if(end == 0) return arr[0];

	// 	ans += recur(start++) * recur(end--);
	// 	return ans ;
		
	// }
}
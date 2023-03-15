import java.io.*;
import java.util.*;

public class Main{

	static int N ;
	static int[] arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = stoi(br.readLine());
		arr = new int[N*N];

		int idx = 0;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				arr[idx] = stoi(st.nextToken());
				idx++;
			}
		}

		for(int i=0;i<N;i++) Arrays.sort(arr);
		System.out.println(arr[(N*N)-N]);
		}
    }

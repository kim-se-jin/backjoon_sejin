import java.io.*;
import java.util.*;

public class Main {
	static int N,M,nums[];
	static Set<String> set ;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st = new StringTokenizer(br.readLine());
		set = new HashSet<>();

		N = stoi(st.nextToken()); // 메모장 키워드 수
		M = stoi(st.nextToken()); // 블로그 글 수

		for(int i=0;i<N;i++){
			set.add(br.readLine());
		}
		StringBuilder sb = new StringBuilder();

		for(int i=0;i<M;i++){
			String[] arr = br.readLine().split(",");
			sb.append(find(arr)+"\n");
		}

		System.out.print(sb);
		
    }

	public static int find(String[] arr){
		int cnt = N ;
		for(int i=0;i<arr.length;i++){
			if(set.contains(arr[i])) set.remove(arr[i]);
		}

		return set.size() ;
	}

}
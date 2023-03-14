import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{ 
	int idx, num ;
	Node(int idx, int num){
		this.idx = idx ;
		this.num = num ;
	}

	@Override
	public int compareTo(Node o){
		return this.num-o.num;
	}
}

public class Main{

	static int N ;
	static int[] arr,sortArr;
	static HashMap<Integer,Integer> hm;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new int[N];
		sortArr = new int[N];
		hm = new HashMap<>();

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++){
			int now = stoi(st.nextToken());
			arr[i] = now ;
			sortArr[i] = now;
		}
		//<-- 값 입력받기

		Arrays.sort(sortArr);
		calCount();

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<N;i++) sb.append(hm.get(arr[i]) + " ");
		System.out.println(sb);
    }
    
    // 정렬된 상태의 배열 + 중복 제거를 위한 해시맵 = 중복 제거&&정렬 상태의 값들의 순위가 매겨짐
	public static void calCount(){
		int count = 0 ;
		for(int idx : sortArr){
			if(!hm.containsKey(idx)){
				hm.put(idx, count);
				count ++ ;
			}
		}

	}

}
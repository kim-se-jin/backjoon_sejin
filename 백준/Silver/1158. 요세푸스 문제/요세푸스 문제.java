import java.io.*;
import java.util.*;
import java.awt.Point ;

public class Main {

	static int N,K,nowIdx;
	static ArrayList<Integer> arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new ArrayList<>();
		N = stoi(st.nextToken()); // N명
		K = stoi(st.nextToken())-1; // K번째 사람 제거

		for(int i=1;i<N+1;i++) arr.add(i); // 1	부터 N까지 채움

		StringBuilder sb = new StringBuilder();
		int count = 0 ;

		sb.append("<");
		while(arr.size() > 1){
			nowIdx = (nowIdx+K)%arr.size();
			sb.append(arr.get(nowIdx) +", ");
			arr.remove(nowIdx);
		}

		sb.append(arr.get(0) + ">");

		System.out.println(sb.toString());
	} 

}
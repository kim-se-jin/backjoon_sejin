import java.io.*;
import java.util.*;

class voca implements Comparable<voca>{
	String str;
	int count ;
	voca(String str, int count){
		this.str = str;
		this.count = count;
	} 

	@Override
	public int compareTo(voca o){
		// System.out.println(o.str + " , " + o.count);
		if(this.count == o.count){

			if(o.str.length() == this.str.length()) return this.str.compareTo(o.str); // 우선순위 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
			else return o.str.length()-this.str.length(); // 우선순위 2. 해당 단어의 길이가 길수록 앞에 배치한다.
		
		}else return o.count - this.count; // 우선순위 1. 자주 나오는 단어일수록 앞에 배치한다.
		
	}
}

public class Main {

	static int N,M;
	static String str ;
	static PriorityQueue<voca> pq ;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		pq = new PriorityQueue<>();
		HashMap<String, Integer> hm = new HashMap<>(); // 문자와 인덱스 저장

		for(int i=0;i<N;i++){
			str = br.readLine();
			if(str.length() < M ) continue ; // M이상인 단어들만 외운다
			hm.put(str, hm.getOrDefault(str, 0)+1);
		}

		for(String str : hm.keySet()){
			pq.offer(new voca(str, hm.get(str)));
		}

		StringBuilder sb = new StringBuilder();
		while(!pq.isEmpty()){
			voca nowVoca = pq.poll();
			sb.append(nowVoca.str+"\n");
		}

		System.out.print(sb);

	}
}
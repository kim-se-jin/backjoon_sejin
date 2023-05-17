import java.util.*;
import java.io.*;

class Main {
	static int stoi(String s) { return Integer.parseInt(s); }

	static int N,M,FactKnowPeople ;
	static boolean[] knowFact;
	static ArrayList<Integer>[] partyArr ;
	static Queue<Integer> q;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = stoi(st.nextToken()); // 사람 수
		M = stoi(st.nextToken()); // 파티 수
		partyArr = new ArrayList[M];
		q = new LinkedList<>();


		// 진실을 아는 사람 -->
		st = new StringTokenizer(br.readLine());
		FactKnowPeople = stoi(st.nextToken());
		if(FactKnowPeople == 0){
			System.out.println(M);
			return ;
		}
		knowFact = new boolean[N];
		for(int i=0;i<FactKnowPeople;i++){
			int now = stoi(st.nextToken())-1;
			knowFact[now] = true ;
			q.add(now);
		}
		//<--

		// 파티마다 오는 사람 수, 번호
		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			int nums = stoi(st.nextToken());
			partyArr[i] = new ArrayList<>();

			for(int j=0;j<nums;j++){
				partyArr[i].add(stoi(st.nextToken())-1);
				
			}
		}
		//<--

		spreadFact();
		System.out.println(CheckOkLie());
	}

	public static void spreadFact(){
		while(!q.isEmpty()){
			int now = q.poll();

			for(int j=0;j<M;j++){
				if(partyArr[j].contains(now)){
					for(int k=0;k<partyArr[j].size();k++){
						int nowPeople = partyArr[j].get(k);
						if(!knowFact[nowPeople]){
							knowFact[nowPeople] = true ;
							q.add(nowPeople);
						}
					}
				}
			}

		}
	}

	public static int CheckOkLie(){
		int cnt = 0 ;

		for(int i=0;i<M;i++){
			boolean check = false ;
			for(int j=0;j<partyArr[i].size();j++){
				if(knowFact[partyArr[i].get(j)]){
					check = true ;
					break;
				}
			}
			if(!check) cnt ++ ;
		}

		return cnt ;
	}
}
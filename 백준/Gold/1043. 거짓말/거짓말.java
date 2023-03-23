import java.io.*;
import java.util.*;


public class Main{

	static int N,M,K ;
	static StringBuilder sb ;
	static int[] parent;
	static boolean[] truth;
	static ArrayList<Integer>[] partyArr;
	static boolean[] visited ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();

		N = stoi(st.nextToken()); // 사람 수
		M = stoi(st.nextToken()); // 파티 수

		st = new StringTokenizer(br.readLine());
		K = stoi(st.nextToken()); // 진실을 아는 사람
		make();

		for(int i=0;i<K;i++){ // 진실 아는 사람 입력받기
			int now = stoi(st.nextToken())-1;
			truth[now] = true ;
		}

		for(int i=0;i<M;i++){ // 각 파티 참여자 입력받기
			String[] inputs = br.readLine().split(" ");
			int peopleNum = stoi(inputs[0]);

			if(peopleNum<=1){
				partyArr[i].add(stoi(inputs[1])-1);
				continue ;
			}
			for(int j=1;j<peopleNum;j++){
				int x = stoi(inputs[j])-1;
				int y = stoi(inputs[j+1])-1;
				if(find(x)!=find(y)) union(x,y);
				partyArr[i].add(x);
                partyArr[i].add(y);
			}
		}
        
        visited = new boolean[N];
		// N명을 탐색하며 진실을 알고있는 사람인 경우, 관련된 사람을 모두 true 로
		for(int i=0;i<N;i++){
			if(truth[i] && !visited[i]){
				int root = find(i);
				for(int j=0;j<N;j++){
					if(find(j) == root ){
						truth[j] = true;
						visited[j] = true ;
					}
				}
			}
		}

		// System.out.println(Arrays.toString(visited));
		int count = 0 ;

		for(ArrayList<Integer> arr : partyArr){
			boolean check = false;
			for(int idx : arr ){
				if(truth[idx]){
					check = true ;
					break;
				}
			}
			if(!check)count ++;
		}

		System.out.println(count);

	}

	public static void make(){
		partyArr = new ArrayList[M];
		for(int i=0;i<M;i++) partyArr[i] = new ArrayList<>();

		parent = new int[N]; // 부모 초기값 설정
		for(int i=0;i<N;i++)parent[i] = i ;
		truth = new boolean[N];

	}

	public static void union(int x, int y){
		// 그냥 여기서 visited면 visited로 바꾸면 안되남
		y = find(y);
		parent[y] = x ;
	}

	public static int find(int idx){
		if(parent[idx] == idx) return idx ;
		else return find(parent[idx]);
	}


}

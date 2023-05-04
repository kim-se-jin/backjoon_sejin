import java.io.*;
import java.util.*;

class scoreBoard implements Comparable<scoreBoard>{
	int id, score, count, lastSubmit ;
	scoreBoard(int id, int score, int count, int lastSubmit){
		this.id = id ;
		this.score = score;
		this.count = count;
		this.lastSubmit = lastSubmit;
	}
	@Override
	public int compareTo(scoreBoard o){
		if(this.score != o.score) return o.score - this.score; // 점수 높은순
		else if (this.count != o.count ) return this.count - o.count; // 제출 횟수 낮은 순
		else return this.lastSubmit - o.lastSubmit ; // 마지막 제출 낮은 순
		
	}
}

public class Main {

	static int T,N,K,ansId, M;
	static int[] count ; // 풀이 제출 회수
	static int[] lastSubmit ;
	static int[][] check ;
	
	static scoreBoard[] arr ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = stoi(br.readLine());
		StringTokenizer st ;

		while(T-->0){
			st = new StringTokenizer(br.readLine());
			N = stoi(st.nextToken()); // 팀의 개수
			K = stoi(st.nextToken()); // 문제 개수
			ansId = stoi(st.nextToken())-1; // 내가 출력할 순위
			M = stoi(st.nextToken()); // 로그 개수

			arr = new scoreBoard[N];
			count = new int[N]; // 각 팀 문제 제출 횟수
			lastSubmit = new int[N]; // 마지막 제출
			check = new int[N][K]; // 각 팀의 문제당 제출 여부

			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				int nowId = stoi(st.nextToken())-1;
				int num = stoi(st.nextToken())-1;
				int score = stoi(st.nextToken());

				check[nowId][num] = Math.max(check[nowId][num], score);
				count[nowId] ++ ;
				lastSubmit[nowId] = i ;
			}

			for(int i=0;i<N;i++){
				int sum = 0 ;
				for(int j=0;j<K;j++) sum += check[i][j];
				arr[i] = new scoreBoard(i, sum, count[i], lastSubmit[i]);
			}
	
			Arrays.sort(arr);
			for(int i=0;i<N;i++){
				if(arr[i].id == ansId) System.out.println(i+1);
			}
		}
    }

}
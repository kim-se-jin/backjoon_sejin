import java.io.*;
import java.util.*;

class lectureRoom implements Comparable<lectureRoom>{ 
	int start,end ;
	lectureRoom(int start, int end){
		this.start = start ;
		this.end = end ;
	}

	@Override
	public int compareTo(lectureRoom o){
		if(this.end == o.end) return this.start - o.start;
		else return this.end-o.end;
	}
}

public class Main{

	static int N ;
	static lectureRoom[] arr ;

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = stoi(br.readLine());
		arr = new lectureRoom[N];

		StringTokenizer st;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new lectureRoom(stoi(st.nextToken()), stoi(st.nextToken()));
		}
		//<-- 값 입력받기

		Arrays.sort(arr); // 빨리 끝나는 시간 순 정렬

		// 한 개의 강의실로 최대 회의, 끝나면 바로 교체

		// 첫번째로 끝나는 강의
		int endTime = arr[0].end;
		int count = 1 ;

		for(int i=1;i<N;i++){
			if(endTime <= arr[i].start){
				endTime = arr[i].end ;
				count ++ ;
			}
		}
		System.out.println(count);
    }
}
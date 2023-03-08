import java.io.*;
import java.util.*;

class lectureRoom implements Comparable<lectureRoom>{
	int start, end ;
	lectureRoom(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(lectureRoom o) {
		if(this.end == o.end) return this.start - o.start;
		return this.end - o.end;
	}

}

public class Main{

	static int N;
	static lectureRoom[] room ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		N = Integer.parseInt(br.readLine()); // N개의 회의
		room = new lectureRoom[N];
		int count = 0 ;

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int start = stoi(st.nextToken());
			int end = stoi(st.nextToken());
			room[i] = new lectureRoom(start, end);
		}

		Arrays.sort(room);

		int befEnd = room[0].end ;
		count ++ ;

		for(int i=1;i<N;i++){
			int nxtStart = room[i].start;
			int nxtEnd = room[i].end;

			if(befEnd <= nxtStart){
				befEnd = nxtEnd;
				count ++ ;
				// System.out.println(nxtStart + " , " + nxtEnd);
			}
		}


		System.out.println(count);
    }
}
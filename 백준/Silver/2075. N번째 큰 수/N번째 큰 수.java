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
		PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o2-o1);

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++){
				pq.add(stoi(st.nextToken()));
			}
		}

		for(int i=0;i<N-1;i++) pq.poll();
		System.out.println(pq.peek());
		}
    }

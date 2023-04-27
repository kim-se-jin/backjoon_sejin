import java.io.*;
import java.util.*;
import java.awt.Point;

class Node implements Comparable<Node>{
	int start,end;
	Node(int start, int end){
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Node o){
		if(this.start != o.start) return this.start - o.start ;
		else return this.end - o.end ;
	}
}

public class Main {
	static int N;
	static Node[] arr ;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		N = stoi(br.readLine());
		arr = new Node[N];
		
		StringTokenizer st ;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int x = stoi(st.nextToken());
			int y = stoi(st.nextToken());
			arr[i] = new Node(x,y);
		}
		Arrays.sort(arr);

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(arr[0].end);
		for(int i=1;i<N;i++){
			int lastEnd = pq.peek();
			if(arr[i].start >= lastEnd) pq.poll();

			pq.add(arr[i].end);
			// System.out.println(pq.toString());
		}
		System.out.print(pq.size());

    }
}
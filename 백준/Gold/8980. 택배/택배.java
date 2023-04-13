import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
	int x,y,cost;
	Node(int x, int y, int cost){
		this.x=x;
		this.y=y;
		this.cost=cost;
	}

	@Override
	public int compareTo(Node o){
		if(this.y != o.y) return this.y - o.y;
		else return this.x - o.x;
		
	}

}
 
public class Main {
	static int N,M,C;
	static Node[] arr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 마을 수 
		C = Integer.parseInt(st.nextToken()); // 트럭의 용량 C
		
		M = Integer.parseInt(br.readLine()); // 박스 정보의 개수
		arr = new Node[M];

		for(int i=0;i<M;i++){
			st = new StringTokenizer(br.readLine());
			arr[i] = new Node(
				Integer.parseInt(st.nextToken())-1,  //x
				Integer.parseInt(st.nextToken())-1, // y
				Integer.parseInt(st.nextToken())); // cost
		}

		Arrays.sort(arr);
		
		int[] weight = new int[N];
		Arrays.fill(weight,C);
		weight[N-1] = 0 ;
		long allSum = 0 ;

		for(Node nowNode : arr){
			int possibleCost = Integer.MAX_VALUE;
			for(int i=nowNode.x;i<nowNode.y;i++) possibleCost = Math.min(possibleCost, weight[i]);
			
			int nowCost = Math.min(possibleCost, nowNode.cost);
			allSum += nowCost;
			for(int i=nowNode.x;i<nowNode.y;i++) weight[i] -= nowCost;

		}
		System.out.println(allSum);
    }
}
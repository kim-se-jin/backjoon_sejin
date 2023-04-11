import java.io.*;
import java.util.*;

class Node {
	int idx,cost;
	Node(int idx, int cost){
		this.idx = idx;
		this.cost = cost ;
	}
}

public class Main {
    static int N ;
    static ArrayList<Node>[] tree ;
	static int idx,dist;
	static boolean[] visited ;

    public static int stoi(String str){
        return Integer.parseInt(str);
    }

    public static void main(String[] args) throws IOException {
         Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
		tree = new ArrayList[N];
		for(int i=0;i<N;i++)tree[i] = new ArrayList<>();
		visited = new boolean[N];

        for(int i = 0; i < N; i++) {
            int s = scan.nextInt()-1;
            while(true) {
                int e = scan.nextInt();
                if(e == -1) break;
                int cost = scan.nextInt();
                tree[s].add(new Node((e-1), cost));
            }
        }

        
		visited[0] = true ;
		DFS(0,0);
		visited = new boolean[N];
		visited[maxIdx] = true ;
		DFS(maxIdx,0);
		System.out.println(maxResult);


	}

	static int maxResult , maxIdx ;

	public static void DFS(int num, int dist){
		if(dist > maxResult){
			maxResult = dist ;
			maxIdx = num ;
		}
        visited[num]=true;
		
		for(Node nxtNode:tree[num]){
			if(!visited[nxtNode.idx]){
				visited[nxtNode.idx] = true ;
				DFS(nxtNode.idx , nxtNode.cost + dist);
			}
			
		}

	}

}
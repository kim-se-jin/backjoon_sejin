import java.util.*;
import java.io.*;
import java.lang.Math ;

class Node implements Comparable<Node>{
	int num;
	double x,y;
	Node(int num, double x, double y){
		this.num = num ;
		this.x = x ;
		this.y = y ;
	}

	@Override
	public int compareTo(Node o){
		// if(this.x != o.x) 
		return (int)(this.x - o.x) ;
		// else return (int)(this.y - o.y) ;
	}
}


class Edge implements Comparable<Edge>{
	int start,end;
	double w; 
	Edge(int start, int end, double w){
		this.start = start ;
		this.end = end ;
		this.w = w ;
	}

	@Override
	public int compareTo(Edge o){
		if(this.w < o.w ) return -1 ;
		return 1 ;
	}
}

public class Main {
    
	static int N,parent[] ;
	static Node[] points ;
	static ArrayList<Edge> edgeList ;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		points = new Node[N];
		edgeList = new ArrayList<>();

		StringTokenizer st ;
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			points[i] = new Node(i,x,y);
		}

		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				double weight = distance(points[i], points[j]);
				edgeList.add(new Edge(points[i].num, points[j].num, weight));
			}
		}

		Collections.sort(edgeList);

		parent = new int[N];
		for(int i=0;i<N;i++)parent[i] = i ;

		System.out.print(kruscal());
    }

	public static double distance(Node o1, Node o2){
		return Math.sqrt(Math.pow(o2.y-o1.y,2) + Math.pow(o2.x-o1.x,2));
	}

	public static double kruscal(){
		double ans = 0 ;

		for(Edge edge : edgeList){
			if(find(edge.start) != find(edge.end)){
				union(edge.start, edge.end);
				ans += edge.w ;
			}
		}

		return Math.round(ans*100)/100.0 ;
	}

	public static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a==b)return ;
		parent[b] = a ;
	}

	public static int find(int idx){
		if(parent[idx] == idx) return idx ;
		else return find(parent[idx]);
	}
}
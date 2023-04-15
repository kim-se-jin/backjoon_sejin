import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visited ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); 
		
		StringTokenizer st;
		HashSet<Integer> hm = new HashSet();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<N;i++){
			// System.out.println(hm.toString());
			st = new StringTokenizer(br.readLine());
			String input =st.nextToken();
			int num = 0 ;
			switch(input){
				case "add":
				 	num = Integer.parseInt(st.nextToken());
					if(!hm.contains(num)&& check(num)) hm.add(num);
					break;
				case "remove":
					num = Integer.parseInt(st.nextToken());
					if(hm.contains(num)&& check(num)) hm.remove(num);
					break;
				case "check":
					num = Integer.parseInt(st.nextToken());
					if(hm.contains(num) && check(num)) sb.append(1+"\n");
					else sb.append(0+"\n");
					break;
				case "toggle":
					num = Integer.parseInt(st.nextToken());
					if(hm.contains(num)&& check(num)) hm.remove(num);
					else hm.add(num);
					break;
				case "all":
					hm = new HashSet<>();
					for(int x=1;x<=20;x++) hm.add(x);
					break;
				case "empty":
					hm = new HashSet<>();
					break;
			}
		}
		System.out.print(sb);
    }

	public static boolean check(int num){
		if(num<0 || num>20) return false;
		return true ;
	}
}
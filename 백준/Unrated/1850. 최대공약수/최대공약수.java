import java.io.*;
import java.util.*;
import java.awt.Point;

public class Main{

	static long a ,b ;

	public static long stol(String str){
		return Long.parseLong(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		a = stol(st.nextToken());
		b = stol(st.nextToken());
		//<--

		long now = gcd(Math.max(a,b),Math.min(a,b));

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<now;i++) sb.append(1);
		System.out.println(sb);

	}

	public static long gcd(long a, long b){
		while(b>0){
			long temp = a%b;
			a = b;
			b = temp;
		}

		return a;

	}

}
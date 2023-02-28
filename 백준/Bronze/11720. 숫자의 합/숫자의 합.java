import java.io.*;
import java.util.*;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		char[] nums = br.readLine().toCharArray();
		for(int i=0;i<N;i++){
			ans += (nums[i]-'0');
		}
		System.out.print(ans);
	} 
}


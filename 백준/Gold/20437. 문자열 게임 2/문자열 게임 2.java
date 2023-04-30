import java.io.*;
import java.util.*;
public class Main {

	static String str;
	static int K, visited[];
	static StringBuilder sb ;
	
	public static int stoi(String str){
		return Integer.parseInt(str);
	}
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = stoi(br.readLine());
		sb = new StringBuilder();
		
		while(tc-->0){
			str = br.readLine();
			K = stoi(br.readLine()); // 같은 문자열 반복 횟수
			visited = new int[26];
			int ans3 = Integer.MAX_VALUE; // 어떤 문자를 정확히 K개를 포함하는 가장 짧은 연속 문자열의 길이
			int ans4 = Integer.MIN_VALUE; // 어떤 문자를 정확히 K개를 포함하고, 문자열의 첫 번째와 마지막 글자가 같은 가장 긴 연속 문자열의 길이

			// 전체 문자열 자리마다 ++
			for(int i=0;i<str.length();i++){
				visited[stoc(i)]++;
			}
			// System.out.println("now ! : " + str);

			for(int i=0;i<str.length();i++){
				int now = stoc(i);
				if(visited[now] >= K){ // 길이 구하러 가기
					int nowLen = checkLen(i,visited, visited[now]);
					// System.out.println("end checkLen : " + str.charAt(i) + " , " + nowLen);

					ans3 = Math.min(ans3, nowLen);
					if(nowLen != -1 && checkSame(i,(nowLen+i-1))) ans4 = Math.max(ans4, nowLen);
				}
				visited[now]--;
			}

			// System.out.println();

			if(ans3 == Integer.MAX_VALUE && ans4 == Integer.MIN_VALUE) sb.append(-1+"\n");
			else sb.append(ans3 + " " + ans4 + " \n");

			// if(ans3 == Integer.MAX_VALUE) ans3 = -1 ;
			// if(ans4 == Integer.MIN_VALUE) ans4 = -1 ;
			
		}
		System.out.print(sb);
    }

	// 첫 번째 문자열에서 3번에서 구한 문자열은 aqua, 4번에서 구한 문자열은 raquator이다.
	// 두 번째 문자열에서는 어떤 문자가 5개 포함된 문자열을 찾을 수 없으므로 -1을 출력한다.

	public static int checkLen(int idx, int[] visited, int origin){
		int[] newV = visited.clone();
		// System.out.println(Arrays.toString(newV));
		for(int i=idx;i<str.length();i++){
			newV[stoc(i)]--;
			// System.out.println(str.charAt(i) + " , " + newV[stoc(i)]);
			if(newV[stoc(idx)]== (origin-K) ) return (i-idx+1);
		}
		return -1;
	}

	public static boolean checkSame(int start, int end){
		// System.out.println(str.charAt(start) +" , " + str.charAt(end));
		if(str.charAt(start) == str.charAt(end)) return true ;
		else return false ;
	}

	public static int stoc(int idx){
		return str.charAt(idx)-'a';
	}
}
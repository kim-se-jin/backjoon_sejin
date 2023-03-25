import java.io.*;
import java.util.*;

class voca implements Comparable<voca>{
	String str;
	int count ;
	voca(String str, int count){
		this.str = str;
		this.count = count;
	} 

	@Override
	public int compareTo(voca o){
		// System.out.println(o.str + " , " + o.count);
		if(this.count == o.count){

			if(o.str.length() == this.str.length()){ // 우선순위 3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
				for(int i=0;i<o.str.length();i++){
					if(o.str.charAt(i) != this.str.charAt(i)){
						return this.str.charAt(i)-o.str.charAt(i);
					}
				}
				return o.str.charAt(0)-this.str.charAt(0);
			}else return o.str.length()-this.str.length(); // 우선순위 2. 해당 단어의 길이가 길수록 앞에 배치한다.
		}else return o.count - this.count; // 우선순위 1. 자주 나오는 단어일수록 앞에 배치한다.
	}
}

public class Main {

	static int N,M;
	static String str ;
	static ArrayList<voca> arr ;

	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList<>();
		HashMap<String, Integer> hm = new HashMap<>(); // 문자와 인덱스 저장
		int idx = 0 ;

		for(int i=0;i<N;i++){
			str = br.readLine();
			if(str.length() < M ) continue ; // M이상인 단어들만 외운다
			if(hm.containsKey(str)){
				// voca nowVoca = arr.get(hm.get(str));
				// arr.remove(arr.get(hm.get(str)));
				// arr.add(new voca(str, nowVoca.count+1));
				voca now = arr.get(hm.get(str));
				now.count ++ ;
			}else{
				hm.put(str,idx);
				arr.add(new voca(str, 1));
				idx++;
			}
		}

		Collections.sort(arr);
		StringBuilder sb = new StringBuilder();
		for(voca nVoca:arr) sb.append(nVoca.str+"\n");
		System.out.print(sb);

	}
}
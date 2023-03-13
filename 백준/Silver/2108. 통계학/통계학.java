import java.io.*;
import java.util.*;

public class Main{

	static int N;
	static int[] arr ;
	static HashMap<Integer, Integer> hm;
	static int maxVisit = 1 ; // 기본 최댓값 = 1 

	// 모든 
	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = stoi(br.readLine());
		arr = new int[N];
		int allSum = 0 ;
		hm = new HashMap<>();
		
		for(int i=0;i<N;i++){
			arr[i] = stoi(br.readLine());
			allSum += arr[i]; // 1번.평균을 위한 전체합

			if(hm.containsKey(arr[i])){ //3번.최빈값을 위한 다수출현 세기
				hm.put(arr[i], hm.get(arr[i])+1);
				maxVisit = Math.max(maxVisit, hm.get(arr[i]));
			}else hm.put(arr[i],1);
		}

		Arrays.sort(arr);
		System.out.println(Math.round((double)allSum/N)); // 1.산술평균
		System.out.println((arr[(N/2)])); // 2. 중앙값
		System.out.println(findVisitNum()); // 3. 최빈값
		System.out.println((arr[N-1]-arr[0])); // 4. 최댓값 최솟값 차이
    }

	public static int findVisitNum(){
		ArrayList<Integer> result = new ArrayList<>();

		for(int i=0;i<N;i++){
			if(hm.get(arr[i]) == maxVisit && !result.contains(arr[i])){
				result.add(arr[i]);
			}
		}		
		if(result.size()>1) return result.get(1);
		else return result.get(0);
	}
}
import java.io.*;
import java.util.*;

public class Main{

	static String inputs  ;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

    public static void main(String args[]) throws IOException{
		// 값 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		inputs = br.readLine();
		int result = 0;
		
		String[] arr = inputs.split("\\-");
		
		for(int i=0;i<arr.length;i++){
			int sum = 0 ;
			String[] plusArr = arr[i].split("\\+");
			for(int idx=0;idx<plusArr.length;idx++){
				sum += stoi(plusArr[idx]);
			}

			if(i==0) result += sum ;
			else result -= sum ;
		}
		System.out.println(result);

	}
}
import java.io.*;
import java.util.*;
import java.awt.Point ;

class Monster{
	long M_ATK, M_HP ;
	Monster(long M_ATK, long M_HP){
		this.M_ATK = M_ATK;
		this.M_HP = M_HP;
	}
}

public class Main {

	static int N; 
	static long H_MaxHP, H_CurHP, H_ATK;

	public static int stoi(String str){
		return Integer.parseInt(str);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = stoi(st.nextToken()); // 방의 개수
		H_ATK = stoi(st.nextToken());  // 용사의 초기 공격력

		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int Tnum = stoi(st.nextToken()); // 1 몬스터, 2 포션
			int Anum = stoi(st.nextToken()); // 몬스터 공격력, 용사 공격력 ++
			int Hnum = stoi(st.nextToken()); // 몬스터 생명력, 용사 생명력 ++
			if(Tnum == 1 ){ // 몬스터
                H_CurHP += Anum * ((Hnum / H_ATK) - (Hnum % H_ATK != 0 ? 0 : 1));
                H_MaxHP = Math.max(H_CurHP, H_MaxHP);
			}else{ // 포션
				H_ATK += Anum;
                H_CurHP = Math.max(H_CurHP - Hnum, 0);
			}
			// System.out.println(H_MaxHP);
		}
        H_MaxHP++;
		System.out.println(H_MaxHP);
	} 
}


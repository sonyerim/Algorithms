import java.io.*;
import java.util.*;

public class Solution
{
	static int S, maxTurn;
	static Map<Integer, Integer> memo;
	
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for (int tc = 1; tc <= T; tc++) {
			 S = Integer.parseInt(br.readLine()); // 시작수
			 maxTurn = 0;
			 memo = new HashMap<>();
			 
			 // 쪼갤 수 있는 모든 경우의 수: 2^(N-1)
			 int digits = Integer.toString(S).length(); // 자릿수
			 comb(0, digits - 1, S, 0, new boolean[digits - 1]);
			 
			 
			 sb.append("#").append(tc).append(" ").append(maxTurn).append("\n");
		 }
		 
		 System.out.println(sb);
	}
	
	static void comb(int idx, int n, int num, int turn, boolean[] select) {

		// 가지치기: 같은 숫자를 더 적은 turn으로 이미 방문했으면 종료
		if (memo.containsKey(num) && memo.get(num) > turn)
		    return;

		memo.put(num, turn);
		
		if (num < 10) { // 한 자리면 종료
			maxTurn = Math.max(maxTurn, turn);
			return;
		}
		
		if (idx == n) { 다 골랐으묜
			split(n, num, turn, select);
			return;
		}
		
		// 쪼개기
		select[idx] = true;
		comb(idx + 1, n, num, turn, select);

		// 안쪼개기
		select[idx] = false;
		comb(idx + 1, n, num, turn, select);
		
	}
	
	static void split(int n, int num, int turn, boolean[] select) {
	    boolean cutExists = false;
	    for (boolean b : select) {
	        if (b) {
	            cutExists = true;
	            break;
	        }
	    }
	    if (!cutExists) return;

	    String numString = String.valueOf(num);
	    String[] arr = new String[n + 1];
	    int a = 0;
	    int prev = 0;

	    // 쪼개기
	    for (int i = 0; i < select.length; i++) {
	        if (select[i]) {
	            arr[a++] = numString.substring(prev, i + 1);
	            prev = i + 1;
	        }
	    }
	    arr[a++] = numString.substring(prev);

	    // 곱하기
	    int result = 1;
	    for (int i = 0; i < a; i++) {
	        result *= Integer.parseInt(arr[i]);
	    }

	    // 다음 단계 재귀
	    int digits = Integer.toString(result).length();
	    comb(0, digits - 1, result, turn + 1, new boolean[digits - 1]);
	}
	
}

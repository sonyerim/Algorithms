package samsung01;

import java.io.*;
import java.util.*;

public class Solution
{
	
	static int N, tasteA, tasteB, diff, minDiff;
	static int[][] synergy;
	static boolean[] select;
	
	static void comb(int idx, int seleted) {
		if (idx == N) return;
		if (seleted == N/2) {
			// 맛 계산
			tasteA = 0;
			tasteB = 0;
			for (int i = 0; i < N; i++) {
				if (select[i]) {
					for (int j = 0; j < N; j++) {
						if (select[j]) tasteA += synergy[i][j];
					}
				}
			}
			for (int i = 0; i < N; i++) {
				if (!select[i]) {
					for (int j = 0; j < N; j++) {
						if (!select[j]) tasteB += synergy[i][j];
					}
				}
			}
			
			// 차이 계산
			diff = Math.abs(tasteA - tasteB);
			
			// 최소 찾기
			minDiff = Math.min(minDiff, diff);
			
			return;
		}
		
		// 선택
		if (!select[idx]) {
			select[idx] = true;
			comb(idx + 1, seleted + 1);
			select[idx] = false;
		}
		// 미선택
		comb(idx + 1, seleted);
		 
	}
	
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st;
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for (int tc = 1; tc <= T; tc++) {
			 
			 N = Integer.parseInt(br.readLine()); // 식재료 수
			 
			 synergy = new int[N][N];
			 for (int i = 0; i < N; i++) {
				 st = new StringTokenizer(br.readLine());
				 for (int j = 0; j < N; j++) {
					 synergy[i][j] = Integer.parseInt(st.nextToken());
				 }
			 }
			 
			 minDiff = Integer.MAX_VALUE;
			 select = new boolean[N];
			 comb(0, 0);
			 
			 sb.append("#").append(tc).append(" ").append(minDiff).append("\n");
		 }
		 
		 System.out.println(sb);
	}
}

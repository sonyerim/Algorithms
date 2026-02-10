import java.io.*;
import java.util.*;

class Solution {

	static int D, M, tM, Y, minCost;
	static int[] plans;

	static void dfs(int depth, int cost) {
		if (cost >= minCost) return; // 가지치기
		if (depth >= 12) { // 기저조건
			minCost = Math.min(minCost, cost);
			return;
		}

		if (plans[depth] == 0) {
	        dfs(depth + 1, cost);
	        return;
	    }

	    dfs(depth + 1, cost + D * plans[depth]);
	    dfs(depth + 1, cost + M);
	    dfs(depth + 3, cost + tM);
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			tM = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			plans = new int[12];
			minCost = Y; // 1년 이용권 요금
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 12; i++) {
				plans[i] = Integer.parseInt(st.nextToken());
			}

			dfs(0, 0);

			sb.append("#").append(tc).append(" ").append(minCost).append("\n");

		}

		System.out.println(sb);

	}

}

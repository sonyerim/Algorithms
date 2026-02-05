import java.io.*;
import java.util.*;

class Solution {

	static int N, L;
	static int[][] ingredients;
	static int MAX_TASTE;

	static void dfs(int idx, int taste, int kcal) {
		if (kcal > L) return;

		if (idx == N) {
			MAX_TASTE = Math.max(taste, MAX_TASTE);
			return;
		}

		// 선택 O
		dfs(idx + 1, taste + ingredients[idx][0], kcal + ingredients[idx][1]);

		// 선택 X
		dfs(idx + 1, taste, kcal);
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			L = Integer.parseInt(st.nextToken()); // 제한 칼로리

			ingredients = new int[N][2];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken()); // 점수
				ingredients[i][1] = Integer.parseInt(st.nextToken()); // 칼로리
			}

			// 칼로리 이내이면서 점수는 가장 큰 조합
			// 완전 탐색: 재료 20개 2^20 = 1000*1000
			MAX_TASTE = 0;
			dfs(0, 0, 0); // 재료 인덱스, 점수 총합, 칼로리 총합

			// 최대 햄버거 점수
			sb.append("#").append(test_case).append(" ").append(MAX_TASTE).append('\n');
		}

		System.out.print(sb);
	}
}

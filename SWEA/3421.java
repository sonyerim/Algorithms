import java.io.*;
import java.util.*;

class Solution {

	static int N, M;
	static int[][] ingredients;
	static int count;
	static boolean[] isSelected;

	static void dfs(int idx) {
		if (idx == N) {
			boolean possible = true;
			for (int i = 0; i < M; i++) {
				int a = ingredients[i][0];
				int b = ingredients[i][1];
				
				if (isSelected[a] && isSelected[b]) {
					possible = false;
					break;
				}
			}
			
			if (possible) count++;

			return;
		}

		isSelected[idx] = true;
		dfs(idx + 1);
		isSelected[idx] = false;
		dfs(idx + 1);

	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= TC; test_case++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 재료의 수
			M = Integer.parseInt(st.nextToken()); // 궁합 X 재료 쌍 수

			ingredients = new int[M][2];
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				ingredients[i][0] = Integer.parseInt(st.nextToken()) - 1; // a
				ingredients[i][1] = Integer.parseInt(st.nextToken()) - 1; // b
			}

			// 완탐 100만
			if (M == 0) {
				count = (1 << N);
			}
			else {
				count = 0;
				isSelected = new boolean[N];
				dfs(0);
			}

			sb.append("#").append(test_case).append(" ").append(count).append('\n');
		}

		System.out.print(sb);
	}
}

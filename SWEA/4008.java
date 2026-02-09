import java.io.*;
import java.util.*;

class Solution {

	static int N, max_value, min_value;
	static int[] operator, operand;

	static void dfs(int depth, int value) {
		if (depth == N - 1) {
			max_value = Math.max(max_value, value);
			min_value = Math.min(min_value, value);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] > 0) {
				operator[i]--;
				int prev = value;

				if (i == 0) {
					value += operand[depth + 1];
				} else if (i == 1) {
					value -= operand[depth + 1];
				} else if (i == 2) {
					value *= operand[depth + 1];
				} else if (i == 3) {
					value /= operand[depth + 1];
				}
				dfs(depth + 1, value);

				value = prev;
				operator[i]++;
			}
		}
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 숫자의 개수

			StringTokenizer st = new StringTokenizer(br.readLine());
			operator = new int[4]; // 연산자 카드의 개수 '+', '-', '*', '/'
			for (int i = 0; i < 4; i++) {
				operator[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			operand = new int[N]; // N 개의 숫자
			for (int i = 0; i < N; i++) {
				operand[i] = Integer.parseInt(st.nextToken());
			}

			// 완전 탐색 11! = 4000만
			max_value = Integer.MIN_VALUE;
			min_value = Integer.MAX_VALUE;
			dfs(0, operand[0]); // depth

			sb.append("#").append(tc).append(" ").append(max_value - min_value).append("\n");

		}

		System.out.println(sb);

	}

}

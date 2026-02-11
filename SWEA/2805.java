import java.io.*;
import java.util.*;

class Solution {

	static int N, mid, answer;
	static int[][] values;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine()); // 농장의 크기, 홀수
			
			values = new int[N][N]; // 농장 내 농작물의 가치, 0 ~ 5
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					values[i][j] = s.charAt(j) - '0';
				}
			}
			mid = N / 2;
			answer = 0;

			for (int v : values[mid]) {
				answer += v;
			}
			
			for (int i = 0; i < mid; i++) {
				for (int j = mid - i; j <= mid + i; j++) {
					answer += values[i][j];
				}
			}
			
			for (int i = mid + 1; i < N; i++) {
				for (int j = mid - (N - 1 - i); j <= mid + (N - 1 - i); j++) {
					answer += values[i][j];
				}
			}
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}

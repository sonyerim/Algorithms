import java.io.*;
import java.util.*;

class Solution {

	static int N, B, topHeight, answer;
	static int[] heights;

	static void getHeight(int idx, int height) {
		if (height >= topHeight) return;
		if (idx == N) {
			if (height >= B) topHeight = Math.min(topHeight, height);
			return;
		}
		
		getHeight(idx + 1, height + heights[idx]); // 선택
		getHeight(idx + 1, height); // 미선택
		
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 점원 개수
			B = Integer.parseInt(st.nextToken()); // 선반 높이
			
			heights = new int[N]; // 각 점원의 키
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
			}
			
			topHeight = Integer.MAX_VALUE; // 높이가 B 이상인 탑 중에서 높이가 가장 낮은 탑
			
			getHeight(0, 0);
			
			answer = topHeight - B; // 탑의 높이 - 선반 높이
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}

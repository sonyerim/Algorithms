import java.io.*;
import java.util.*;

class Solution {

	static int N, M, cost, count, maxCount;
	static int[][] city;
  
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 도시의 크기
			M = Integer.parseInt(st.nextToken()); // 하나의 집이 지불할 수 있는 비용

			city = new int[N][N]; // 집이 있는 위치는 1이고, 나머지는 0
			int home = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					city[i][j] = Integer.parseInt(st.nextToken());
					if (city[i][j] == 1) home++;
				}
			}
			
			maxCount = 0;
		
			for (int k = 1; k <= N * 2; k++) {
				cost = k * k + (k - 1) * (k - 1);
				if (cost > home * M) break; // 가지치기: 마름모 면적 > 집 개수 * m
				
				// 도시의 모든 영역이 중심점 후보
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						count = 0;
						search(i, j, k);
					}
				}
			}
			
			// 출력: 홈방범 서비스를 제공 받는 집들의 수
			sb.append("#").append(tc).append(" ").append(maxCount).append("\n");
			
		}

		System.out.println(sb);

	}
	
	static void search(int x, int y, int k) { // 중심점 좌표, 마름모 크기
		
		for (int nx = 0; nx < N; nx++) {
	        for (int ny = 0; ny < N; ny++) {
	            if (Math.abs(nx - x) + Math.abs(ny - y) < k) {
	                if (city[nx][ny] == 1) count++;
	            }
	        }
	    }
		
		if (cost <= count * M) maxCount = Math.max(maxCount, count);
		
	}

}

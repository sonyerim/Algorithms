import java.io.*;
import java.util.*;

class Solution {

	static int N, count, maxCnt, answer;
	static int[][] map;
	static boolean[] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void search(int start, int x, int y) { // 시작 방, 검색하려는 방의 좌표
		// 가지치기
		
		// 더 이상 이동할 수 없으면 종료
		if (maxCnt < count) {
			maxCnt = count;
			answer = start;
		} else if (maxCnt == count) {
			answer = Math.min(start, answer);
		}

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!isRange(nx, ny)) continue;

			if (map[nx][ny]== map[x][y] + 1) {
				count += 1;
				search(start, nx, ny);
			}
		}

	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken()); // 모두 서로 다른 수
				}
			}
			
			answer = 0;
			maxCnt = 0;
			// 완전탐색 N*N*N*N
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 1;
					search(map[i][j], i, j);
				}
			}

			// 출력: 처음에 출발해야 하는 방 번호,  최대 몇 개의 방을 이동할 수 있는지
			sb.append("#").append(tc).append(" ").append(answer).append(" ").append(maxCnt).append("\n");

		}

		System.out.println(sb);

	}

}

import java.io.*;
import java.util.*;

class Solution {

	static int N, K, maxHeight, minHeight, maxLen, ex, ey;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static ArrayList<int[]> start;

	static void dfs(int x, int y, int length, boolean isConst) {
		
		maxLen = Math.max(maxLen, length);
		
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if (!isRange(nx, ny)) continue;
			
			// 그냥 가기
			if (!visited[nx][ny] && map[nx][ny] < map[x][y]) {
				visited[nx][ny] = true;
				dfs(nx, ny, length + 1, isConst);
				visited[nx][ny] = false;
			} // 공사하고 가기
			else if (!visited[nx][ny] && !isConst) {
				for (int k = 1; k <= K; k++) {
					if (map[nx][ny] - k < map[x][y]) {
						map[nx][ny] -= k;
						visited[nx][ny] = true;
						
						dfs(nx, ny, length + 1, true);
						
						map[nx][ny] += k;
						visited[nx][ny] = false;
					}
				}
			}
		}
		
	}

	static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}
	

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 지도의 한 변의 길이
			K = Integer.parseInt(st.nextToken()); // 최대 공사 가능 깊이
			
			map = new int[N][N];
			start = new ArrayList<>();
			maxHeight = Integer.MIN_VALUE;
			minHeight = Integer.MAX_VALUE;
			maxLen = 0; // 만들 수 있는 가장 긴 등산로의 길이
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxHeight = Math.max(maxHeight, map[i][j]);
					minHeight = Math.min(minHeight, map[i][j]);
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == maxHeight) { // 시작 좌표들
						start.add(new int[] {i, j});
					} else if (map[i][j] == minHeight) { // 도착 좌표
						ex = i;
						ey = j;
					}
				}
			}
			
			for (int[] s : start) {
				visited = new boolean[N][N];
				visited[s[0]][s[1]] = true;
				dfs(s[0], s[1], 1, false);
				
			}

			sb.append("#").append(tc).append(" ").append(maxLen).append("\n");

		}

		System.out.println(sb);

	}

}

import java.io.*;
import java.util.*;

public class Solution {
	static int N, maxCnt;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static void bfs(int x, int y, int day) {
		visited[x][y] = true;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {

			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (isRange(nx, ny) && !visited[nx][ny] && map[nx][ny] > day) {
					q.offer(new int[] { nx, ny });
					visited[nx][ny] = true;
				}
			}
		}
	}

	private static boolean isRange(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			maxCnt = 0;

			for (int day = 0; day <= 100; day++) {

				visited = new boolean[N][N];
				int cnt = 0;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && map[i][j] > day) {
							bfs(i, j, day);
							cnt++;
						}
					}
				}

				maxCnt = Math.max(maxCnt, cnt);
			}

			sb.append("#").append(tc).append(" ").append(maxCnt).append("\n");
		}

		System.out.println(sb);
	}

}

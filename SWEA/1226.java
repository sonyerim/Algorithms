import java.io.*;
import java.util.*;

class Solution {

	static int size = 16;

	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	static int bfs(char[][] graph, int sx, int sy) {
		boolean[][] visited = new boolean[size][size];
		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { sx, sy });
		visited[sx][sy] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			if (graph[x][y] == '3') {
				return 1;
			}

			for (int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];

				if (nx < 0 || nx >= size || ny < 0 || ny >= size)
					continue;
				if (visited[nx][ny])
					continue;
				if (graph[nx][ny] == '1')
					continue;

				visited[nx][ny] = true;
				q.offer(new int[] { nx, ny });
			}

		}

		return 0;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int T = 0; T < 10; T++) {
			int test_case = Integer.parseInt(br.readLine());
			char[][] graph = new char[size][size];

			for (int i = 0; i < size; i++) {
				String line = br.readLine();
				for (int j = 0; j < size; j++) {
					graph[i][j] = line.charAt(j);
				}
			}

			int startX = -1;
			int startY = -1;

			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (graph[i][j] == '2') {
						startX = i;
						startY = j;
						break;
					}
				}
			}

			int result = bfs(graph, startX, startY);
			sb.append("#").append(test_case).append(" ").append(result).append('\n');
		}

		System.out.print(sb);

	}
}

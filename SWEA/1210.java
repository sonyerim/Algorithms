import java.io.*;
import java.util.*;

class Solution {

	static int SIZE = 100;
	static int[][] map = new int[SIZE][SIZE];
	static boolean[][] visited = new boolean[SIZE][SIZE];
	static int answer = 0;

	static void dfs(int x, int y) {
		if (x == 0) {
			answer = y;
			return;
		}

		visited[x][y] = true;

		// 왼쪽 끝까지
		if (y > 0 && map[x][y - 1] == 1 && !visited[x][y - 1]) {
			dfs(x, y - 1);
			return;
		}

		// 오른쪽 끝까지
		if (y < SIZE - 1 && map[x][y + 1] == 1 && !visited[x][y + 1]) {
			dfs(x, y + 1);
			return;
		}

		// 위로 이동
		if (x - 1 >= 0 && map[x - 1][y] == 1 && !visited[x - 1][y]) {
			dfs(x - 1, y);
			return;
		}

		return;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());

			for (int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < SIZE; i++) {
				int x = SIZE - 1;
				int y = i;
				if (map[x][y] == 2) {
					visited = new boolean[SIZE][SIZE];
					dfs(x, y);
					break;
				}
			}

			sb.append("#").append(tc).append(" ").append(answer).append('\n');
		}

		System.out.print(sb);
	}
}

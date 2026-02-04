import java.util.*;
import java.io.*;

public class Main {

	static int N;
	static int[][] temp;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };

	static void bfs(int x, int y) {
		temp[x][y] = 1;

		Queue<int[]> q = new ArrayDeque<>();

		q.offer(new int[] { x, y });

		while (!q.isEmpty()) {
			int[] cur = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = cur[0] + dx[d];
				int ny = cur[1] + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && temp[nx][ny] == 0) {
					q.offer(new int[] { nx, ny });
					temp[nx][ny] = 1;
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[][] arr = new int[N][N];
		int max_h = 0;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				max_h = Math.max(max_h, arr[i][j]);
			}
		}

		int answer = 0;
		for (int h = 0; h <= max_h; h++) {
			temp = new int[N][N];
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] <= h)
						temp[i][j] = 1;
					else
						temp[i][j] = 0;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (temp[i][j] == 0) {
						bfs(i, j);
						count++;
					}
				}
			}

			answer = Math.max(answer, count);
		}

		System.out.println(answer);

	}
}

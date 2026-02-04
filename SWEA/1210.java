import java.io.*;
import java.util.*;

class Solution {

	static int SIZE = 100;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = Integer.parseInt(br.readLine());

			int[][] map = new int[SIZE][SIZE];
			for (int i = 0; i < SIZE; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < SIZE; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int x = SIZE - 1, y = 0;

			for (int i = 0; i < SIZE; i++) {
				if (map[x][i] == 2) {
					y = i;
					break;
				}
			}

			while (x > 0) {

				if (y > 0 && map[x][y - 1] == 1) {
					while (y > 0 && map[x][y - 1] == 1)
						y--;
				} else if (y < SIZE - 1 && map[x][y + 1] == 1) {
					while (y < SIZE - 1 && map[x][y + 1] == 1)
						y++;
				}

				x--;

			}

			sb.append("#").append(tc).append(" ").append(y).append('\n');
		}

		System.out.print(sb);
	}
}

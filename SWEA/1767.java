import java.io.*;
import java.util.*;

class Solution {

	static int N, maxCore, minLength, cnt;
	static int[][] mexynos;
	static int[][] cores;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	// 바깥 빼고 하나씩 돌기
	// 선이면 그래프 2로 바꾸기

	static void dfs(int depth, int coreCnt, int length) {

		// 기저조건: 애들 다 돌면 -> 최소 길이 기록
		if (depth == cnt) {
			if (coreCnt > maxCore) {
				maxCore = coreCnt;
				minLength = length;
			} else if (coreCnt == maxCore) {
				minLength = Math.min(minLength, length);
			}
			return;
		}

		// for 4 한쪽 방향으로 쭉 가보는데 다 0이면(1이 없으면) 가능
		for (int i = 0; i < 4; i++) {
			int x = cores[depth][0] + dx[i];
			int y = cores[depth][1] + dy[i];

			// 쭉 가보다가 1 나오면 continue;
			int success = 0;
			List<int[]> list = new ArrayList<>();
			while (isRange(x, y)) {
				if (mexynos[x][y] == 1 || mexynos[x][y] == 2) {
					success++;
					break;
				} else {
					// 좌표 기록
					list.add(new int[] { x, y });
				}
				x += dx[i];
				y += dy[i];
			}

			// 성공이면 2로 바꾸고 길이 더하기
			if (success == 0) {
				for (int[] l : list) {
					mexynos[l[0]][l[1]] = 2;
				}
				length += list.size();

				dfs(depth + 1, coreCnt + 1, length);

				length -= list.size();
				for (int[] l : list) {
					mexynos[l[0]][l[1]] = 0;
				}
			}

		}

		dfs(depth + 1, coreCnt, length); // skip
	}

	static boolean isRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < N);
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());

			// 멕시노스의 초기 상태: 0은 빈 cell, 1은 core
			mexynos = new int[N][N];
			cnt = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mexynos[i][j] = Integer.parseInt(st.nextToken());
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1 && mexynos[i][j] == 1) {
						cnt++;
					}
				}
			}

			// 완전 탐색 11! = 4000만
			maxCore = 0;
			minLength = Integer.MAX_VALUE;
			cores = new int[cnt][2];
			int idx = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (i != 0 && i != N - 1 && j != 0 && j != N - 1 && mexynos[i][j] == 1) {
						cores[idx] = new int[] { i, j };
						idx++;
					}
				}
			}

			dfs(0, 0, 0);

			sb.append("#").append(tc).append(" ").append(minLength).append("\n");

		}

		System.out.println(sb);

	}

}

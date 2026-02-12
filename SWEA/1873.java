import java.io.*;
import java.util.*;

class Solution {

	static int H, W, N, sx, sy, dir, answer;
	static char[][] map;
	static boolean[] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String s = br.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j);
					// 전차 위치 찾기
					// ^ v < > 이면 . 으로 바꾸고 전차 위치 저장 방향도 저장 0123
					if (map[i][j] == '^') {
						map[i][j] = '.';
						sx = i;
						sy = j;
						dir = 0;
					} else if (map[i][j] == 'v') {
						map[i][j] = '.';
						sx = i;
						sy = j;
						dir = 1;
					} else if (map[i][j] == '<') {
						map[i][j] = '.';
						sx = i;
						sy = j;
						dir = 2;
					} else if (map[i][j] == '>') {
						map[i][j] = '.';
						sx = i;
						sy = j;
						dir = 3;
					}
				}
			}
			
			N = Integer.parseInt(br.readLine());
			String input = br.readLine(); // 사용자 입력
			
			for (int i = 0; i < N; i++) {
				char in = input.charAt(i);
				
				if (in == 'U') {
					dir = 0;
					turn();
				} else if (in == 'D') {
					dir = 1;
					turn();
				} else if (in == 'L') {
					dir = 2;
					turn();
				} else if (in == 'R') {
					dir = 3;
					turn();
				} else if (in == 'S') {
					shoot(sx, sy);
				}
				
			}
			
			// 마지막 전차 위치에 전차 그리기
			if (dir == 0) map[sx][sy] = '^';
			else if (dir == 1) map[sx][sy] = 'v';
			else if (dir == 2) map[sx][sy] = '<';
			else if (dir == 3) map[sx][sy] = '>';
			
			// 출력: 맵
			sb.append("#").append(tc).append(" ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}

		}

		System.out.println(sb);

	}
	
	static void turn() {
		int nx = sx + dx[dir];
		int ny = sy + dy[dir];
		if (isRange(nx, ny) && map[nx][ny] == '.') {
			sx = nx;
			sy = ny;
		}
	}
	
	static void shoot(int x, int y) {
		// 벽이나 범위 벗어날때까지 쭉 가기
		// 벽돌이면 평지로 바꾸기
		int nx = x;
		int ny = y;
		
		while (true) {
	        nx += dx[dir];
	        ny += dy[dir];

	        if (!isRange(nx, ny)) return;

	        if (map[nx][ny] == '*') {
	            map[nx][ny] = '.';
	            return;
	        }
	        if (map[nx][ny] == '#') return;
	    }
	}
	
	static boolean isRange(int x, int y) {
		return x >= 0 && x < H && y >= 0 && y < W;
	}

}

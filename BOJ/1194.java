import java.util.*;
import java.io.*;

public class Main {

	static int N, M, MIN_DIST;
	static char[][] miro;
	static boolean[][][] visited;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	
	static class Node {
		int x, y, mask, dist;
		
		Node(int x, int y, int mask, int dist) {
            this.x = x;
            this.y = y;
            this.mask = mask;
            this.dist = dist;
        }
	}
	
	static int bfs(int x, int y) {
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(x, y, 0, 0));
		visited[x][y][0] = true;
		
		while (!q.isEmpty()) {
			Node cur = q.poll();
			
			if (miro[cur.x][cur.y] == '1') return cur.dist;
			
			for (int d = 0; d < 4; d++) {
				int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nextMask = cur.mask;
                
                if (!isRange(nx, ny)) continue;
                char cell = miro[nx][ny];
                
                if (cell == '#') continue;
                
                if ('a' <= cell && cell <= 'f') {
                	nextMask = nextMask | (1 << (cell - 'a'));
                }
                if ('A' <= cell && cell <= 'F') {
                	if ((nextMask & (1 << (cell - 'A'))) == 0) continue;
                }
                
                if (visited[nx][ny][nextMask]) continue;
                
                visited[nx][ny][nextMask] = true;
                q.offer(new Node(nx, ny, nextMask, cur.dist + 1));

			}
		}
		
		return -1;
		
	}

	static boolean isRange(int x, int y) {
		return (x >= 0 && x < N && y >= 0 && y < M);
	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		miro = new char[N][M];
		int sx = 0, sy = 0;
		
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				miro[i][j] = line.charAt(j);
				if (miro[i][j] == '0') {
                    sx = i;
                    sy = j;
                }
			}
		}

		visited = new boolean[N][M][64];

		System.out.println(bfs(sx, sy));

	}
	
	// dfs 시간초과
	static void dfs(int x, int y, int keyMask, int dist) {
        if (dist >= MIN_DIST) return;

        if (miro[x][y] == '1') {
        	MIN_DIST = Math.min(MIN_DIST, dist);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            int nextMask = keyMask;

            if (!isRange(nx, ny)) continue;
            char cell = miro[nx][ny];

            if (cell == '#') continue;

            // 열쇠 획득
            if ('a' <= cell && cell <= 'f') {
            	nextMask = nextMask | (1 << (cell - 'a')); // 비트 켜기
            }

            // 문 통과 체크
            if ('A' <= cell && cell <= 'F') {
                int idx = cell - 'A';
                if ((keyMask & (1 << (cell - 'A'))) == 0) continue; // 열쇠 있는지 체크
            }

            if (visited[nx][ny][nextMask]) continue; // 열쇠 상태 방문 체크

            visited[nx][ny][nextMask] = true;
            dfs(nx, ny, nextMask, dist + 1);
            visited[nx][ny][nextMask] = false;
        }
    }

}

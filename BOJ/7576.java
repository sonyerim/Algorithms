import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] storage;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        storage = new int[N][M];
        Queue<int[]> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());

                // 처음부터 익은 토마토 전부 큐에 넣기
                if (storage[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {

            int[] cur = q.poll();

            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && storage[nx][ny] == 0) {
                	storage[nx][ny] = storage[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {

                if (storage[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }

                max = Math.max(max, storage[i][j]);
            }
        }

        System.out.println(max - 1);
    }
}

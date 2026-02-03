import java.util.*;
import java.io.*;

public class Main {

	static int N, M;
	static int[] arr;
	static boolean[] visited;

	static void dfs(int depth) {
		if (depth == M) {
			for (int a : arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(depth + 1);
				visited[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M];
		visited = new boolean[N + 1];

		dfs(0);

	}
}

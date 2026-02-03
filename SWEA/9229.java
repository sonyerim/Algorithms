import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case < TC + 1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Integer[] a = new Integer[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				a[i] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(a);

			int s = 0, e = N - 1;
			int answer = -1;

			while (s < e) {
				int sum = a[s] + a[e];

				if (sum > M) {
					e--;
				} else {
					answer = Math.max(answer, sum);
					s++;
				}

			}

			sb.append("#").append(test_case).append(" ").append(answer).append('\n');
		}

		System.out.print(sb);

	}
}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		int[] nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int[] psum = new int[N + 1];

		for (int i = 1; i < N + 1; i++) {
			psum[i] = psum[i - 1] + nums[i - 1];
		}

		for (int k = 0; k < M; k++) {
			st = new StringTokenizer(br.readLine());

			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int answer = psum[j] - psum[i - 1];

			sb.append(answer).append('\n');
		}

		System.out.print(sb);

	}

}

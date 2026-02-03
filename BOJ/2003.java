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
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int i = 0, j = 0;
		int sum = 0;
		int answer = 0;

		while (true) {
			if (sum == M) {
				answer++;
				sum -= A[i++];
			} else if (sum > M) {
				sum -= A[i++];
			} else if (sum < M) {
				if (j >= N)
					break;
				sum += A[j++];
			}
		}

		System.out.println(answer);

	}
}

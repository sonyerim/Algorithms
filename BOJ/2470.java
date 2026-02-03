import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		int min_sum = Integer.MAX_VALUE;
		int s = 0;
		int e = N - 1;
		int[] answer = { 0, 0 };

		while (s < e) {
			int sum = arr[s] + arr[e];

			if (Math.abs(sum) < min_sum) {
				min_sum = Math.abs(sum);
				answer[0] = arr[s];
				answer[1] = arr[e];
			}

			if (sum == 0) {
				break;
			} else if (sum > 0) {
				e--;
			} else if (sum < 0) {
				s++;
			}

		}

		System.out.print(answer[0] + " ");
		System.out.print(answer[1] + "\n");

	}
}

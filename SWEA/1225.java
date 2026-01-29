import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 0; t < 10; t++) {
			int test_case = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());

			Queue<Integer> q = new ArrayDeque<>();

			for (int i = 0; i < 8; i++) {
				q.offer(Integer.parseInt(st.nextToken()));
			}

			boolean end = false;

			while (true) {

				for (int i = 1; i < 6; i++) {

					if (q.peek() - i > 0) {
						q.offer(q.poll() - i);
						continue;
					} else {
						q.poll();
						q.offer(0);
						end = true;
						break;
					}

				}

				if (end) {
					break;
				}

			}

			System.out.print("#" + test_case);
			for (int i = 0; i < 8; i++) {
				System.out.print(" " + q.poll());
			}
			System.out.println();

		}
	}
}

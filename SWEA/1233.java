import java.io.*;
import java.util.*;

class Solution {
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int count = st.countTokens();

				st.nextToken();
				String value = st.nextToken();

				if (Character.isDigit(value.charAt(0))) {
					if (count != 2)
						answer = 0;
				} else {
					if (count != 4)
						answer = 0;
				}
			}

			sb.append("#").append(test_case).append(" ").append(answer).append('\n');
		}

		System.out.print(sb);
	}
}

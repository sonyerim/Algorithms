import java.io.*;
import java.util.*;

class Solution {

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int T = 1; T < 11; T++) {
			int N = Integer.parseInt(br.readLine());

			StringTokenizer st = new StringTokenizer(br.readLine());
			List<String> password = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				password.add(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				String cmd = st.nextToken();

				if (cmd.equals("I")) {
					int ix = Integer.parseInt(st.nextToken());
					int iy = Integer.parseInt(st.nextToken());

					String[] s = new String[iy];
					for (int k = 0; k < iy; k++) {
						s[k] = st.nextToken();
					}
					for (int j = ix; j < ix + iy; j++) {
						password.add(j, s[j - ix]);
					}

				}

				if (cmd.equals("D")) {
					int dx = Integer.parseInt(st.nextToken());
					int dy = Integer.parseInt(st.nextToken());

					for (int l = 0; l < dy; l++) {
						password.remove(dx);
					}

				}
			}

			sb.append("#").append(T);

			for (int i = 0; i < 10; i++) {
				sb.append(" ").append(password.get(i));
			}
			sb.append('\n');
		}

		System.out.print(sb);

	}
}

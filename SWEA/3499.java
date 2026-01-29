import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case < T + 1; test_case++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String[] cards = new String[N];
			
			for (int i = 0; i < N; i++) {
				cards[i] = st.nextToken();
			}
			
			int index;
			if (N % 2 == 0) {
				index = N / 2;
			} else {
				index = N / 2 + 1;
			}

			System.out.print("#" + test_case);
			for (int i = 0; i < index; i++) {
				if (index + i < N) {
					System.out.print(" " + cards[i] + " " + cards[index + i]);
				} else {
					System.out.print(" " + cards[i]);
				}
			}
			System.out.println();
		}
	}
}

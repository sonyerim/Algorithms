import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String memory = sc.next();
			int answer = 0;
			char c = memory.charAt(0);

			for (int i = 1; i < memory.length(); i++) {
				if (c == '0' && memory.charAt(i) == '0') {
					continue;
				} else if (c == '1' && memory.charAt(i) == '1') {
					continue;
				} else if (c == '0' && memory.charAt(i) == '1') {
					answer++;
					c = '1';
				} else if (c == '1' && memory.charAt(i) == '0') {
					answer++;
					c = '0';
				}
			}

			if (memory.charAt(0) == '1') {
				answer++;
			}

			System.out.println("#" + test_case + " " + answer);

		}
	}
}

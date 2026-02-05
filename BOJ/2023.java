import java.util.*;
import java.io.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		int[] startPrimes = { 2, 3, 5, 7 };
		for (int p : startPrimes) {
			dfs(p, 1);
		}

	}

	static void dfs(int num, int depth) {
		if (depth == N) {
			System.out.println(num);
			return;
		}

		int[] nextDigit = { 1, 3, 7, 9 };
		for (int d : nextDigit) {
			int nextNum = num * 10 + d;
			if (isPrime(nextNum)) {
				dfs(nextNum, depth + 1);
			}
		}

	}

	static boolean isPrime(int x) {
		if (x < 2)
			return false;
		for (int i = 2; i * i <= x; i++) {
			if (x % i == 0)
				return false;
		}
		return true;
	}
}

import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());

		String dna = br.readLine();

		st = new StringTokenizer(br.readLine());
		int[] need = new int[4];
		for (int i = 0; i < 4; i++) {
			need[i] = Integer.parseInt(st.nextToken());
		}

		int[] count = new int[4];

		for (int i = 0; i < P; i++) {
			if (dna.charAt(i) == 'A') {
				count[0]++;
			} else if (dna.charAt(i) == 'C') {
				count[1]++;
			} else if (dna.charAt(i) == 'G') {
				count[2]++;
			} else if (dna.charAt(i) == 'T') {
				count[3]++;
			}
		}

		int answer = 0;

		if (count[0] >= ca && count[1] >= cc && count[2] >= cg && count[3] >= ct) {
			answer++;
		}

		for (int i = 1; i < S - P + 1; i++) {

			if (dna.charAt(i - 1) == 'A') {
				count[0]--;
			} else if (dna.charAt(i - 1) == 'C') {
				count[1]--;
			} else if (dna.charAt(i - 1) == 'G') {
				count[2]--;
			} else if (dna.charAt(i - 1) == 'T') {
				count[3]--;
			}

			if (dna.charAt(i + P - 1) == 'A') {
				count[0]++;
			} else if (dna.charAt(i + P - 1) == 'C') {
				count[1]++;
			} else if (dna.charAt(i + P - 1) == 'G') {
				count[2]++;
			} else if (dna.charAt(i + P - 1) == 'T') {
				count[3]++;
			}

			if (count[0] >= ca && count[1] >= cc && count[2] >= cg && count[3] >= ct) {
				answer++;
			}

		}

		System.out.println(answer);

	}

}

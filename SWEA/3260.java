import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Solution {
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case < T + 1; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			BigInteger A = new BigInteger(st.nextToken());
			BigInteger B = new BigInteger(st.nextToken());
			
			BigInteger sum = A.add(B);
			
			System.out.println("#" + test_case + " " + sum);
			
		}
	}
}

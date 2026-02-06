import java.io.*;
import java.util.*;

class Solution {
	
	static int N, max_height, min_day;
	static int[] heights, diff;

	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine()); // 나무의 개수
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			heights = new int[N];
			max_height = 0;
			for (int i = 0; i < N; i++) {
				heights[i] = Integer.parseInt(st.nextToken());
				max_height = Math.max(max_height, heights[i]);
			}
			
			diff = new int[N];
			for (int i = 0; i < N; i++) {
				diff[i] = max_height - heights[i];
			}
			
			int odd = 0, even = 0;
			for (int h : diff) {
				odd += (h % 2);
				even += (h / 2);
			}
			
			while (even > odd + 1) {
				even--;
				odd += 2;
			}
			
			if (odd > even)
			    min_day = odd * 2 - 1;
			else
			    min_day = even * 2;

			sb.append("#").append(tc).append(" ").append(min_day).append("\n");
			
		}
		
		System.out.println(sb);

	}
	
}

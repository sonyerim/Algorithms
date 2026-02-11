import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		StringBuilder sb =  new StringBuilder();
		int T = sc.nextInt(); // 테스트 케이스의 수

		for (int t = 1; t <= T; t++) {
		    int N = sc.nextInt(); // 산의 개수
		    int[] h = new int[N]; // 각 지점 높이
		    for (int i = 0; i < N; i++) {
		        h[i] = sc.nextInt();
		    }
		    
		    // 우뚝 선 산이 될 수 있는 구간의 개수
		    int count = 0;
		    
		    for (int i = 1; i < N - 1; i++) {
		        if (h[i - 1] < h[i] && h[i + 1] < h[i]) {

		            int left = 0;
		            int temp = h[i];
		            for (int j = i - 1; j >= 0 && h[j] < temp; j--) {
		                temp = h[j];
		                left++;
		            }

		            int right = 0;
		            temp = h[i];
		            for (int j = i + 1; j < N && h[j] < temp; j++) {
		                temp = h[j];
		                right++;
		            }

		            count += left * right;
		        }
		    }
		    
		    sb.append('#').append(t).append(' ').append(count).append('\n');
		    
		}
		
		System.out.println(sb);
		sc.close();

	}

}

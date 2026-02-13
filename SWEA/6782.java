import java.io.*;

public class Solution
{
	static int N, count;
	
	public static void main(String args[]) throws Exception
	{
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 
		 int T = Integer.parseInt(br.readLine());
		 
		 for (int tc = 1; tc <= T; tc++) {
	            long N = Long.parseLong(br.readLine());
	            long count = 0;

	            while (N > 2) {
	                long root = (long)Math.sqrt(N);

	                // 제곱수가 아니면 다음 제곱수까지 증가
	                if (root * root != N) {
	                    long next = root + 1;
	                    long square = next * next;
	                    count += square - N;
	                    N = square;
	                }

	                // 제곱근 취하기
	                N = (long)Math.sqrt(N);
	                count++;
	            }

	            sb.append("#").append(tc).append(" ").append(count).append("\n");
	        }
		 
		 System.out.println(sb);
	}
	
}

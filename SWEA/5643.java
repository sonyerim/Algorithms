import java.io.*;
import java.util.*;

class Solution {

	static int N, M, downCnt, upCnt, answer;
	static int[][] map;
	static List<Integer>[] downList, upList;
	static boolean[] visited;
	
	static int down(int idx) {
		for (int next : downList[idx]) {
			if (!visited[next]) {
				downCnt++;
				visited[next] = true;
				down(next);
			}
		}
		
		return downCnt;
	}
	
	static int up(int idx) {	
		for (int next : upList[idx]) {
			if (!visited[next]) {
				upCnt++;
				visited[next] = true;
				up(next);
			}
		}
		
		return upCnt;
	}
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			
			N = Integer.parseInt(br.readLine()); // 학생들의 수
			M = Integer.parseInt(br.readLine()); // 키를 비교한 횟수
			answer = 0; // 자신이 키가 몇 번째인지 알 수 있는 학생 수
			
			downList = new ArrayList[N + 1];
			upList = new ArrayList[N + 1];
			
			for (int i = 1; i <= N; i++) {
				downList[i] = new ArrayList<>();
				upList[i] = new ArrayList<>();
			}
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				downList[a].add(b);
				upList[b].add(a);
			}
			
			// 한명씩 맵 돌아보기
			// 아래로 갈거면 계속 아래로 0 > 1
			// 위로 갈거면 계속 위로 1 > 0
			// 위 아래 총 사람 수 세기
			for (int sNum = 1; sNum <= N; sNum++) {
				downCnt = 0;
				visited = new boolean[N + 1];
				visited[sNum] = true;
				down(sNum);
				
				upCnt = 0;
				visited = new boolean[N + 1];
				visited[sNum] = true;
				up(sNum);
				
				if (downCnt + upCnt == N - 1) answer++;
			}
			
			
			sb.append("#").append(tc).append(" ").append(answer).append("\n");

		}

		System.out.println(sb);

	}

}

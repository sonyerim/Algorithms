// 1961. [문자열] 숫자 배열 회전

import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {

			int N;
            N = sc.nextInt();

            int[][] A = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            String[][] answer = new String[N][3];

            // 90도
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(A[N - 1 - j][i]);
                }
                answer[i][0] = sb.toString();
            }

            // 180도
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(A[N - i - 1][N - j - 1]);
                }
                answer[i][1] = sb.toString();
            }

            // 270도
            for (int i = 0; i < N; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < N; j++) {
                    sb.append(A[j][N - i - 1]);
                }
                answer[i][2] = sb.toString();
            }

            System.out.println("#" + test_case);
            for (int i = 0; i < N; i++) {
                System.out.println(
                        answer[i][0] + " " + answer[i][1] + " " + answer[i][2]
                );
            }
        }
    }
}

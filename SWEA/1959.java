// 1959. [완전탐색] 두 개의 숫자열

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

			int N, M;
            N = sc.nextInt();
            M = sc.nextInt();

            int[] A = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = sc.nextInt();
            }

            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                B[i] = sc.nextInt();
            }

            int answer = Integer.MIN_VALUE;

            if (N <= M) {
                for (int i = 0; i <= M - N; i++) {
                    int sum = 0;
                    for (int j = 0; j < N; j++) {
                        sum += A[j] * B[i + j];
                    }
                    answer = Math.max(answer, sum);
                }
            } else {
                for (int i = 0; i <= N - M; i++) {
                    int sum = 0;
                    for (int j = 0; j < M; j++) {
                        sum += B[j] * A[i + j];
                    }
                    answer = Math.max(answer, sum);
                }
            }

            System.out.println("#" + test_case + " " + answer);
        }
    }
}

# 1932번: 정수 삼각형
# 다이나믹 프로그래밍

N = int(input())

triangle = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * (i+1) for i in range(N)]
dp[0] = triangle[0]

for i in range(1, N):
    for j in range(0, i+1):
        if j == 0:
            dp[i][j] = dp[i-1][j] + triangle[i][j]
        elif j == i:
            dp[i][j] = dp[i-1][j-1] + triangle[i][j]
        else:
            dp[i][j] = max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
            
print(max(dp[N-1]))

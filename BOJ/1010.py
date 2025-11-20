# 1010번: 다리 놓기
# 다이나믹 프로그래밍

def combination(n, r):
    dp = [[0] * (r + 1) for _ in range(n + 1)]
    
    for i in range(n + 1):
        dp[i][0] = 1
        if i <= r:
            dp[i][i] = 1
            
    for i in range(1, n + 1):
        for j in range(1, min(i, r) + 1):
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j]
            
    return dp[n][r]
    
T = int(input())
for _ in range(T):
    N, M = map(int, input().split())
    print(combination(M, N))

# 9095번: 1, 2, 3 더하기
# 다이나믹 프로그래밍

T = int(input())

dp = [0] * 11
dp[1] = 1
dp[2] = 2
dp[3] = 4

for n in range(4, 11):
    dp[n] = dp[n-1] + dp[n-2] + dp[n-3]
    
for _ in range(T):
    n = int(input())
    print(dp[n])

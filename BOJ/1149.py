# 1149번: RGB거리
# 다이나믹 프로그래밍

N = int(input())

cost = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * 3 for _ in range(N)]

dp[0][0] = cost[0][0]
dp[0][1] = cost[0][1]
dp[0][2] = cost[0][2]

for i in range(1, N):
    dp[i][0] = min(dp[i-1][1], dp[i-1][2]) + cost[i][0]
    dp[i][1] = min(dp[i-1][2], dp[i-1][0]) + cost[i][1]
    dp[i][2] = min(dp[i-1][0], dp[i-1][1]) + cost[i][2]
    
print(min(dp[N-1]))

#---------------------------------------------------------

N = int(input())
r, g, b = map(int, input().split())

# dpR, dpG, dpB: 직전 집까지의 최소 비용
dpR, dpG, dpB = r, g, b

for _ in range(1, N):
    r, g, b = map(int, input().split())
    
    newR = min(dpG, dpB) + r
    newG = min(dpR, dpB) + g
    newB = min(dpR, dpG) + b
    
    dpR, dpG, dpB = newR, newG, newB

print(min(dpR, dpG, dpB))

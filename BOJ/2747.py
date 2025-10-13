# 2747번: 피보나치 수
# DP

def fibo(x):
    if dp[x] == -1:
        dp[x] = fibo(x - 1) + fibo(x - 2)
        
    return dp[x]
    
n = int(input())
dp = [-1] * 46
dp[0] = 0
dp[1] = 1
print(fibo(n))

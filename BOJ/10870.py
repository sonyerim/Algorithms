# 10870번: 피보나치 수 5

# DFS
def fibo(x):
    if x == 0:
        return 0
    if x == 1:
        return 1
    
    return fibo(x - 1) + fibo(x - 2)
    
n = int(input())
print(fibo(n))

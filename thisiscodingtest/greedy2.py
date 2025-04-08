# p92
# 큰 수의 법칙

n, m, k = map(int, input().split())
data = list(map(int, input().split()))
answer = 0

data.sort()

while m > 0:
    for i in range(k):
        answer += data[-1]
        m -= 1
    answer += data[-2]
    m -= 1
    
print(answer)

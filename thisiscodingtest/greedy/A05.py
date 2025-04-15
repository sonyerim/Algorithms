# 그리디
# 볼링공 고르기

n, m = map(int, input().split())
k = list(map(int, input().split()))

count = [0] * (m + 1)

for i in k:
    count[i] += 1

result = 0
 
for i in range(1, m + 1):
    result += count[i] * (n - count[i])
    n -= count[i]
    
print(result)

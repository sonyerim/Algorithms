# 10986번: 나머지 합
# 누적 합

N, M = map(int, input().split())
arr = list(map(int, input().split()))

prefix = [0] * (N + 1)
for i in range(1, N + 1):
    prefix[i] = prefix[i-1] + arr[i-1]
    
prefix_mod = [0] * M

for x in prefix:
    prefix_mod[x % M] += 1
    
count = 0
for x in prefix_mod:
    count += x * (x - 1) // 2

print(count)

# 1806번: 부분합
# 누적합
# 투 포인터

N, S = map(int, input().split())
arr = list(map(int, input().split()))

min_len = N
i = 0
j = 0
subtotal = 0

while True:
    if subtotal >= S:
        min_len = min(min_len, j - i)
        subtotal -= arr[i]
        i += 1
    elif j >= N:
        break
    elif subtotal < S:
        subtotal += arr[j]
        j += 1
    
if min_len == N:
    print(0)
else:
    print(min_len)

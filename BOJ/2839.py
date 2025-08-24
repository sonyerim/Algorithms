# 2839번: 설탕 배달
# 브루트 포스

n = int(input())
min = n

for i in range(n):
    for j in range(n):
        if i*3 + j*5 == n:
            sum = i+j
            if sum <= min:
                min = sum

if min == n:
    print(-1)
else:
    print(min)

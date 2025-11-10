# 2217번: 로프
# 그리디

N = int(input())

arr = [int(input()) for _ in range(N)]
arr.sort()

answer = 0
for i in range(N):
    answer = max(answer, (N-i) * arr[i])

print(answer)

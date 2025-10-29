# 2559번: 수열
# 투 포인터

# 전체 날짜 수, 연속 날짜 수 
N, K = map(int, input().split())
temp = list(map(int, input().split()))

# 처음 구간합
window = sum(temp[0:K])
answer = window

for i in range(N - K):
    window = window - temp[i] + temp[i+K]
    answer = max(answer, window)

print(answer)

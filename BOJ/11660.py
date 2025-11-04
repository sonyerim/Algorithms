# 11660번: 구간 합 구하기 5
# 누적 합

# 입력 횟수 많음 (M=100,000)
import sys
input = sys.stdin.readline

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

prefix = [[0] * (N + 1) for _ in range(N + 1)]
for i in range(1, N + 1):
    for j in range(1, N + 1):
        prefix[i][j] = arr[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

for _ in range(M):
    x1, y1, x2, y2 = map(int, input().split())
    sum_arr = prefix[x2][y2] - prefix[x1-1][y2] - prefix[x2][y1-1] + prefix[x1-1][y1-1]
    print(sum_arr)

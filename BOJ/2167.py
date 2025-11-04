# 2167번: 2차원 배열의 합
# 누적 합

N, M = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]

prefix = [[0] * (M + 1) for _ in range(N + 1)]

for i in range(1, N + 1):
    for j in range(1, M + 1):
        prefix[i][j] = arr[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1]

K = int(input()) # 합을 구할 부분의 개수

for _ in range(K):
    i, j, x, y = map(int, input().split())
    sum_arr = prefix[x][y] - prefix[i-1][y] - prefix[x][j-1] + prefix[i-1][j-1]
    print(sum_arr)

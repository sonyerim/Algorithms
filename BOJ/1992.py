# 1992번: 쿼드트리
# 분할 정복
# 재귀

N = int(input())
video = [list(input().strip()) for _ in range(N)]

def compress(x, y, size):
    first = video[x][y]

    for i in range(x, x + size):
        for j in range(y, y + size):
            if video[i][j] != first:
                half = size // 2
                return '(' + compress(x, y, half) + compress(x, y + half, half) + compress(x + half, y, half) + compress(x + half, y + half, half) + ')'

    return first

print(compress(0, 0, N))

# 7562번: 나이트의 이동
# DFS/BFS

from collections import deque

dx = [1, -1, 1, -1, 2, -2, 2, -2]
dy = [2, -2, -2, 2, 1, -1, -1, 1]

def bfs(l, sx, sy, tx, ty):
    if sx == tx and sy == ty:
        return 0

    visited = [[False] * l for _ in range(l)]
    queue = deque()
    queue.append((sx, sy))
    visited[sx][sy] = True
    move_count = 0

    while queue:
        for _ in range(len(queue)):
            x, y = queue.popleft()
            if x == tx and y == ty:
                return move_count

            for i in range(8):
                nx, ny = x + dx[i], y + dy[i]
                if 0 <= nx < l and 0 <= ny < l and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))
        move_count += 1

t = int(input())
for _ in range(t):
    l = int(input())
    x, y = map(int, input().split())
    n, m = map(int, input().split())
    print(bfs(l, x, y, n, m))





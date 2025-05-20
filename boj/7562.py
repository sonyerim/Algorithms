# 7562번: 나이트의 이동
# DFS/BFS

from collections import deque

dx = [1, -1, 1, -1, 2, -2, 2, -2]
dy = [2, -2, -2, 2, 1, -1, -1, 1]

def bfs(l, x, y, n, m):
    visited = [[False] * l for _ in range(l)]
    queue = deque()
    queue.append((x, y, 0))
    
    visited[x][y] = True
    
    while queue:
        x, y, dist = queue.popleft()
        
        if x == n and y == m:
            print(dist)
            return
        
        for i in range(8):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if nx >= 0 and nx < l and ny >= 0 and ny < l and not visited[nx][ny]:
                visited[nx][ny] = True
                queue.append((nx, ny, dist + 1))

t = int(input())

for _ in range(t):
    l = int(input())
    x, y = map(int, input().split())
    n, m = map(int, input().split())
    
    bfs(l, x, y, n, m)

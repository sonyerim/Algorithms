# 게임 맵 최단거리
# BFS

from collections import deque

def solution(maps):
    N, M = len(maps), len(maps[0])
    
    dist = [[0] * M for _ in range(N)]
    q = deque([(0, 0)])
    dist[0][0] = 1

    # 상 하 좌 우
    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]
    
    while q:
        x, y = q.popleft()
        if x == N - 1 and y == M - 1:
            return dist[x][y]
        
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < M:
                if maps[nx][ny] == 1 and dist[nx][ny] == 0:
                    dist[nx][ny] = dist[x][y] + 1
                    q.append((nx, ny))
                
    return -1

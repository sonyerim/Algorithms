# 7562번: 나이트의 이동
# DFS/BFS

from collections import deque

dx = [1, -1, 1, -1, 2, -2, 2, -2]
dy = [2, -2, -2, 2, 1, -1, -1, 1]

def bfs(l, start_x, start_y, target_x, target_y):
    visited = [[False] * l for _ in range(l)]
    queue = deque()
    queue.append((start_x, start_y))
    visited[start_x][start_y] = True

    move_count = 0  # 이동 거리 (= BFS 레벨)

    while queue:
        for _ in range(len(queue)):  # 현재 거리에서 큐에 있는 모든 좌표 처리
            x, y = queue.popleft()

            if x == target_x and y == target_y:
                print(move_count)
                return

            for i in range(8):
                nx = x + dx[i]
                ny = y + dy[i]

                if 0 <= nx < l and 0 <= ny < l and not visited[nx][ny]:
                    visited[nx][ny] = True
                    queue.append((nx, ny))

        move_count += 1  # 한 층 끝나면 거리 증가


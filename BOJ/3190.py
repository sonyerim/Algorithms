# 3190번: 뱀

N = int(input()) # 보드의 크기
graph = [[0] * (N + 1) for _ in range(N + 1)]

K = int(input()) # 사과의 개수
for _ in range(K):
    a, b = map(int, input().split())
    graph[a][b] = 1 # 사과
    
info = []
L = int(input()) # 뱀의 방향 변환 횟수
for _ in range(L):
    X, C = input().split()
    info.append((int(X), C))
    
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

def turn(direction, c):
    if c == 'D':
        direction = (direction + 1) % 4
    if c == 'L':
        direction = (direction - 1) % 4
        
    return direction

def simulate():
    x, y = 1, 1
    graph[x][y] = 2 # 뱀
    direction = 0
    time = 0
    index = 0
    q = [(x, y)]
      
    while True:
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        # 벽이 아니고 몸통이 아닌 경우
        if 1 <= nx and nx <= N and 1 <= ny and ny <= N and graph[nx][ny] != 2:
            if graph[nx][ny] == 1:  # 사과가 있다면
                graph[nx][ny] = 2
                q.append((nx, ny))
            else:                   # 사과가 없다면
                graph[nx][ny] = 2
                q.append((nx, ny))
                px, py = q.pop(0)
                graph[px][py] = 0
        # 벽이나 몸통에 부딪힌 경우
        else:
            time += 1
            break 
         
        x, y = nx, ny
        time += 1
        if index < L and time == info[index][0]:
            direction = turn(direction, info[index][1])
            index += 1
            
    return time

print(simulate())

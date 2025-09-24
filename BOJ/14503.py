# 14503번: 로봇 청소기

N, M = map(int, input().split())
r, c, d = map(int, input().split())

graph = [list(map(int, input().split())) for _ in range(N)]
    
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

count = 0
x, y, direction = r, c, d

def is_range(x, y):
    if 0 <= x and x < N and 0 <= y and y < M:
        return True
    return False

while True:
    # 1. 현재 칸이 아직 청소되지 않은 경우, 현재 칸을 청소
    if graph[x][y] == 0:
        graph[x][y] = 2
        count += 1
        
    # 3. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 있는 경우
    moved = False
    for _ in range(4):
        direction = (direction + 3) % 4
        nx = x + dx[direction]
        ny = y + dy[direction]
        
        if is_range(nx, ny) and graph[nx][ny] == 0:
            x, y = nx, ny
            moved = True
            break
        
    if moved:
        continue
           
    # 2. 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
    back_dir = (direction + 2) % 4
        # 후진
    bx = x + dx[back_dir]
    by = y + dy[back_dir]
    if not is_range(bx, by) or graph[bx][by] == 1:
        break
    else:
        x, y = bx, by

print(count)

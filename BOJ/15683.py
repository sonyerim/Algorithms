# 15683번: 감시
# DFS
# 백트래킹

N, M = map(int, input().split())

office = [list(map(int, input().split())) for _ in range(N)]

# 상 하 좌 우
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

cctv_dirs = [
    [],
    [[0], [1], [2], [3]],
    [[0, 1], [2, 3]],
    [[0, 3], [1, 3], [1, 2], [0, 2]],
    [[0, 1, 2], [0, 1, 3], [0, 2, 3], [1, 2, 3]],
    [[0, 1, 2, 3]]
]

def in_range(x, y):
    return 0 <= x < N and 0 <= y < M

cctvs = []
for i in range(N):
    for j in range(M):
        if 1 <= office[i][j] and office[i][j] <= 5:
            cctvs.append((i, j, office[i][j]))
     

watched = [[0] * M for _ in range(N)]

def paint(x, y, dirs):
    changed = []
    
    for d in dirs:
        nx, ny = x, y
        while True:
            nx += dx[d]
            ny += dy[d]
            if not in_range(nx, ny) or office[nx][ny] == 6:
                break
            if watched[nx][ny] == 0:
                watched[nx][ny] = 1
                changed.append((nx, ny))
    
    return changed

def count_blind():
    cnt = 0
    for i in range(N):
        for j in range(M):
            if office[i][j] == 0 and watched[i][j] == 0:
                cnt += 1
    return cnt

def undo(changed):
    for x, y in changed:
        watched[x][y] = 0
        
answer = N * M

def dfs(idx):
    global answer
    if idx == len(cctvs):
        answer = min(answer, count_blind())
        return
    
    x, y, t = cctvs[idx]
    for dirs in cctv_dirs[t]:
        changed = paint(x, y, dirs)
        dfs(idx + 1)
        undo(changed)     
     
dfs(0)
print(answer)   

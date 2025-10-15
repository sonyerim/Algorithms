# 1979. 어디에 단어가 들어갈 수 있을까

def in_range(x, y):
    return 0 <= x < N and 0 <= y < N

def dfs_x(x, y):
    global puzzle, cnt, visited_x
    visited_x[x][y] = True
    
    nx = x
    ny = y + 1
    
    if in_range(nx, ny) and puzzle[nx][ny] == 1 and not visited_x[nx][ny]:
        cnt += 1
        dfs_x(nx, ny)
    else:
        return
    
def dfs_y(x, y):
    global puzzle, cnt, visited_y
    visited_y[x][y] = True

    nx = x + 1
    ny = y
    
    if in_range(nx, ny) and puzzle[nx][ny] == 1 and not visited_y[nx][ny]:
        cnt += 1
        dfs_y(nx, ny)
    else:
        return
    
T = int(input())

for t in range(1, T + 1):
    # 퍼즐의 길이, 단어의 길이
    N, K = map(int, input().split())
    puzzle = [list(map(int, input().split())) for _ in range(N)]
    visited_x = [[False] * N for _ in range(N)]
    visited_y = [[False] * N for _ in range(N)]
    
    answer = 0
    
    for i in range(N):
        for j in range(N):
            if puzzle[i][j] == 1 and not visited_x[i][j]:
                cnt = 1
                dfs_x(i, j)
                if cnt == K:
                    answer += 1
    
    for i in range(N):
        for j in range(N):
            if puzzle[i][j] == 1 and not visited_y[i][j]:
                cnt = 1
                dfs_y(i, j)
                if cnt == K:
                    answer += 1
                
    print(f"#{t} {answer}")

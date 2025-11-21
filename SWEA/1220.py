# 1220. [S/W 문제해결 기본] 5일차 - Magnetic

for t in range(1, 11):
    N = int(input())
    
    magnetic = [list(map(int, input().split())) for _ in range(N)]

    answer = 0
    
    for column in range(N):
        flag = False
        for row in range(N):
            if magnetic[row][column] == 1:
                flag = True
            if flag and magnetic[row][column] == 2:
                answer += 1
                flag = False

    print(f"#{t} {answer}")

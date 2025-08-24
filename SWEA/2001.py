# 2001. 파리 퇴치

T = int(input())

for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    paris = [list(map(int, input().split())) for _ in range(N)]
    result = 0
    
    for a in range(0, N-M+1):
        for b in range(0, N-M+1):
            cnt = 0
            for i in range(a, a+M):
                for j in range(b, b+M):
                    cnt += paris[i][j]
            if result < cnt:
                result = cnt
    
    print(f"#{test_case} {result}")

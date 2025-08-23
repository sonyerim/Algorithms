# 1954. 달팽이 숫자

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    snail = [[0] * N for _ in range(N)]
    
    top, bottom = 0, N-1
    left, right = 0, N-1
    num = 1
    
    while top <= bottom and left <= right:
        for c in range(left, right + 1):
            snail[top][c] = num
            num += 1
        top += 1
        
        for r in range(top, bottom + 1):
            snail[r][right] = num
            num += 1
        right -= 1
        
        for c in range(right, left - 1, -1):
            snail[bottom][c] = num
            num += 1
        bottom -= 1
        
        for r in range(bottom, top - 1, -1):
            snail[r][left] = num
            num += 1
        left += 1
        
    # 출력
    print(f"#{test_case}")
    for row in snail:
        print(*row)

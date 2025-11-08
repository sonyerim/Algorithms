# 1215. [S/W 문제해결 기본] 3일차 - 회문1
# 60M

def is_palindrome_x(x, y, N):
    if 8-y-N >= 0:
        cnt = 0
        for i in range(y, y + N//2):
            if words[x][i] == words[x][N+(2*y-1)-i]:
                cnt += 1
        if cnt == N//2:
            return True
    return False

def is_palindrome_y(x, y, N):
    if 8-x-N >= 0:
        cnt = 0
        for i in range(x, x + N//2):
            if words[i][y] == words[N+(2*x-1)-i][y]:
                cnt += 1
        if cnt == N//2:
            return True
    return False

for test_case in range(1, 2):
    
    N = int(input())
    words = [input().strip() for _ in range(8)]
    
    count = 0
    
    for i in range(8):
        for j in range(8):
            if is_palindrome_x(i, j, N):
                count += 1
            if is_palindrome_y(i, j, N):
                count += 1
            
    print(f"#{test_case} {count}")

# 1216. [S/W 문제해결 기본] 3일차 - 회문2
# 30M

def is_palindrome_x(x, y, n):
    if y + n <= 100:
        sub = words[x][y:y+n]
        if sub == sub[::-1]:
            return True
    return False

def is_palindrome_y(x, y, n):
    if x + n <= 100:
        temp = []
        for i in range(x, x+n):
            temp.append(words[i][y])
        sub = ''.join(temp)
        if sub == sub[::-1]:
            return True
    return False
        
for _ in range(10):
    test_case = int(input())
    
    words = [input().strip() for _ in range(100)]
    
    max_length = 0
    
    for i in range(100):
        for j in range(100):
            for n in range(100-j, max_length, -1):
                if is_palindrome_x(i, j, n):
                    max_length = max(max_length, n)
                    break
            for n in range(100-i, max_length, -1):
                if is_palindrome_y(i, j, n):
                    max_length = max(max_length, n)
                    break
            
    print(f"#{test_case} {max_length}")

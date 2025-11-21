# 1974. 스도쿠 검증
# 30M

T = int(input())

for t in range(1, T + 1):
    
    sudoku = [list(map(int, input().split())) for _ in range(9)]
    
    count = 0
    
    for i in range(9):
        if sum(sudoku[i]) == 45:
            count += 1

    for i in range(9):
        sum_h = 0
        for j in range(9):
            sum_h += sudoku[j][i]
        if sum_h == 45:
            count += 1
    
    for x in range(0, 9, 3):
        for y in range(0, 9, 3):
            sum_sub = 0
            for i in range(x, x + 3):
                for j in range(y, y + 3):
                    sum_sub += sudoku[i][j]
            if sum_sub == 45:
                count += 1
    
    if count == 27:
        answer = 1
    else: 
        answer = 0
        
    print(f"#{t} {answer}")

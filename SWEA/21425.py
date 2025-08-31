# 21425. +=
# 그리디

T = int(input())

for test_case in range(1, T + 1):
    A, B, N = map(int, input().split())
    
    x = A
    y = B
    cnt = 0
    
    while True:
        if x < y:
            x += y
        else:
            y += x
            
        cnt +=1
        
        if x > N or y > N:
            break
        
    print(cnt)

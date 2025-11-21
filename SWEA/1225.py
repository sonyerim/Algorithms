# 1225. [S/W 문제해결 기본] 7일차 - 암호생성기

from collections import deque

for _ in range(10):
    T = int(input())
    arr = list(map(int, input().split()))

    q = deque(arr)
    
    i = 1
    while True:
        if i == 6:
            i = 1
            
        x = q.popleft()
        
        if x - i > 0:
            q.append(x - i)
        elif x - i <= 0:
            q.append(0)
            break
        
        i += 1
        
    print(f"#{T}", *q)

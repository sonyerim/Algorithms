# 1926. 간단한 369게임

N = int(input())
    
for num in range(1, N + 1):
    cnt = 0
    for n in str(num):
        if n == '3' or n == '6' or n == '9':
            cnt += 1
    if cnt == 0:
        print(num, end = " ")
    else:
        print("-" * cnt, end = " ")

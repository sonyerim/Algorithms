# 1209. [S/W 문제해결 기본] 2일차 - Sum

for _ in range(10):
    C = int(input())
    
    # 100X100 배열
    arr = [list(map(int, input().split())) for _ in range(100)]
    sum_arr = []
    
    # 각 행의 합
    for i in range(100):
        sum_arr.append(sum(arr[i]))
        
    # 각 열의 합
    for i in range(100):
        sum_num = 0
        for j in range(100):
            sum_num += arr[j][i]
        sum_arr.append(sum_num)
    
    # 대각선의 합 - 우하향
    sum_cross1 = 0
    for i in range(100):
        sum_cross1 += arr[i][i]
    sum_arr.append(sum_cross1)
    
    # 대각선의 합 - 우상향
    sum_cross2 = 0
    for i in range(100):
        sum_cross2 += arr[i][99-i]
    sum_arr.append(sum_cross2)
    
    # 출력
    print(f"#{C} {max(sum_arr)}")

# 2805. 농작물 수확하기

T = int(input())

for C in range(1, T + 1):
    N = int(input()) # 농장의 크기
    values = [list(map(int, input())) for _ in range(N)] # 농장 내 농작물의 가치

    profit = 0
    mid = N//2
    for i in range(mid):
        profit += sum(values[i][mid - i:mid + i + 1])
        profit += sum(values[N - 1 - i][mid - i:mid + i + 1])
    profit += sum(values[mid]) # 중앙 행
        
    # 출력
    print(f"#{C} {profit}")

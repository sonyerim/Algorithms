# 1859. 백만 장자 프로젝트
# 그리디
# 역순 탐색

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    prices = list(map(int, input().split()))
    
    profit = 0
    max_price = prices[N - 1]
    
    for i in range(N - 1, -1, -1):
        if prices[i] > max_price:
            max_price = prices[i]
        else:
            profit += (max_price - prices[i])
       
    print(f"#{test_case} {profit}")

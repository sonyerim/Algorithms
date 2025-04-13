# 그리디
# 만들 수 없는 금액

n = int(input())
coins = list(map(int, input().split()))
coins.sort()

target = 1

for coin in coins:
    if coin <= target:
        target += coin
    else:
        break
    
print(target) 

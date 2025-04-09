# 그리디
# 숫자 카드 게임

n, m = map(int, input().split())
cards = [list(map(int, input().split())) for _ in range(n)]

mins = []

for lows in cards:
    mins.append(min(lows))

print(max(mins))

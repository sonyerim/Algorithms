# 구현
# 치킨 배달
# 완전 탐색
# 조합

from itertools import combinations

n, m = map(int, input().split())

house = []
chicken = []

for r in range(n):
    data = list(map(int, input().split()))
    for c in range(n):
        if data[c] == 1:
            house.append((r, c))
        elif data[c] == 2:
            chicken.append((r, c))

combi = list(combinations(chicken, m))

result = []
for chicken in combi:
    ccs = 0
    for h in house:
        cs = 1e9
        for c in chicken:
            cs = min(cs, abs(h[0] - c[0]) + abs(h[1] - c[1]))
        ccs += cs
    result.append(ccs)
    
print(min(result))

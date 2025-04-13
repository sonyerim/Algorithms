# 그리디
# 모험가 길드

n = int(input())
level = list(map(int, input().split()))

level.sort()

group = 0
member = 0

for i in level:
    member += 1
    if member >= i:
        group += 1
        member = 0
        
print(group)

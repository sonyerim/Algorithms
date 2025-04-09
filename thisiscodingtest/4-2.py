# 구현
# 시각

n = int(input())

#sec 03, 13, 23, 43, 53, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39 -> 15 개
#min 15개
#hour 0~n 중에 3들어간거..

# h*(60*60) + (n+1-h)*(15*60) + (n+1-h)*(15*60) - (n+1-h)(15*15)
# 3600h + 1575(n+1-h)

h = 0

for i in range(1, n+1):
    if i == 3 or i == 13 or i == 23:
        h += 1

print(3600 * h + 1575 * (n + 1 - h))


# 완전 탐색
n = int(input())
count = 0

for h in range(n + 1):
    for m in range(60):
        for se in range(60):
            if '3' in str(h) + str(m) + str(s):
                count += 1

print(count)

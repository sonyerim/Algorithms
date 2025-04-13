# 그리디
# 곱하기 혹은 더하기

s = list(map(int, input()))
n = len(s)

result = s[0]

for i in range(1, n):
    if s[i] <= 1 or result <= 1:
        result += s[i]
    else:
        result *= s[i]
        
print(result)

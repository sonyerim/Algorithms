# 구현
# 문자열 재정렬

s = input()
result = []
val = 0

for x in s:
    if x.isalpha():
        result.append(x)
    else:
        val += int(x)

result.sort()

if val != 0:
    result.append(str(val))
    
print(''.join(result))

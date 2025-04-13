# 그리디
# 문자열 뒤집기

s = input()
count0 = 0  # 0 그룹 개수
count1 = 0  # 1 그룹 개수

# 첫 문자에 따라 첫 그룹 카운트
if s[0] == '0':
    count0 += 1
else:
    count1 += 1

# 두 번째 문자부터 순회하며 이전 문자와 다르면 그룹 변경
for i in range(1, len(s)):
    if s[i] != s[i - 1]:
        if s[i] == '0':
            count0 += 1
        else:
            count1 += 1

# 더 적은 쪽을 뒤집으면 최소 횟수
print(min(count0, count1))

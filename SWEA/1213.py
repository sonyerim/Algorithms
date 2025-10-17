# 1213. [S/W 문제해결 기본] 3일차 - String

for _ in range(1, 11):
    T = int(input())
    target = input() # 찾을 문자열
    sentence = input() # 검색할 문장
    
    answer = 0
    
    for i in range(len(sentence)):
        if sentence[i] == target[0]:
            cnt = 0
            for j in range(len(target)):
                if (i + j) < len(sentence) and sentence[i + j] == target[j]:
                    cnt += 1
            if cnt == len(target):
                answer += 1

    print(f"#{T} {answer}")

# 슬라이싱
for _ in range(1, 11):
    T = int(input())
    target = input().strip()     # 혹시 모를 공백 제거
    sentence = input().strip()
    
    answer = 0
    
    for i in range(len(sentence) - len(target) + 1):  # 필요한 부분까지만 탐색
        if sentence[i:i+len(target)] == target:
            answer += 1

    print(f"#{T} {answer}")

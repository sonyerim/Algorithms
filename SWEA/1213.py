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

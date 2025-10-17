# 1204. [S/W 문제해결 기본] 1일차 - 최빈수 구하기

T = int(input())

for test_case in range(1, T + 1):
    case_num = int(input())
    score = list(map(int, input().split()))
    
    count = [0] * 101 # 배열 초기화
    answer = 0
    
    for s in score:
        count[s] += 1
        
    max_count = max(count)
    for i in range(100, -1, -1): # 범위 설정
        if count[i] == max_count:
            answer = i
            break # 필수
      
    print(f"#{case_num} {answer}")

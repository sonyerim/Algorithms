# 5252. [파이썬 S/W 문제해결 최적화] 1일차 - 공통 단어 검색

T = int(input())

for C in range(1, T + 1):

    # A의 단어 개수 N과 B의 단어개수 M
    N, M = map(int, input().split())
    
    # 단어 리스트
    A = [input() for _ in range(N)]
    B = [input() for _ in range(M)]
    
    print("A = ", A)
    print("B = ", B)
             
    # 완전탐색
    count = 0
    for word_a in A:
        for word_b in B:
            if word_a == word_b:
                count += 1
    
    # 출력
    # 공통으로 들어있는 단어의 개수
    print(f"#{C} {count}")

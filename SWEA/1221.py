# 1221. [S/W 문제해결 기본] 5일차 - GNS

T = int(input())

for _ in range(T):
    t, N = input().split()
    N = int(N)
    
    words = input().split()
    
    GNS = ["ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"]
    words_to_num = {"ZRO": 0, "ONE": 1, "TWO": 2, "THR": 3, "FOR": 4, "FIV": 5, "SIX": 6, "SVN": 7, "EGT": 8, "NIN": 9}

    nums = [words_to_num[word] for word in words]
        
    nums.sort()
    
    answer = [GNS[num] for num in nums]
   
    print(t)
    print(*answer)

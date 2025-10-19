# 4828. [파이썬 S/W 문제해결 기본] 1일차 - min max

T = int(input())

for test_case in range(1, T + 1):
    N = int(input())
    nums_list = list(map(int, input().split()))
    
    answer = max(nums_list) - min(nums_list)
    
    print(f"#{test_case} {answer}")

# 1206. [S/W 문제해결 기본] 1일차 - View

for test_case in range(1, 11):
    N = int(input())
    heights = list(map(int, input().split()))
    
    answer = 0
    
    for i in range(2, N - 2):
        neighbor = [heights[i-2], heights[i-1], heights[i+1], heights[i+2]]
        M = max(neighbor)
        if heights[i] > M:
            answer += heights[i] - M
    
    print(f"#{test_case} {answer}")

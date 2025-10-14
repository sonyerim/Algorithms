# 1244. [S/W 문제해결 응용] 2일차 - 최대 상금
# 완전탐색
# DFS, 백트래킹

def dfs(num_list, cnt):
        global max_num, visited
        
        if cnt == exchange:
            max_num = max(max_num, int("".join(num_list)))
            return
        
        state = (int("".join(num_list)), cnt)
        if state in visited:
            return
        visited.add(state)
        
        # 모든 경우 교환
        for i in range(len(num_list)):
            for j in range(i + 1, len(num_list)):
                temp = num_list[i]
                num_list[i] = num_list[j]
                num_list[j] = temp
                dfs(num_list, cnt + 1)
                temp = num_list[i]
                num_list[i] = num_list[j]
                num_list[j] = temp
                
T = int(input())

for C in range(1, T + 1):
    # 숫자판 정보, 교환 횟수
    num, exchange = input().split()
    exchange = int(exchange)
    num_list = list(num)
    
    visited = set()
    max_num = 0
            
    dfs(num_list, 0)
    
    print(f"#{C} {max_num}")

# 5215
# 햄버거 다이어트
# DFS
# 완전탐색
     
def dfs(i, total_score, total_kcal):
        global max_score
        if total_kcal > L:
            return
        if i == N:
            max_score = max(max_score, total_score)
            return
        dfs(i + 1, total_score + ingredients[i][0], total_kcal + ingredients[i][1])
        dfs(i + 1, total_score, total_kcal)
        
T = int(input())

for test_case in range(1, T + 1):
    # 재료의 수, 제한 칼로리
    N, L = map(int, input().split())
    ingredients = [list(map(int, input().split())) for _ in range(N)] # 점수, 칼로리
    
    max_score = 0
    dfs(0, 0, 0)
    
    print(f"#{test_case} {max_score}")

# 타켓 넘버
# DFS/BFS

def solution(numbers, target):
    answer = 0 # 타겟 넘버를 만드는 방법의 수
    
    def dfs(idx, current_sum):
        nonlocal answer
        if idx == len(numbers):
            if current_sum == target:
                answer += 1
            return

        dfs(idx + 1, current_sum - numbers[idx])
        dfs(idx + 1, current_sum + numbers[idx])

        return
    
    dfs(0,0)
         
    return answer

# 네트워크

# DFS
def solution(n, computers):
    answer = 0
    
    visited = [False] * n
    
    def dfs(x):
        visited[x] = True
        
        for j in range(n):
            if computers[x][j] == 1 and not visited[j]:
                dfs(j)
        
    for i in range(n):
        if not visited[i]:
            dfs(i)
            answer += 1
            
    return answer

# BFS
from collections import deque

def solution(n, computers):
    answer = 0
    
    visited = [False] * n
    
    def bfs(node):
        q = deque()
        q.append(node)
        
        while q:
            x = q.popleft()
            visited[x] = True
        
            for j in range(n):
                if computers[x][j] == 1 and not visited[j]:
                    visited[j] = True
                    q.append(j)
        
    for i in range(n):
        if not visited[i]:
            bfs(i)
            answer += 1
            
    return answer

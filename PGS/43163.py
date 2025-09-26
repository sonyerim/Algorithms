# 단어 변환
# BFS

from collections import deque

def solution(begin, target, words):
    answer = 0
    
    if not target in words:
        return answer
        
    words.append(begin)
    
    n = len(words)
    n_word = len(words[0])
    graph = [[] for _ in range(n)]
    for i in range(n):
        for j in range(n):
            # 문자 하나만 다르면 그래프에 추가
            count = 0
            for k in range(n_word):
                if words[i][k] != words[j][k]:
                    count += 1
            if count == 1:
                graph[i].append(j)

    visited = [0] * n
    
    q = deque()
    q.append(n - 1)
    
    while q:
        x = q.popleft()
        
        if words[x] == target:
            answer = visited[x]
            break
        
        for y in graph[x]:
            if visited[y] == 0:
                visited[y] = visited[x] + 1
                q.append(y)
        
    return answer

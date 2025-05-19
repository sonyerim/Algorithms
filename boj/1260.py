# 1260: DFS와 BFS
# DFS/BFS

from collections import deque

n, m, v = map(int, input().split())

graph = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)
    
for g in graph:
    g.sort()
    
visited_dfs = [False] * (n + 1)
visited_bfs = [False] * (n + 1)
     
def dfs(v):
    visited_dfs[v] = True
    print(v, end=' ')
    for i in graph[v]:
        if not visited_dfs[i]:
            dfs(i)

def bfs(v):
    queue = deque([v])
    visited_bfs[v] = True
    
    while queue:
        now = queue.popleft()
        print(now, end=' ')
        for i in graph[now]:
            if not visited_bfs[i]:
                visited_bfs[i] = True
                queue.append(i)
    
dfs(v)
print()
bfs(v)

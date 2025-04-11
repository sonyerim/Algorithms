# DFS
# 스택
# 재귀 함수
# 2차원 리스트 (인접 리스트)

def dfs(graph, v, vistied):
    vistied[v] = True
    print(v, end=' ')
    
    for i in graph[v]:
        if not vistied[i]:
            dfs(graph, i, vistied)

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

dfs(graph, 1, visited)

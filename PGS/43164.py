# 여행 경로
# DFS

def solution(tickets):
    graph = {}
    for a, b in tickets:
        if a in graph:
            graph[a].append(b)
        else:
            graph[a] = [b]
            
    for a in graph:
        graph[a].sort(reverse=True) # 역순 정렬
    
    stack = ["ICN"]
    path = []
    
    while stack:
        cur = stack[-1]
        
        if cur in graph and len(graph[cur]) > 0:
            stack.append(graph[cur].pop())
        else:
            path.append(stack.pop())
            
    return path[::-1]

# 11279번: 최대 힙
# 우선순위 큐

import sys
import heapq

input = sys.stdin.readline

pq = []
heapq.heapify(pq)

N = int(input())
for _ in range(N):
    x = int(input())
    
    if x > 0:
        heapq.heappush(pq, -x)
    elif x == 0:
        if len(pq) == 0:
            print(0)
        else:
            print(-heapq.heappop(pq))


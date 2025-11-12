# 1927번: 최소 힙
# 우선순위 큐

import sys
input = sys.stdin.readline

import heapq

pq = []
heapq.heapify(pq)

N = int(input()) # 연산의 개수
for _ in range(N):
    x = int(input())
    
    if x > 0:
        heapq.heappush(pq, x)
    elif x == 0:
        if len(pq) == 0:
            print(0)
        else:
            print(heapq.heappop(pq))

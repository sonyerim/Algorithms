# 1715번: 카드 정렬하기
# 그리디
# 우선순위 큐

import heapq

N = int(input())
cards = [int(input()) for _ in range(N)]
heapq.heapify(cards)

result = 0

while len(cards) > 1:
    a = heapq.heappop(cards)
    b = heapq.heappop(cards)
    
    s = a + b
    result += s
    
    heapq.heappush(cards, s)
    
print(result)

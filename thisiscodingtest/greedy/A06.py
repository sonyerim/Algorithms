# 그리디
# 무지의 먹방 라이브
# 시뮬레이션 + 그리디 + 우선순위 큐

# food_times = [5, 1, 3]
# → 가장 적게 걸리는 음식은 1초짜리
# → 모든 음식에서 1초씩 깎으면 → [4, 0, 2]
# → 시간 3초 소모 (1초 x 음식 3개)

# → 다음엔 2초짜리를 기준으로 한 번 더 그룹 줄이기
# → 그리고 k를 줄여나가며 확인

import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1

    heap = []
    for i in range(len(food_times)):
        heapq.heappush(heap, (food_times[i], i + 1))

    total_time = 0
    previous = 0
    length = len(food_times)

    while True:
        current = heap[0][0]
        time_to_reduce = (current - previous) * length

        if total_time + time_to_reduce > k:
            break

        heapq.heappop(heap)
        total_time += time_to_reduce
        length -= 1
        previous = current

    result = sorted(heap, key=lambda x: x[1])
    answer_index = (k - total_time) % length
    return result[answer_index][1]

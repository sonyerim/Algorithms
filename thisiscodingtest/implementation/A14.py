# 구현
# 완전 탐색
# 순열
# 원형 -> 2배 일자 형태

from itertools import permutations

def solution(n, weak, dist):
    length = len(weak)
    # weak를 2배로 늘려서 원형을 일자로 펴기
    weak += [w + n for w in weak]
    
    answer = len(dist) + 1  # 초기값: dist 친구 다 써도 못하면 실패
    
    # weak의 각 지점에서 출발하는 경우 모두 시도
    for start in range(length):
        # 친구를 배치하는 모든 순서(permutations)
        for friends in permutations(dist):
            count = 1  # 투입한 친구 수
            position = weak[start] + friends[count - 1]  # 첫 번째 친구가 점검 가능한 끝 위치
            
            # start부터 시작해서 모든 약한 지점을 순회
            for idx in range(start, start + length):
                if weak[idx] > position:  # 현재 친구가 못 닿는 지점이면
                    count += 1  # 친구 하나 더 투입
                    if count > len(dist):  # 친구 다 써도 못 막으면 실패
                        break
                    position = weak[idx] + friends[count - 1]  # 새 친구가 닿을 수 있는 끝 위치 업데이트
                    
            answer = min(answer, count)  # 최소 투입 인원 업데이트

    if answer > len(dist):
        return -1
    return answer

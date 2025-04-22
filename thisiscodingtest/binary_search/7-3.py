# 이진 탐색 소스코드 구현 (반복문)
def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2  # 중간점 계산

        # 찾은 경우 중간점 인덱스 반환
        if array[mid] == target:
            return mid

        # 중간점의 값보다 찾는 값이 작은 경우 → 왼쪽 탐색
        elif array[mid] > target:
            end = mid - 1

        # 중간점의 값보다 찾는 값이 큰 경우 → 오른쪽 탐색
        else:
            start = mid + 1

    return None  # 찾는 값이 존재하지 않을 때

# 입력 받기
n, target = list(map(int, input().split()))  # 원소 개수 n, 찾을 값 target
array = list(map(int, input().split()))      # 전체 원소 입력 (오름차순 정렬된 상태)

# 이진 탐색 수행
result = binary_search(array, target, 0, n - 1)

# 결과 출력
if result is None:
    print("원소가 존재하지 않습니다.")
else:
    print(result + 1)  # 위치는 1부터 출력

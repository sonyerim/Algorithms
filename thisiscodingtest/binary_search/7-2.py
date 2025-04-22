# 이진 탐색 소스코드 구현 (재귀 함수)
def binary_search(array, target, start, end):
    if start > end:
        return None

    mid = (start + end) // 2  # 중간 인덱스

    # 찾은 경우 중간점 인덱스 반환
    if array[mid] == target:
        return mid
    # 중간점 값보다 찾는 값이 작으면 왼쪽 반을 재탐색
    elif array[mid] > target:
        return binary_search(array, target, start, mid - 1)
    # 중간점 값보다 찾는 값이 크면 오른쪽 반을 재탐색
    else:
        return binary_search(array, target, mid + 1, end)

# 입력: n (원소의 개수), target (찾을 값)
n, target = list(map(int, input().split()))
# 전체 원소 입력 받기
array = list(map(int, input().split()))

# 이진 탐색 수행
result = binary_search(array, target, 0, n - 1)

# 결과 출력
if result is None:
    print("원소가 존재하지 않습니다.")
else:
    print(result + 1)  # 위치는 1번부터 출력

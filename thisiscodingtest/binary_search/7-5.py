# 이진 탐색
# 부품 찾기

n = int(input())
data = list(map(int, input().split()))
data.sort()

m = int(input())
target = list(map(int, input().split()))

def binary_search(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        
        if array[mid] == target:
            return mid
        
        elif array[mid] < target:
            start = mid + 1
            
        else:
            end = mid - 1
        
    return None

for t in target:
    if binary_search(data, t, 0, len(data) - 1):
        print("yes", end=' ')
    else:
        print("no", end=' ')

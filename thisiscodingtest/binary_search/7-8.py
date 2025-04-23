# 이진 탐색
# 떡볶이 떡 만들기
# 파라메트릭 서치

n, m = map(int, input().split())
array = list(map(int, input().split()))

start = 0
end = max(array)

result = 0
while (start <= end):
    mid = (start + end) // 2
    
    total = 0
    for x in array:
        if x > mid:
            total += (x - mid)
        
    if total < m:
        end = mid - 1
    else:
        result = max(result, mid)
        start = mid + 1
    
print(result)

# 이진 탐색
# 부품 찾기 (계수 정렬)

n = int(input())
array = [0] * 1000001
data = list(map(int, input().split()))
for i in data:
    array[i] += 1

m = int(input())
target = list(map(int, input().split()))

for t in target:
    if array[t] > 0:
        print("yes", end=' ')
    else:
        print("no", end=' ')

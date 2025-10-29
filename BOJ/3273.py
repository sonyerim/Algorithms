# 3273번: 두 수의 합
# 투 포인터

N = int(input())
arr = list(map(int, input().split()))
X = int(input())

arr.sort()

i = 0
j = N - 1
cnt = 0

while True:
    if i >= j:
        break
    
    if arr[i] + arr[j] == X:
        cnt += 1
        i += 1
        j -= 1
    elif arr[i] + arr[j] > X:
        j -= 1
    else:
        i += 1
        
print(cnt)

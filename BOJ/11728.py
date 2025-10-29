# 11728번: 배열 합치기
# 투 포인터

N, M = map(int, input().split())
A = list(map(int, input().split()))
B = list(map(int, input().split()))

i, j = 0, 0
result = []

while i < N and j < M:
    if A[i] <= B[j]:
        result.append(A[i])
        i += 1
    else:
        result.append(B[j])
        j += 1
            
while i < N:
    result.append(A[i])
    i += 1
while j < M:
    result.append(B[j])
    j += 1
        
print(*result)

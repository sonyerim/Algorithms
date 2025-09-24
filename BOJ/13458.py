# 13458번: 시험 감독

N = int(input()) # 시험장의 개수
A = list(map(int, input().split())) # 각 시험장에 있는 응시자 수
B, C = map(int, input().split()) # 총감독관, 부감독관 감시 가능 응시자 수

# 총감독관 한 명씩 배치
answer = N

for i in range(N):
    A[i] -= B
    
# 부감독관 배치
for i in range(N):
    if A[i] > 0:
        answer += A[i] // C
        if A[i] % C != 0:
            answer += 1
    
print(answer)

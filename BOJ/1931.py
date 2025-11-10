# 1931번: 회의실 배정
# 그리디
# 정렬

N = int(input())
meetings = []
for _ in range(N):
    start, end = map(int, input().split())
    meetings.append((start, end))
    
meetings.sort(key=lambda x: (x[1], x[0]))

count = 1
end = meetings[0][1]

for i in range(1, N):
    if meetings[i][0] >= end:
        end = meetings[i][1]
        count += 1

print(count)

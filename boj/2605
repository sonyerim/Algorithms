# 2605번: 줄 세우기

n = int(input())
nums = list(map(int, input().split()))
answer = []

for i in range(n):
    if nums[i] == 0:
        answer.insert(0, i+1)
    else:
        answer.insert(nums[i], i+1)
    
for i in reversed(answer):
    print(i, end=' ')
    

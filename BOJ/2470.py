# 2470번: 두 용액
# 투 포인터

N = int(input())
values = list(map(int, input().split()))

values.sort()

i = 0
j = N - 1
min_sum = float('inf')
answer = (0, 0)

while i < j:
    temp_sum = values[i] + values[j]
    
    if abs(temp_sum) < min_sum:
        min_sum = abs(temp_sum)
        answer = (values[i], values[j])
        
    if temp_sum < 0:
        i += 1
    elif temp_sum > 0:
        j -= 1
    elif temp_sum == 0:
        break
        
print(answer[0], answer[1])

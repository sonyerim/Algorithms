# 1940번: 주몽
# 투 포인터

N = int(input()) # 재료의 개수
M = int(input()) # 갑옷을 만드는데 필요한 수
nums = list(map(int, input().split()))

nums.sort()

count = 0
i = 0
j = N -1

while i < j:
    
    if nums[i] + nums[j] == M:
        count += 1
        i += 1
    elif nums[i] + nums[j] < M:
        i += 1
    elif nums[i] + nums[j] > M:
        j -= 1

print(count)

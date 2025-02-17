# 2577번: 숫자의 개수

a = int(input())
b = int(input())
c = int(input())
abc = a * b * c
nums = []

while abc >= 1:
    nums.append(abc%10)
    abc //= 10

for i in range(10):
    count = 0
    for j in nums:
        if i == j:
            count += 1
    print(count)


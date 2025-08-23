# 2072. 홀수만 더하기

T = int(input())

for test_case in range(1, T + 1):
    nums = list(map(int, input().split()))
    sum_nums = 0
    for num in nums:
        if num % 2 != 0:
            sum_nums += num
    print(f"#{test_case} {sum_nums}")

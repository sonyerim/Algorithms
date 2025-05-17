# 5568번: 카드 놓기
# set(): add, update, remove

from itertools import permutations

n = int(input())
k = int(input())

data = []
for _ in range(n):
    num = input()
    data.append(num)

result = set()

p = list(permutations(data, k))

for nums in p:
    word = ''
    for n in nums:
        word += n
    result.add(word)

print(len(result))

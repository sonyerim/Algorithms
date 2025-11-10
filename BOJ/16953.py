# 16953번: A -> B

A, B = map(int, input().split())

count = 1
while B != A:
    if B < A:
        count = -1
        break
    if B % 2 == 0:
        B //= 2
        count += 1
    elif B % 10 == 1:
        B //= 10
        count += 1
    else:
        count = -1
        break

print(count)

# answer = []

# def dfs(A, count):
#     global answer, B
    
#     if A == B:
#         answer.append(count)
#         return
#     elif A > B:
#         return
#     else:
#         dfs(A * 2, count + 1)
#         dfs(int(str(A)+"1"), count + 1)

# count = 1
# dfs(A * 2, count)
# dfs(int(str(A)+"1"), count)

# if len(answer) == 0:
#     print(-1)
# else:
#     print(min(answer) + 1)

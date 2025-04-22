# 정렬
# 성적이 낮은 순서로 학생 출력하기

n = int(input())
array = []
for i in range(n):
    a, b = input().split()
    array.append((a, int(b)))
    
array = sorted(array, key=lambda x: x[1])

for x in array:
    print(x[0], end=' ')

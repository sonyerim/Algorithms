# 구현
# 럭키 스트레이트

n = list(map(int, input()))
left = 0
right = 0

for i in range(len(n) // 2):
    left += n[i]
    
for i in range(len(n) // 2, len(n)):
    right += n[i]
    
if left == right:
    print("LUCKY")
else:
    print("READY")

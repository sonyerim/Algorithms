# 1110번: 더하기 사이클

n = int(input()) # 26
new = n # 26
len = 0

while True:
    a = new // 10      # 2
    b = new % 10       # 6
    c = (a + b) % 10   # 8
    new = (b * 10) + c # 68
    
    len += 1
    if (new == n):
        break

print(len)


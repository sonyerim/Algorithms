# 1928. Base64 Decoder

table = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"

T = int(input())

for test_case in range(1, T + 1):
    s = input()
   
    first_step = ""
    for c in s:
        num = table.index(c) # 숫자
        # 숫자를 6비트 이진수로
        bits = ""
        for _ in range(6):
            bits = str(num % 2) + bits # 앞에 붙이기
            num //= 2
        first_step += bits
        
    last_step = ""
    for i in range(0, len(first_step), 8):
        byte = first_step[i: i+8]
        last_step += chr(int(byte, 2))
       
    print(f"#{test_case} {last_step}")

# 1240. [S/W 문제해결 응용] 1일차 - 단순 2진 암호코드

T = int(input())

code = {
    '0001101':0, '0011001':1, '0010011':2, '0111101':3,
    '0100011':4, '0110001':5, '0101111':6, '0111011':7,
    '0110111':8, '0001011':9
}

for C in range(1, T + 1):
    # 입력
    # 배열의 세로 크기 N, 배열의 가로크기 M
    N, M = map(int, input().split())
    arr = [input().strip() for _ in range(N)]
    
    target = ''
    for row in arr:
        if '1' in row:
            target = row
            break
    
    pw = ''
    for i in range(M-1, -1, -1):
        if target[i] == '1':
            pw = target[i-55:i+1]
            break
    
    num = []
    for i in range(0, 56, 7):
        num.append(code[pw[i:i+7]])
        
    # 검증
    check = 0
    # 홀수 자리의 합
    for i in range(0, 8, 2):
        check += num[i]
    check *= 3
    # 짝수 자리의 합
    for i in range(1, 8, 2):
        check += num[i]
        
    # 출력
    # 주어진 암호코드가 올바른 암호코드일 경우 -> 암호코드에 포함된 숫자의 합
    # 만약 잘못된 암호코드일 경우 -> 0
    if check % 10 == 0:
        print(f"#{C} {sum(num)}")
    else:
        print(f"#{C} 0")

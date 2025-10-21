# 4831. [파이썬 S/W 문제해결 기본] 1일차 - 전기버스

# 노선 수
T = int(input())

for C in range(1, T + 1):

    # 한번 충전으로 최대한 이동할 수 있는 정류장 수 K
    # 종점인 N번 정류장
    # 충전기가 설치된 정류장 수 M
    K, N, M = map(int, input().split())
    
    # 충전기가 설치된 정류장
    stops = list(map(int, input().split()))
    
    current = 0
    charged = 0
    while True:
        # 일단 최대 이동
        current += K
        
        # 종점에 도착하면 반복문 종료
        if current >= N:
            break
        
        # 그 위치에 충전기 있으면
        if current in stops:
            charged += 1
            continue
        # 충전기 없으면
        else:
            # 충전기 찾을 때까지 하나씩 뒤로 이동
            cnt = 0
            for i in range(K - 1):
                current -= 1
                if current in stops:
                    charged += 1
                    cnt += 1
                    break
                else:
                    continue
            # 원래보다 뒤로 가면 비정상 종료
            if cnt == 0:
                charged = 0
                break
             
    # 출력
    # 최소 충전횟수 또는 0
    print(f"#{C} {charged}")

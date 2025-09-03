# 1208. [S/W 문제해결 기본] 1일차 - Flatten

for test_case in range(1, 11):
    dump = int(input())
    boxes = list(map(int, input().split()))
    
    boxes.sort()
    
    while True:
        difference = boxes[-1] - boxes[0]
        
        if dump == 0 or difference == 0 or difference == 1:
            break
            
        boxes[-1] -= 1
        boxes[0] += 1
        
        dump -= 1
        
        boxes.sort()
    
    answer = boxes[-1] - boxes[0]
    
    print(f"#{test_case} {answer}")

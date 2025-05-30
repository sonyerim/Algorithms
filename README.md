# Algorithms
## 기타
- 입력 클 때
    - `import sys`
    - `input = sys.stdin.readline`
- list 복사
    - `answer = temp`: 참조 복사 / 동일한 객체 가리킴 / 서로 영향 줌
    - `answer = temp[:]`: 얕은 복사 / 새 리스트 생성 / 독립적으로 동작
    - `copy.deepcopy(temp)`: 깊은 복사 / 모든 계층 복사 / 완전히 독립적
- 해시
    - `set()`: add, update, remove
    - `from collections import defaultdict`
    - `d = defaultdict(default_factory)`
        - `int` → 0
        - `list` → `[]`
        - `str` → `''`
        - `.values()` / `.keys()`

## 그리디
## 구현
- "최소", "최대" -> 완전 탐색
- N이 작음 -> 완전 탐색
- 원형 -> 두배로 일자로 펼치기
- `from itertools import combinations, permutations`
## DFS/BFS
- DFS
- BFS: 최단 경로
    - `from collections import deque`
- `graph = [[] for _ in range(n + 1)]` -> `graph = [[], [], [], ... , []]`
- `graph = [[] * (n + 1)]` -> `graph = [[]]`
## 정렬
## 이진 탐색
## 다이나믹 프로그래밍
## 최단 경로
## 그래프 이론

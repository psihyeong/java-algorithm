from collections import deque


def solution(n, wires):
    global visited, graph
    answer = int(1e9)

    graph = [[] for _ in range(101)]

    for start, end in wires:
        graph[start].append(end)
        graph[end].append(start)

    for start, end in wires:
        graph[start].remove(end)
        graph[end].remove(start)

        visited = [0 for _ in range(101)]

        answer = min(answer, abs(bfs(start) - bfs(end)))
        graph[start].append(end)
        graph[end].append(start)

    return answer


def bfs(n):
    result = 1
    q = deque()
    q.append(n)
    visited[n] = 1

    while q:
        now = q.popleft()
        for neighbor in graph[now]:
            if not visited[neighbor]:
                q.append(neighbor)
                result += 1
                visited[neighbor] = 1
    return result
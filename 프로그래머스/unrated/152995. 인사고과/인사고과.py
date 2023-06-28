def solution(scores):
    answer = 1
    
    target = scores[0]
    targetA, targetB = target[0], target[1]
    target_score = sum(target)

    scores.sort(key=lambda x : (-x[0],x[1]))
    
    maxB = 0
    for scoreA, scoreB in scores:
        if targetA < scoreA and targetB < scoreB:       # 완호가 인센티브를 받지 못하는 경우
            return -1
        if maxB <= scoreB:                              # 두 점수가 모두 낮지 않은 경우
            if target_score < scoreA + scoreB:
                answer += 1
            maxB = scoreB
    
    return answer
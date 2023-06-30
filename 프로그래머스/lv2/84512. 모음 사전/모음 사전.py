import sys
sys.setrecursionlimit(10**6)

def solution(word):
    global words, alpha
    alpha = ["A","E","I","O","U"]
    words = []        
    dfs("")
    words.sort()
    for i in range(len(words)):
        if words[i] == word:
            return i
    
def dfs(word):
    if len(word) <= 5:
        words.append(word)
    
        for a in alpha:
            dfs(word+a)
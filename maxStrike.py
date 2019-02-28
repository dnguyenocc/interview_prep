def maxStreak(m, data):
    """
    >>> maxStreak(3, ['YYY', 'NNN', 'YYY', 'NNN', 'YYY'])
    1
    >>> maxStreak(2, ['YN', 'NN'])
    0
    >>> maxStreak(3, ['NYY'])
    0
    """
    max = 0
    start = 0
    end = 0
    for i in range(len(data)):
        if isAll(data[i]):
            if not isAll(data[start]):
                start = i
            if i - start + 1 > max:
                max = i - start + 1
        else:
            start = i
    return max

def isAll(s):
    for n in s:
        if n != 'Y':
            return False
    return True

def workSchedule(workHours, dayHours, pattern):
    """
    >>> workSchedule(56, 8, "???8???")
    ["8888888"]
    >>> workSchedule(24, 4, "08??840")
    ["0804840", "0813840", "0822840", "0831840", "0840840"]

    """
    result = []
    restHours = workHours
    num = 7
    for i in pattern:
        if i != '?':
            restHours -= int(i)
            num -= 1
    for i in schedule(restHours, dayHours, num):
        s = ""
        index = 0
        for j in pattern:
            if j == '?':
                s += i[index]
            else:
                s +=  j
        result.append(s)


    return result


def schedule(restHours, dayHours, num):
    result = []
    if num == 0:
        return result
    if num == 1:
        return [str(restHours)]
    for i in range(dayHours + 1):
        if restHours <= num * dayHours and restHours - i >= 0:
            a = schedule(restHours - i, dayHours, num - 1)
            for j in a:
                result.append(str(i) + j)
    return result


def vowels(strArr, queries):
    return 1

def isStartEnd(s):
    vow = {'a', 'e', 'u', 'o', 'i'}
    return s[0] in vow and s[-1] in vow

def reconArray(n, m, totalCost):
    """
    >>> reconArray([2, 3, 4], [3, 3, 3], [1, 2, 2])
    [3, 1, 6]
    """
    result = []
    for i in range(len(n)):
        result.append(recontructArray(n[i], m[i], totalCost[i]))
    return result


def recontructArray(n, m, totalCost):
    sum = 0
    for i in range(1, m + 1):
        sum += reArray(n - 1, i, m, totalCost)
    return sum


def reArray(n, currentMax, m, totalCost):
    if n == 0:
        if totalCost == 0:
            return 1
        return 0
    sum = 0
    for i in range(1, m + 1):
        if i > currentMax:
            sum += reArray(n - 1, i, m, totalCost - 1)
        else:
            sum += reArray(n - 1, currentMax, m, totalCost)
    return sum

import queue

def bfs(n, m, max_t, beauty, u, v, t):
    edges = dict()
    parents = dict()
    adj = dict()
    fringe = queue.Queue()
    closed = set()
    parents[0] = None
    state = dict()
    state[0] = (beauty[0], 0)
    for i in range(len(u)):
        edges[(u[i], v[i])] = t[i]
        edges[(v[i], u[i])] = t[i]
        adj[u[i]] = adj.get(u[i], []) + [v[i]]
        adj[v[i]] = adj.get(v[i], []) + [u[i]]

    fringe.put(0)
    while not fringe.empty():
        node = fringe.get()
        for i in adj[node]:
            if i not in closed:
                closed.add(i)
                parents[i] = node
                state[i] = (state[node][0] + beauty[i], state[node][1] + edges[i, node] * 2)
        closed.add(node)

    

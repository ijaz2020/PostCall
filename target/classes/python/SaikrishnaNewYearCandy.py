def Check(Arr):
    for i in range(len(Arr)):
        Sweet, Bitter = 0,0
        for j in range(len(Arr[i])):
            if Arr[i][j] == 'S':
                Sweet += 1
            if Arr[i][j] == 'B':
                Bitter += 1
        if not Sweet == SR[i] or not Bitter = BR[i]:
            return False

    for i in range(len(Arr[0])):
        Sweet, Bitter = 0,0
        for j in range(len(Arr)):
            if Arr[j][i] == 'S':
                Sweet += 1
            if Arr[j][i] == 'B':
                Bitter += 1
        if not Sweet == SC[i] or not Bitter = BC[i]:
            return False

    return True




def BackTrack(Arr, i, j):
    if i == M - 1 and j == N - 1:
        return Check(Arr)
    if not Arr[i][j] == 'X':
        if j < N - 1:
            j += 1
        else:
            i, j = i + 1, 0

        return BackTrack(Arr + [], i, j)

    if j == N - 1:
        if not Arr[i + 1][j] == 'X':
            Obj1, Obj2 = Arr + [[]], Arr + [[]]
            Obj1[i + 1][j], Obj2[i+ 1][j] = "S", "B"
            Obj1[i][j], Obj2[i][j] = "B", "S"
            return BackTrack(Obj1, i + 1, 0) or BackTrack(Obj2, i + 1, 0) or BackTrack(Arr + [], i + 1, 0)
        return BackTrack(Arr + [], i + 1, 0)
    if i == M - 1:
        if not Arr[i][j + 1] == 'X':
            Obj1, Obj2 = Arr + [[]], Arr + [[]]
            Obj1[i][j + 1], Obj2[i][j + 1] = "S", "B"
            Obj1[i][j], Obj2[i][j] = "B", "S"
            return BackTrack(Obj1, i, j + 1) or BackTrack(Obj2, i, j + 1) or BackTrack(Arr + [], i, j + 1)
        return BackTrack(Arr + [], i + 1, 0)


    if not Arr[i + 1][j] == 'X':
        Obj1, Obj2 = Arr + [[]], Arr + [[]]
        Obj1[i + 1][j], Obj2[i+ 1][j] = "S", "B"
        Obj1[i][j], Obj2[i][j] = "B", "S"
        Bool1 =  BackTrack(Obj1, i, j + 1) or BackTrack(Obj2, i, j + 1) or BackTrack(Arr + [], i, j + 1)
    Bool1 =  BackTrack(Arr + [], i, j + 1)

    if not Arr[i][j + 1] == 'X':
        Obj1, Obj2 = Arr + [[]], Arr + [[]]
        Obj1[i][j + 1], Obj2[i][j + 1] = "S", "B"
        Obj1[i][j], Obj2[i][j] = "B", "S"
        Bool2 =  BackTrack(Obj1, i, j + 1) or BackTrack(Obj2, i, j + 1) or BackTrack(Arr + [], i, j + 1)
    Bool2 =  BackTrack(Arr + [], i, j + 1)

    return Bool1 or Bool2
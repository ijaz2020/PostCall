def isDependentBFS(D, Root, Node):
    Unexplored = [Root]
    Explored = []
    while Unexplored:
        Root = Unexplored.pop(0)
        if Root in D:
            for i in range(len(D[Root])):
                Unexplored.append(D[Root][i])
                if D[Root][i] == Node:
                    return True
    return False

def AwesomeDiet(D):
    for i in D.keys():
        Current = D[i] + []
        N = len(Current)
        for j in range(N):
            Node= Current[j]
            for k in range(N):
                if isDependentBFS(D, Current[k], Node):
                    Found, m = False, 0
                    while not Found  and  m < len(D[i]):
                        if D[i][m] == Node:
                            D[i].pop(m)
                            Found = True
                        m  += 1
    return D


# Dic = {'A': ['B', 'C', 'D', 'E' , 'F', 'G' , 'H'],  'C': ['D'], 'D':['E', 'F'], 'G': ['C'], 'H': ['B', 'E'], 'B': ['E']}
Dic = {'A': ['B'],  'B': ['C'], 'C':['D'], 'D': ['E']}

print(AwesomeDiet(Dic))

def createGraph(dependencies): # Creates an adjacency list
    graph = {}
    for dependency in dependencies:
        for vertex in dependency:
            graph[vertex] = []
    for dependency in dependencies:
        graph[dependency[0]] = dependency[1:]
    return graph

def dfsLoop(v, visited, graph):
    visited[v] = True
    reachable = [v]
    if graph[v] == []:
        return reachable
    for neighbour in graph[v]:
        if visited[neighbour] == False:
            reachable += dfsLoop(neighbour, visited, graph)
    return reachable

def dfs(v, graph): # Performs a DFS
    visited = {}
    for vertex in graph:
        visited[vertex] = False
    return dfsLoop(v, visited, graph)[1:]

def removeTransitivity(graph): # For every vertex v pick u such that (v,u) is an edge. Perform DFS from u. If a vertex y is reachable from u, remove edge (v,y)
    reachable = {}
    for v in graph:
        reachable[v] = dfs(v,graph)
    for v in graph:
        for u in graph[v]:
            for x in reachable[u]:
                graph[v] = graph[v].replace(x,'')
    return graph

if __name__ == "__main__":
    n,d = input().split()
    dependencies = []
    for i in range(0,int(d)):
        l = input()
        dep = input().split()
        dependencies.append(''.join(dep))
    fixedList = removeTransitivity(createGraph(dependencies))
    for dep in fixedList:
        if fixedList[dep] != []:
            print('\n')
            print(dep, end = ' ')
            for v in fixedList[dep]:
                print(v, end = ' ')
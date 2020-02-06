n,d=map(int,input().split())
graph={}
indeg={}
vert=set()
past={}
for _ in range(d):
    ignore=int(input())
    arr=input().split()
    past[arr[0]]=set(arr[1:])
    for let in arr:
        if let not in graph:
            graph[let]=[]
        if let not in vert:
            vert.add(let)
        if let not in indeg:
            indeg[let]=0
    for let in arr[1:]:
        graph[arr[0]]+=[let]
        indeg[let]+=1

queue=[]
top_order=[]
for let in indeg:
    if indeg[let]==0:
        queue+=[let]
while queue!=[]:
    curr=queue.pop(0)
    top_order+=[curr]
    for nbr in graph[curr]:
        indeg[nbr]-=1
        if indeg[nbr]==0:
            queue+=[nbr]


dp={v:{v:float("inf") for v in vert} for v in vert}
for i in range(len(top_order)):
    curr=top_order[i]
    dp[curr][curr]=0
    for j in range(i,len(top_order)):
        u=top_order[j]
        for v in graph[u]:
            if dp[curr][v]>dp[curr][u]-1:
                dp[curr][v]=dp[curr][u]-1

ans=[]
for v in vert:
    for nbr in graph[v]:
        if dp[v][nbr]!=-1:
            ans+=[(v,nbr)]

for elem in ans:
    past[elem[0]].remove(elem[1])
for elem in past:
    print(elem,' '.join(list(past[elem])))

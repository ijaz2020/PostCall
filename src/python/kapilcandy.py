def solvedp(arr):
    dp=[0 for i in range(len(arr)+1)]
    dp[1]=arr[0]
    for i in range(2,len(arr)+1):
        curr=0
        num=0
        for j in range(1,i+1):
            if arr[i-j]==0:
                num-=1
            else:
                num+=1
            if num>0:
                curr=max(curr,dp[i-j]+j)
            else:
                curr=max(curr,dp[i-j])

        dp[i]=curr
    return dp[-1]

arr=list(map(int,list(input())))
print(solvedp(arr))

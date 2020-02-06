def minprice():
    n = int(input())
    fuel = list(map(int,input().strip().split()))[:n]
    price = list(map(int,input().strip().split()))[:n]

    totalprice = 0
    currcity = 0
    totalfuel = 0

    for i in range(0,n-1):
        totalfuel = totalfuel + 2*fuel[i]

    fuel.append(totalfuel/2)

    i=1
    while i<n:
        if currcity<n:
            totalprice = totalprice + fuel[currcity]*price[currcity]

            while (i<n) and (price[currcity] < price[i]):
                totalprice = totalprice + fuel[i]*price[currcity]
                i = i+1
            currcity = i
            i = currcity+1

    if currcity < n:
        totalprice = totalprice + fuel[currcity]*price[currcity]

    return totalprice

print(minprice())
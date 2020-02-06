def Minimum_cost(lines): ###to calculate price
    input_lines=lines.split("\n")[:-1]

    no_of_cities=int(input_lines[0])
    Petrol_Reqd=[int(i) for i in input_lines[1].split(' ')]
    Petrol_Price=[int(i) for i in input_lines[2].split(' ')]

    prices=[]
    Min_Price=Petrol_Price[0]
    for i in Petrol_Price:
        if i <= Min_Price:
            Min_Price=i
        prices.append(Min_Price)

    min_cost=0
    for i in range(0,len(prices)):
        if i!=len(prices)-1:
            min_cost=min_cost+prices[i]*Petrol_Reqd[i]
        else:
            min_cost=min_cost+sum(Petrol_Reqd)*prices[-1]
    return min_cost


def enter_input():
    lines=""
    for i in range(3):
        lines+=input()+"\n"
    return lines


Input=enter_input()
print((Input))



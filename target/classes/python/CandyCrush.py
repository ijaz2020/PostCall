def value(partition): #Calculate value of a single partition
    value = 0
    for piece in partition:
        if piece == '1':
            value += 1
        else:
            value -= 1
    if value > 0:
        return len(partition)
    else:
        return 0

def partition(chocolate): # Dynamic programming algorithm
    table = [0 for _ in chocolate]
    table[-1] = int(chocolate[-1])
    for i in range(len(chocolate)-1, -1, -1):
        m = value(chocolate[i:])
        for j in range(i, len(chocolate)):
            if m < (value(chocolate[i:j]) + table[j]):
                m = (value(chocolate[i:j]) + table[j])
        table[i] = m
    return table[0]

if __name__ == "__main__":
    chocolate = input()
    print(partition(chocolate))
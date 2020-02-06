DP = {}
def candycrush(nums):
    if nums == []:
        return 0

    if len(nums) == 1:
        return nums[0]

    if str(nums) in DP:
        return DP[str(nums)]

    Maximum, Count = 0, 0
    for i in range(len(nums)):
        Count += 2*nums[i] - 1
        if Count > 0:
            Maximum = max(candycrush(nums[i + 1:]) + i + 1, Maximum)
        else:
            Maximum = max(candycrush(nums[i + 1:]), Maximum)
    DP[str(nums)] = Maximum

    return Maximum

if __name__ == "__main__":
    chocolate = cars = [0,1]
    print(candycrush(chocolate))
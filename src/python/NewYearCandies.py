CANDY_SIZE = 2
EMPTY_CELL = 'X'


class CandyParts:
    SWEET = 'S'
    BITTER = 'B'


def get_row_sum(candy_box, row):
    count = lambda type: len(list(filter(lambda x: x == type, candy_box[row])))
    return count(CandyParts.SWEET), count(CandyParts.BITTER)


def get_column_sum(candy_box, column):
    count = lambda type: len(list(filter(lambda x: x == type, [row[column] for row in candy_box])))
    return count(CandyParts.SWEET), count(CandyParts.BITTER)


def get_valid_adjacent_pairs(x, y, row_count, column_count):
    adjacent_pairs = [(x, y-1), (x, y+1), (x-1, y), (x+1, y)]
    valid_adjacent_pairs = filter(lambda pair: (0 <= pair[0] < row_count and 0 <= pair[1] < column_count), adjacent_pairs)
    return list(valid_adjacent_pairs)


def does_row_match_constraint(row, sweet_count, bitter_count, constraints):
    return (constraints['left'][row] == -1 or constraints['left'][row] == sweet_count) and (
            constraints['right'][row] == -1 or constraints['right'][row] == bitter_count)


def does_column_match_constraint(column, sweet_count, bitter_count, constraints):
    return (constraints['top'][column] == -1 or constraints['top'][column] == sweet_count) and (
            constraints['bottom'][column] == -1 or constraints['bottom'][column] == bitter_count)


is_last_row_or_column = lambda idx, size: (size - idx) == 1


class CandyPlacement:
    def __init__(self, candy_format, candy_pair):
        self.candy_format = candy_format
        self.candy_pair = candy_pair

    def condition(self, candy_box, m, n, constraints):
        for i, j in self.candy_pair:
            if not (0 <= i < m and 0 <= j < n):
                return False

        for i, j in self.candy_pair:
            if candy_box[i][j] != EMPTY_CELL:
                return False

        for idx, pair in enumerate(self.candy_pair):
            valid_adjacent_pairs = get_valid_adjacent_pairs(pair[0], pair[1], m, n)
            for a, b in valid_adjacent_pairs:
                if candy_box[a][b] == self.candy_format[idx]:
                    return False

        for idx, pair in enumerate(self.candy_pair):
            if is_last_row_or_column(pair[0], m):
                self.place(candy_box)
                sweet_count, bitter_count = get_column_sum(candy_box, pair[1])
                if not does_column_match_constraint(pair[1], sweet_count, bitter_count, constraints):
                    self.remove(candy_box)
                    return False
                else:
                    self.remove(candy_box)
        return True

    def place(self, candy_box):
        for idx, pair in enumerate(self.candy_pair):
            candy_box[pair[0]][pair[1]] = self.candy_format[idx]
        i, j = self.candy_pair[0]
        return candy_box, i, j + 1

    def remove(self, candy_box):
        for idx, pair in enumerate(self.candy_pair):
            candy_box[pair[0]][pair[1]] = EMPTY_CELL
        return candy_box


class Empty:
    def __init__(self, candy_format, candy_pair):
        self.candy_format = candy_format
        self.candy_pair = candy_pair

    def condition(self, candy_box, m, n, constraints):
        i, j = self.candy_pair[0]
        if candy_box[i][j] != self.candy_format[0]:
            return False

        if is_last_row_or_column(i, m):
            sweet_count, bitter_count = get_column_sum(candy_box, j)
            if not does_column_match_constraint(j, sweet_count, bitter_count, constraints):
                return False
        return True

    def place(self, candy_box):
        i, j = self.candy_pair[0]
        return candy_box, i, j + 1

    def remove(self, candy_box):
        return candy_box


placements = lambda i, j: [
    CandyPlacement([CandyParts.SWEET, CandyParts.BITTER], [(i, j), (i, j+1)]),
    CandyPlacement([CandyParts.BITTER, CandyParts.SWEET], [(i, j), (i, j+1)]),
    CandyPlacement([CandyParts.SWEET, CandyParts.BITTER], [(i, j), (i + 1, j)]),
    CandyPlacement([CandyParts.BITTER, CandyParts.SWEET], [(i, j), (i + 1, j)]),
    Empty([EMPTY_CELL], [(i, j)])
]


def arrange_candies(candy_box, i, j, constraints, m, n):
    if i >= m:
        return True
    if j >= n:
        sweet_count, bitter_count = get_row_sum(candy_box, i)
        if not does_row_match_constraint(i, sweet_count, bitter_count, constraints):
            return False
        return arrange_candies(candy_box, i + 1, 0, constraints, m, n)

    if candy_box[i][j] != EMPTY_CELL:
        return arrange_candies(candy_box, i, j+1, constraints, m, n)

    valid_placements = filter(lambda x: x.condition(candy_box, m, n, constraints), placements(i, j))
    for placement in valid_placements:
        candy_box, new_i, new_j = placement.place(candy_box)
        if arrange_candies(candy_box, new_i, new_j, constraints, m, n):
            return True
        candy_box = placement.remove(candy_box)
    return False


def arrange(constraints, m, n):
    candy_box = [[EMPTY_CELL] * n for _ in range(m)]
    if arrange_candies(candy_box, 0, 0, constraints, m, n):
        print("")
        for i in candy_box:
            print(i)
        return candy_box
    return -1


# Assertions
def does_candy_box_match_constraints(candy_box, constraints, m, n):
    for idx, row in enumerate(candy_box):
        s, b = get_row_sum(candy_box, idx)
        assert constraints['left'][idx] == -1 or constraints['left'][idx] == s
        assert constraints['right'][idx] == -1 or constraints['right'][idx] == b

    for idx in range(n):
        s, b = get_column_sum(candy_box, idx)
        assert constraints['top'][idx] == -1 or constraints['top'][idx] == s
        assert constraints['bottom'][idx] == -1 or constraints['bottom'][idx] == b


# 1
m, n = 5, 6
constraints = {
    'top': [1, -1, -1, 2, 1, -1],
    'bottom': [2, -1, -1, 2, -1, 3],
    'left': [2, 3, -1, -1, -1],
    'right': [-1, -1, -1, 1, -1],
}
candy_box = arrange(constraints, m, n)
does_candy_box_match_constraints(candy_box, constraints, m, n)

# 2
m, n = 3, 3
constraints = {
    'top': [2, -1, 1],
    'bottom': [1, 1, 1],
    'left': [2, -1, 1],
    'right': [1, 2, 0],
}
candy_box = arrange(constraints, m, n)
does_candy_box_match_constraints(candy_box, constraints, m, n)

# 3
m, n = 2, 1
constraints = {
    'top': [1],
    'bottom': [1],
    'left': [1, 0],
    'right': [0, 1],
}
candy_box = arrange(constraints, m, n)
does_candy_box_match_constraints(candy_box, constraints, m, n)

# 4
m, n = 4, 4
constraints = {
    'top': [2, 1, 1, 2],
    'bottom': [2, 1, 1, 2],
    'left': [2, 1, 1, 2],
    'right': [2, 1, 1, 2],
}
candy_box = arrange(constraints, m, n)
does_candy_box_match_constraints(candy_box, constraints, m, n)

# 5
m, n = 4, 4
constraints = {
    'top': [0, 1, 2, 1],
    'bottom': [0, 1, 2, 1],
    'left': [0, 1, 2, 1],
    'right': [0, 1, 2, 1],
}
assert arrange(constraints, m, n) == -1

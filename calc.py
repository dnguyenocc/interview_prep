def calc(expr):
    for op in ['+', '-', '*', '/']:
        if op in expr:
            left, right = expr.rsplit(op, 1)
            if op == '+': 
                return calc(left) + calc(right)
            if op == '-':
                return calc(left) - calc(right)
            if op == '*':
                return calc(left) * calc(right)
            if op == '/':
                return calc(left) / calc(right)

    return float(expr.strip())

def test_calculate():
    assert calc("1 + 1") == 2
    assert calc("5 - 1 - 1") == 3
    assert calc("84 / 1 / 2") == 42
    assert calc("5/2 - 2*3") == -3.5
    assert calc("5 + 5 / 5") == 6
    assert calc("5 - 5 * 5 + 5") == -15
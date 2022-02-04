import math

def divisor_sum(n):
    if n == 2 or n == 3:
        return 1
    div = set()
    lim = int(math.sqrt(n))
    for i in range(2, lim + 1):
        if n % i == 0:
            div.add(i)
            div.add(n / i)
    return sum(div) + 1

if __name__=='__main__':
    ami_num = set()
    for i in range(2, 10000):
        d_sum1 = divisor_sum(i)
        d_sum2 = divisor_sum(d_sum1)
        if int(d_sum2) == i:
            if i != int(d_sum1):
                ami_num.add(i)
                ami_num.add(int(d_sum1))
    print(ami_num, sum(ami_num))


# 1 -> 0
# 2 -> 1
# 3 -> 1exit
def fact(num):
    if num == 0: 
        return 1
    
    return fact(num - 1) * num

perm = ""
digits = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
rank = 1000000 - 1

def find_digit_and_remain(rank):
    for i in range(len(digits) - 1, 0, -1):
        factorial = fact(i)
        if factorial <= rank:
            remain = rank % factorial
            digit = (rank // factorial)
            return digit, remain


while rank > 0:
    num, rank = find_digit_and_remain(rank)
    perm += str(digits[num])
    print(num, rank, end = "")
    digits.remove(digits[num])
    digits.sort()
    print(digits)

print(perm)

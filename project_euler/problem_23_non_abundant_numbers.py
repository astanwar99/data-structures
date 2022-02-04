from functools import total_ordering
import math

hm = dict()

def check_if_abundant(num):
    div_sum = 1
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            if i == num/i:
                div_sum += i
            else:
                div_sum += i + num / i

    if div_sum > num:
        return True
    return False

def check_sum_of_2(arr, x):
    f, l = 0, len(arr) - 1

    while f <= l:
        if arr[f] + arr[l] == x:
            return  True
        elif arr[f] + arr[l] < x:
            f += 1
        else:
            l -= 1

    return False

def check_if_sum_of_2_abundant(num):
    abundant = []
    for k,v in hm.items():  
        if v[0]:
            abundant.append(k)
    
    return check_sum_of_2(abundant, num)
        

for i in range(3, 28124):
    hm[1] = [False, False]
    hm[2] = [False, False]
    
    abundant = check_if_abundant(i)
    sum_of_2 = check_if_sum_of_2_abundant(i)
    hm[i] = [abundant, sum_of_2]

total_sum = 0
for k,v in hm.items(): 
    if not v[1]:
        total_sum += k
print(total_sum)
def pri0_9wol(num):
    if(num==10):
        return 0
    print(num)
    pri0_9wol(num+1)
print(pri0_9wol(0))
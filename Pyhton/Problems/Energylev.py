def energy(N):
    final=''
    while N>0:
        x=1<<(N.bit_length()-1)
        final+=str(x)
        N-=x
    return int(final)

def energym(N):
    final=''
    while N>0:
        i=0
        while pow(2,i)<=N:
            i+=1
        x=pow(2,i-1)
        final+=str(x)
        N-=x
    return int(final)

print(energy(18))
print(energym(18))

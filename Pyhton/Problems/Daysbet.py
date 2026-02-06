lstmon=[0,31,28,31,30,31,30,30,31,30,31,30,31]
def isleap(year):
    if(year%4==0 and year%100!=0 and year%400==0):
        return True
    return False
def retdays(day,mon,year):
    days=0
    for i in range(1,year):
        days+=366 if isleap(i) else 365
    for i in range(1,mon):
        days+=lstmon[i]
        if(isleap(year)):
            days+=1
    days+=day
    return days
stdt=retdays(1,9,2026)
enddt=retdays(19,9,2026)
print(enddt-stdt)

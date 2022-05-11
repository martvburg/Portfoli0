def binear(bineareInput):
    print("bineare lijn is : "+ bineareInput)
    print("length x = ",len(str(bineareInput))-1)
    length = len(str(bineareInput))
    omgedraaid = bineareInput[length::-1]
    c = omgedraaid.count("1")-1
    print("aantal eenen =",c)
    binear = omgedraaid
    waarde = 0
    locatieEenen = []
    for omgedraaid in range(0,length):
        print("x =",omgedraaid,"macht =",2**omgedraaid)
        if(binear[omgedraaid] == "1"):
            locatieEenen.append(omgedraaid)
            waarde += 2**omgedraaid
            print("Locatie eenen = ",locatieEenen,"decimaal =",waarde)
binear("101011")


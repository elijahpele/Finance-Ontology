f = open("combined_data.csv", "r")
l = '{'
i = 0
for line in f:
    if i >= 1:
        v = line.split(',')
        l += ('"' + v[4][:-1] + '"' + ', ')
    i += 1
l = l[:-2] + '};'
print(l)

    


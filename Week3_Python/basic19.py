from __future__ import division

# 1
def print1to255():
    for i in range(1,256):
        print i
# 2
def printOdds1to255():
    for i in range(1,256,2):
        print i
# 3
def printIntsAndsSums255():
    mysum = 0
    for i in range(1,256):
        mysum += i
        print i, mysum
# 4
def iterateAndPrintList(arr):
    for i in range(len(arr)):
        print arr[i]
    # for i in arr:
    #     print i

# 5
def printMax(arr):
    mymax = arr[0]
    for i in arr:
        if i > mymax:
            mymax = i
    print mymax

# 6
def printAverage(arr):
    mysum = 0
    for i in arr:
        mysum += i
    print(mysum / len(arr))

# 7
def arrayOdds1to255():
    newarr = []
    for i in range(1, 256, 2):
        newarr.append(i)
    print newarr

    # print range(1, 256, 2)

# 8
def squareValues(arr):
    for i in range(len(arr)):
        arr[i] *= arr[i]
    print arr

# 9
def countGreaterThanY(arr, y):
    count = 0
    for i in arr:
        if i > y:
            count += 1
    print count

# 10
def zeroNegativeValues(arr):
    for i in range(len(arr)):
        if arr[i] < 0:
            arr[i] = 0
    print arr

# 11
def minMaxAverage(arr):
    pass

# 12
def shiftArrayValuesToLeft(arr):
    for i in range(1,len(arr)):
        arr[i-1] = arr[i]
    arr.pop()
    print arr

# 13
def swapStringForNegatives(arr, string):
    pass

# 14
def sumValuesFrom0toN(n):
    mysum = 0
    for i in range(0,n+1):
        mysum += i
    print mysum

    # print n*(n+1)/2

# 15
def convertFarenheitToCelcius(f):
    print((f-32)*5/9)

# 16
def pushFront(arr, val):
    arr.append(0)
    for i in range(len(arr)-1,-1,-1):
        arr[i] = arr[i-1]
    arr[0] = val
    print arr

# 17
def arrayReverse(arr):
    for i in range(int(len(arr)/2)):
        temp = arr[i]
        arr[i] = arr[len(arr)-i-1]
        arr[len(arr)-i-1] = temp
    print arr

    # for i in range(int(len(arr)/2)):
    #     temp = arr[i]
    #     arr[i] = arr[-i-1]
    #     arr[-i-1] = temp
    # print arr

# 18
def stringReverse(string):
    newStr = ""
    for i in range(len(string)-1, -1, -1):
        newStr += string[i]
    print newStr

# 19 
def characterCount(sentence):
    # return number of characters ignoring whitespace
    count = 0
    for letter in sentence:
        if letter != " ":
            count += 1
    print count

# 20
def wordCount(sentence):
    # return the number of words in a sentence
    sentence = " " + sentence
    count = 0
    for i in range(len(sentence)-1):
        if sentence[i] == " " and sentence[i+1] != " ":
            count += 1
    return count 


arr = [22, 5, 17, -3, 0, -2, -1, 60, 64, -8]
string = "Coding Dojo"
sentence = " Lorem ipsum   dolor sit  amet! "

# print print1to255()
# print printOdds1to255()
# print printIntsAndsSums255()
# print iterateAndPrintList(arr)
# print printMax(arr)
# print printAverage(arr)
# print arrayOdds1to255()
# print squareValues(arr)
# print countGreaterThanY(arr, 16)
# print zeroNegativeValues(arr)
# print minMaxAverage(arr)
# print shiftArrayValuesToLeft(arr)
# print swapStringForNegatives(arr, string)
# print sumValuesFrom0toN(8)
# print convertFarenheitToCelcius(-40)
# print pushFront(arr, 7)
# print arrayReverse(arr)
# print stringReverse(string)
# print characterCount(sentence)
print wordCount(sentence)
import time

x = int(input("Enter an x value -> "))

startEquation = 9*x*x*x*x*x*x*x*x*x + 8*x*x*x*x*x*x*x*x + 7*x*x*x*x*x*x*x + 6*x*x*x*x*x*x + 5*x*x*x*x*x + 4*x*x*x*x + 3*x*x*x + 2*x*x + x
times = []


def calcPolyomial(polynomialInc):

    bulkTime = 0

    for i in range(100):
        startTime = time.time()
        newEquation = startEquation + polynomialInc
        endTime = time.time()
        bulkTime += endTime-startTime

    avgTime = bulkTime/100

    return bulkTime

times.append(calcPolyomial(10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(16*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(17*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 16*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(18*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 17*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 16*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(19*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 18*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 17*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 16*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))
times.append(calcPolyomial(20*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 19*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 18*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 17*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 16*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 15*x*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 14*x*x*x*x*x*x*x*x*x*x*x*x*x*x + 13*x*x*x*x*x*x*x*x*x*x*x*x*x + 12*x*x*x*x*x*x*x*x*x*x*x*x + 11*x*x*x*x*x*x*x*x*x*x*x + 10*x*x*x*x*x*x*x*x*x*x))

print(times)



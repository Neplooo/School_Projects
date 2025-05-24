import time

x = float(input("Enter an x value -> "))

startEquation = (x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))
times = []

def calcPolynomial(polynomial):

    bulkTime = 0

    for i in range(100):
        startTime = time.time()
        result = polynomial
        endTime = time.time()
        bulkTime += endTime - startTime
    
    avgTime = bulkTime/100

    return avgTime


times.append(calcPolynomial((x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1))))))))))))
times.append(calcPolynomial((x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))
times.append(calcPolynomial((x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1))))))))))))))
times.append(calcPolynomial((x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))))
times.append(calcPolynomial((x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1))))))))))))))))
times.append(calcPolynomial((x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))))))
times.append(calcPolynomial((x+16*(x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1))))))))))))))))))
times.append(calcPolynomial((x+17*(x+16*(x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))))))))
times.append(calcPolynomial((x+18*(x+17*(x+16*(x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1))))))))))))))))))))
times.append(calcPolynomial((x+19*(x+18*(x+17*(x+16*(x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))))))))))
times.append(calcPolynomial(x+20*(x+19*(x+18*(x+17*(x+16*(x+15*(x+14*(x+13*(x+12*(x+11*(x+10*(x+9*(x+8*(x+7*(x+6*(x+5*(x+4*(x+3*(x+2*(x+1)))))))))))))))))))))


print(times)
from __future__ import annotations


class Set(list):
    """
    Mathematical notation for a set. It inherets the properties of a list.
    """

    #Master Set; Other sets can be compared with this static variable
    MASTER_SET = ["t", "e", "x", "a", "s"]

    def __init__(self, set):
        self.extend(set) #Give the class the "set" properties

    def checkIntersect(self, inputSet:Set):
        """
        Checks the intersect of the set compared to another set.

        @param inputSet: The set that the intersect is checked to.
        @type inputSet: Set
        @return commonChars: The values that both sets have in common. 
        """

        #Create an empty list to store the common characters
        commonChars = []

        for i in self:
            if(i not in commonChars and i in inputSet):
                commonChars.append(i)
        
        for i in inputSet:
            if(i not in commonChars and i in self):
                commonChars.append(i)

        #If there aren't any common characters, it's disjointed
        if(len(commonChars) == 0):
            return "This is a disjointed Set!"
        
        return commonChars
    
    def checkUnion(self, inputSet:Set):
        """
        Checks the union of the set compared to another set.

        @param inputSet: The set that the intersect is checked to.
        @type inputSet: Set
        @return allChars: Every value in each set (No repeats). 
        """

        allChars = []

        for i in self:
            if(i not in allChars):
                allChars.append(i)

        for i in inputSet:
            if(i not in allChars):
                allChars.append(i)

        return allChars
    
    def checkComplement(self):
        """
        Checks the complement of the current set compared to the [MASTER_SET]

        @return The intersect of the set to the 
        """
        return self.checkIntersect(self.MASTER_SET)
    
    def returnDifference(self, inputSet):
        returnSet = []

        for i in inputSet:
            if(i not in self):
                returnSet.append(i)

        return returnSet



uniSet = Set(["t", "e", "x", "a", "s"])
set1 = Set(["c", "a", "r", "o", "l", "i", "n"])
set2 = Set(["f", "l", "o", "r", "i", "d", "a"])
set3 = Set([2, 4, 6, 8])
set4 = Set([1, 2, 3, 4, 5, 6, 7, 8])

print("Intersect: " + str(set1.checkIntersect(set2)))
print("Union: " + str(set1.checkUnion(set2)))
print("Complement with Master Set: " + str(set1.checkComplement()))
print("Difference between set 3 and 4: " + str(set3.returnDifference(set4)))


        


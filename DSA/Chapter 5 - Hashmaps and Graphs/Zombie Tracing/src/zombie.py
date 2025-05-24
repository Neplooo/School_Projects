#Albert Mathisz
#---Contact Tracing---#
#  A really bad attempt at tracing contacts

import copy
import csv
import sys

class Tracer:

    def __init__(self):
        self.filePath = sys.argv[1] #Make sure the file path is the first argument provided
        self.people = []

    def setFilePath(self, filePath):
        self.filePath = filePath      

    #---Prints out all of the People and who they've had contact with---#
    def part1(self):

        rows = []

        with open(self.filePath, "r") as csvFile:

            csvReader = csv.reader(csvFile)

            for row in csvReader:
                rows.append(row)
            
        print("Contact Records:")

        for row in rows:
            row = sorted(row)
            for index in range(0, len(row)):
                if index == 0:
                    print(row[index] + " has had contact with: ", end="")
                else:
                    if(index != len(row) - 1):
                        print(row[index] + ", ", end="")
                    else:
                        print(row[index])
        
        self.rows = rows
        
        #print("End Of File")

    #Creates a dictionary based of the csv data beacuse cool beans
    def createDict(self):
        
        rows = self.rows
        people = self.people

        contacts = {}
        subContacts = []

        for row in rows:
            subContacts.clear()
            for index in range(1, len(row) - 1):
                contacts[row[0]] = [x for x in row if x != row[0]] #List Comprehension!!!

        self.contacts = contacts

        return contacts

        #print(contacts)


    #Puts all the people into a list.
    def findPeople(self):
        people = []

        rows = self.rows

        for row in rows:
            for person in row:
                if(person in people):
                    pass
                else:
                    people.append(person)

        self.people = sorted(people)

    #--Prints out all known patient zeroes--#
    def part2(self):
        self.findPeople
        rows = self.rows
        people = copy.deepcopy(self.people)

        for row in rows:
            for index in range(1, len(row)):
                person = row[index]
                if(person in people):
                    people.remove(person)
        
        print("Patient Zero(s): ", end=" ")

        counter = 0
        for person in people:
            if counter != len(people) - 1:
                print(person, end=", ")
                counter += 1
            else:
                print("and " + person)

        self.patientZeroes = sorted(people)

        return people

    #--Finds all Zombies--#
    def findZombies(self):
        rows = self.rows
        zombies = []

        for row in rows:
            zombies.append(row[0])

        self.zombies = sorted(zombies)

        return zombies

    #--Finds all potential zombies--#
    def part3(self):

        rows = self.rows
        zombies = self.zombies
        potentialZombies = []

        for row in rows:
            for person in row:
                if(person in zombies):
                    pass
                else:
                    if person not in potentialZombies:
                        potentialZombies.append(person)

        print("Potential Zombies: ", end="")

        counter = 0
        for person in potentialZombies:
            if counter != len(potentialZombies) - 1:
                print(person, end=", ")
            else:
                print(person)
            counter += 1

        self.potentialZombie = sorted(potentialZombies)

        return potentialZombies

    #--Finds all people who do not qualify as zombies or potentials--#
    def part4(self):
        people = self.people
        potentialZombies = self.potentialZombie
        patientZeroes = self.patientZeroes
        other = []

        for person in people:
            if(person not in potentialZombies and person not in patientZeroes):
                other.append(person)

        print("Neither Patient Zero or Potential Zombie: ", end="")

        counter = 0
        for person in other:
            if counter != len(other) - 1:
                print(person, end=", ")
            else:
                print(person)
            counter += 1

        self.other = other

        return other

    #--Finds the most viral people--#
    def part5(self):

        #grab the rows
        rows = self.rows

        #Create Tracker Variables
        mostInfected = -1
        mostInfectedPerson = ""

        #Go through every row
        for row in rows:
            #Set a minimum value for the amount of people infected
            peopleInfected = 0

            #Loop through all the people that the person has infected
            for person in row:
                peopleInfected += 1

            #If they've infected more people than the previous max, make the the new most viral.
            if peopleInfected > mostInfected:
                mostInfected = peopleInfected
                mostInfectedPerson = row[0]

        #Return results.
        print("Most Viral Person: " + mostInfectedPerson)

        return mostInfectedPerson

    #--Finds the people who have had the most contact--#
    def part6(self):
        
        #Pull the necessary lists from the class storage
        rows = self.rows
        people = self.people

        #Create new lists representing the things that we're looking for.
        peopleContactCount = []
        mostContactedPeople = []

        #Set the list size ahead of time so that we don't go out of bounds.
        for i in range(0, len(people) - 1):
            peopleContactCount.append(0)

        #Iterate through the rows and put the amount of contacts into a parallel array with people containing
        #The amount of contacts.
        for row in rows:
            for index in range(1, len(row) - 1):
                try: 
                    peopleContactCount[people.index(row[index])] += 1
                except ValueError:
                    print("Person not present in people class.")
        
        #Create tracker variables to search for the most contacts
        mostContacts = -1
        mostContactIndex = -1

        for i in range(0, len(peopleContactCount) - 1): #loop through the new list
            if peopleContactCount[i] >= mostContacts: #Do a linear search to see who has the most contacts
                if peopleContactCount[i] == mostContacts: #If there are multiple people with the same amount of contacts, add them to the list.
                    mostContacts = peopleContactCount[i]
                    mostContactIndex = i
                    mostContactedPeople.append(people[mostContactIndex])
                else: #If we found someone with even more contacts, wipe the list and add it.
                    mostContactedPeople.clear()
                    mostContacts = peopleContactCount[i]
                    mostContactIndex = i
                    mostContactedPeople.append(people[mostContactIndex])


        #Print it out nicely
        print("Most Contacted: ", end="")

        for person in mostContactedPeople:
            print(person, end=", ")

        #Add the most contacted people to global class storage
        self.mosContactedPeople = mostContactedPeople

        return mostContactedPeople

    #--Finds the max distance of each person from a zombie--#
    def part7(self):

        rows = self.rows
        people = self.people

        changed = True
        distances = []

        for i in range(0, len(people)):
            distances.append(0)

        #Implementation of Dr. DeGennaro's Algorithm presented in canvas.
        while changed == True:
            changed = False
            for person in people:
                for row in rows:
                    if row[0] == person:
                        for index in range(1, len(row)):
                            if distances[people.index(person)] <= distances[people.index(row[index])]:
                                distances[people.index(person)] = distances[people.index(row[index])] + 1
                                changed = True

        #Printing out the distances nicely
        print("Heights:")

        for i in range(0, len(people)):
            print(str(people[i]) + ": " + str(distances[i]))
        



set1 = Tracer()

set1.part1()
set1.createDict()
set1.findPeople()
set1.part2()
set1.findZombies()
set1.part3()
set1.part4()
set1.part5()
set1.part6()
set1.part7()

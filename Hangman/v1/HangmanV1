#---Hang Man---#

import random
import string

hangmanPics = ['''
  +---+
  |   |
      |
      |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
      |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
  |   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|   |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
      |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
 /    |
      |
=========''', '''
  +---+
  |   |
  O   |
 /|\  |
 / \  |
      |
=========''']

#Word bank of animals
words = ('ant baboon badger bat bear beaver camel cat clam cobra cougar '
      'coyote crow deer dog donkey duck eagle ferret fox frog goat '
      'goose hawk lion lizard llama mole monkey moose mouse mule newt '
      'otter owl panda parrot pigeon python rabbit ram rat raven '
      'rhino salmon seal shark sheep skunk sloth snake spider '
      'stork swan tiger toad trout turkey turtle weasel whale wolf '
      'wombat zebra ').split()

print("Lets Play Hangman!")

#Print Empty Gallows
print(hangmanPics[0])

#Print a word
word = random.choice(words)

#Set it so that no body is there
lives = 0

#Random Debug Crap
wordList = list(word)
print(word)
print(wordList)

#Starts Game after the setup is done
game = True

while game == True:
#Frontend Guessing Prompt
  print("Guess a letter:")
  guess = input("-->")


#If the letter is in the word, Congrat them that they got the letter and go back to guess prompt. Also puts the letter into the solveword bracket.
  if guess in word:
    print("Congrats, you guessed a letter!")
    solveword += guess
    print(solveword)

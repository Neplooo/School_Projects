#-Libraries-#
import random
import pwinput



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


correctGuess = []
incorrectGuess = []

#Opens the txt file
with open('Hangman/v4/fivewordlist.txt', 'r') as reader:
    # Read & print the entire file
    words = (reader.read().split("\n"))

print("Would you like to play with the computer or make a word for another human? (computer/human)")

game = input()

#Lets you type in a custom input or play with the computer as normal.
if game == "computer":
  word = random.choice(words).lower()
elif game == "human":
  print("Put a word in and then pass it to a friend and let them play!")
  word = pwinput.pwinput(prompt="Type a Word: ").lower()

print("Lets Play Hangman:")


while True:
# After 6 incorrect guesses, stop the loop.
  if len(incorrectGuess) > 5:
    print("You did not guess the word, you lose!")
    print("The correct word was: " + word.title())
    break

  #Prints the hangman depending on the amount of incorrect Guesses
  print(hangmanPics[len(incorrectGuess)])

  #Prints the guessed letter
  print("Guessed Letters:" + str(incorrectGuess))

  #Display the word as a blank, fills them in as letters are entered
  wordDisplay = []
  for letter in word:
    if letter in correctGuess:
      wordDisplay.append(letter)
    else:
      wordDisplay.append("_")

  print("  ".join(wordDisplay))

  if "".join(wordDisplay) == word:
    print("Congradulations, You Won!")
    break

  #Guesses
  guess = input("Guess A Letter: ").lower()

  alphabet = "abcdefghijklmnopqrstuvwxyz"

  if guess not in alphabet:
    print("invalid choice. Try again.")
  elif guess in correctGuess or guess in incorrectGuess:
    print("You already guessed that letter. Try again.")
  elif guess in word:
    correctGuess.append(guess)
  else: 
    incorrectGuess.append(guess)
    print("Wrong answer, keep trying.")



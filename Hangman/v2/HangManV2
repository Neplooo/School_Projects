#-Libraries-#
import random



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

words = ('ant baboon badger bat bear beaver camel cat clam cobra cougar '
      'coyote crow deer dog donkey duck eagle ferret fox frog goat '
      'goose hawk lion lizard llama mole monkey moose mouse mule newt '
      'otter owl panda parrot pigeon python rabbit ram rat raven '
      'rhino salmon seal shark sheep skunk sloth snake spider '
      'stork swan tiger toad trout turkey turtle weasel whale wolf '
      'wombat zebra ').split()

word = random.choice(words).lower()

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

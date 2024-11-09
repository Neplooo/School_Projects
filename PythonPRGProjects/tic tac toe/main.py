#--Import Things--#
import random

#Print the board that is a list of 10 strings (Ignore index 0)
def drawBoard(board):
  print(board[7] + "|" + board[8] + "|" + board[9])
  print("-+-+-")
  print(board[4] + "|" + board[5] + "|" + board[6])
  print("-+-+-")
  print(board[1] + "|" + board[2] + "|" + board[3])

#drawBoard( [" ", " ", " ", " ", " ", " ", " ", " ", " ", " "])

#Let the player choose a side: X/O
#Return a list with the player's list as the first item and the computer's letter as the second.

def inputPlayerLetter():
  letter = ""
  while not (letter == "X" or letter =="O"):
    print("Do you want to be X or O?")
    letter = input().upper()

  #The first letter in the list belongs to the player, the second one belongs to the computer
  if letter == "X":
    return ["X", "O"]
  else:
    return ["X", "O"]

#Randomly choose which player goes first.
def whoGoesFirst():
  if random.randint(0,1) == 0:
    return "computer"
  else:
    return "player"

#Makes a move
def makeMove(board, letter, move):
  board[move] = letter

#This function returns true if a player wins.
#We use "bo" instead of board and "le" instead of letter.
def isWinner(bo, le):
  return((bo[7] == le and bo[8] == le and bo[9] == le) #Across the top
  or (bo[4] == le and bo[5] == le and bo[6] == le)#Across the bottom
  or (bo[1] == le and bo[2] == le and bo[3] == le)#Across the bottom
  or (bo[7] == le and bo[4] == le and bo[1] == le)#Down the left
  or (bo[8] == le and bo[5] == le and bo[2] == le)#Down the middle
  or (bo[9] == le and bo[6] == le and bo[3] == le)#Down the right
  or (bo[7] == le and bo[5] == le and bo[3] == le)#Diagonal
  or (bo[9] == le and bo[5] == le and bo[1] == le)#Diagonal
  )

#Make a copy of the board list and return it.
def getBoardCopy(board):
  boardCopy = []
  for i in board:
    boardCopy.append(i)
  return boardCopy

#Return true if the passed move is free on the passed board
def isSpaceFree(board, move):
  return board[move] == " "

#Let player enter move
def getPlayerMove(board):
  move = " "
  while move not in "1 2 3 4 5 6 7 8 9".split() or not isSpaceFree(board, int(move)):
    print("What is your next move? (1-9)")
    move = input()
  return int(move)

#Returns a valid move from the passed list on the passed board
#Returns none if there is no valid move
def chooseRandomMoveFromList(board, movesList):
  possibleMoves = []
  for i in movesList:
    if isSpaceFree(board, i):
      possibleMoves.append(i)
  
  if len(possibleMoves) != 0:
    return random.choice(possibleMoves)
  else:
    return None

#Give a board and the computer's letter, determine where to move and return that move.
def getComputerMove(board, computerLetter):
  if computerLetter == "X":
    playerLetter = "O"
  else:
    playerLetter = "X"

  #Tic-Tac-Toe Algorithm
  #First see if you can win
  for i in range (1,10):
    boardCopy = getBoardCopy(board)
    if isSpaceFree(boardCopy, i):
      makeMove(boardCopy, computerLetter, i)
      if isWinner(boardCopy, computerLetter):
        return i

  #Check if play could win next round and block it.
  for i in range (1,10):
    boardCopy = getBoardCopy(board)
    if isSpaceFree(boardCopy, i):
      makeMove(boardCopy, playerLetter, i)
      if isWinner(boardCopy, playerLetter):
        return i

  #Try to take a corner
  move = chooseRandomMoveFromList(board, [1, 3, 7, 9])
  if move!= None:
    return move

  #Try to take center
  if isSpaceFree(board, 5):
    return 5

  #Try to take a side
  return chooseRandomMoveFromList(board, [2, 4, 6, 8])

#Return true if every space on the board has been taken otherwise, return false
def isBoardFull(board):
  for i in range(1, 10):
    if isSpaceFree(board, i):
      return False
  return True

print("Welcome to Tic-Tac-Toe!")

while True:
  #Reset board
  theBoard = [" "] * 10

  #Set player and computer Letter
  playerLetter, computerLetter = inputPlayerLetter()
  turn = whoGoesFirst()
  print("The " + turn + " will go first.")
  gameIsPlaying = True

  #Player's Turn
  while gameIsPlaying:
    if turn == "player":
      drawBoard(theBoard)
      move = getPlayerMove(theBoard)
      makeMove(theBoard, playerLetter, move)

      if isWinner(theBoard, playerLetter):
        drawBoard(theBoard)
        print("Yay, you win!")
        gameIsPlaying = False
      else:
        if isBoardFull(theBoard):
          drawBoard(theBoard)
          print("The game has tied.")
          gameIsPlaying = False
        else:
          turn = "computer"

    else:
      move = getComputerMove(theBoard, computerLetter)
      makeMove(theBoard, computerLetter, move)

      if isWinner(theBoard, computerLetter):
        drawBoard(theBoard)
        print("The computer has won.")
        gameIsPlaying = False
      else:
        turn = "player"
  
  print("Do you want to play again?(y/n)")
  if not input().lower().startswith("y"):
    break

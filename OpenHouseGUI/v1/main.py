#--Import Stuff--#
import os
import tkinter as tk
from tkinter import ttk

#Create Basic Parameters
root = tk.Tk()
root.geometry("1920x1080")
root.attributes("-fullscreen", True)
root.iconbitmap("Icon/Path/Here")
#root.configure(background="Blue")
root.columnconfigure(1, weight=1)

#Add a background image to make stuff look snazzy
backgroundImage = tk.PhotoImage(file="Background/Path/Here")
backgroundLabel = tk.Label(root, image=backgroundImage)
backgroundLabel.place(x=0, y=0, relwidth=1, relheight=1)

#Create Title Label
titleLabel = tk.Label(root, text="GTCHS Open House", font=("Calibri", 25))
titleLabel.grid(row=0, column=1)


#Create Subtittle Label for Videos
videoLabel = tk.Label(root, text="Videos", font=("Calibri", 15))
videoLabel.grid(row=2, column=0)

#Create Subtittle Label for Games
gameLabel = tk.Label(root, text="Games", font=("Calibri", 15))
gameLabel.grid(row=2, column=1)

#Create Subtittle Label for Pictures
pictureLabel = tk.Label(root, text="Pictures", font=("Calibri", 15))
pictureLabel.grid(row=2, column=2)

#Create Label Frame to act as columns
videoLF = tk.LabelFrame(root, text="Alignment")
gameLF = tk.LabelFrame(root, padx=20, pady=20)
pictureLF = tk.LabelFrame(root)

#Position Label Frames
videoLF.grid(row=3, column=0)
gameLF.grid(row=3, column=1)
pictureLF.grid(row=3, column=2)

#Add content into Video Label Frame
videoButton = tk.Button(videoLF, text="Test Video", command=os.system("Video/Path/Here"))
videoButton.grid(row=0, column=0)

#Add content into Game Label Frame
testButton = tk.Button(gameLF, text="Test", command=os.system("Game/Path/Here"))
testButton.grid(row=0, column=0)

#Add content into Picture Label Frame


#Launch the window
root.mainloop()

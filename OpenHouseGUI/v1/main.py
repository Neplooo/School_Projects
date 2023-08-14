#--Import Stuff--#
import tkinter as tk
from tkinter import ttk

#Create Basic Parameters
root = tk.Tk()
root.geometry("1920x1080")
root.attributes("-fullscreen", True)
#root.configure(background="Blue")

root.columnconfigure(1, weight=1)

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
videoLF = tk.Frame(root, borderwidth=2, relief="flat")
gameLF = tk.LabelFrame(root, padx=20, pady=20)
pictureLF = tk.LabelFrame(root)

#Position Label Frames
videoLF.grid(row=3, column=0)
gameLF.grid(row=3, column=1)
pictureLF.grid(row=3, column=2)

#Add content into Label Frames
testLabel = tk.Label(gameLF, text="Test")

#Launch the window
root.mainloop()

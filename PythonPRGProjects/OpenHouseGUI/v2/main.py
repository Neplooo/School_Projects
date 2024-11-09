# Import Stuff
import pygame
from pygame import *  # (Not a good Coding Practice ISAAC)

# Start The Pygame Window
pygame.init()

# Configure the pygame window
window_width = 1920
window_height = 1080
clock = pygame.time.Clock()
fps = 60

# Change the screen size to the width and height of the screen
screen = pygame.display.set_mode((window_width, window_height))

# Add Fonts and a test image
font = pygame.font.SysFont('Segoe UI', 40)
img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\makey.png")
left = font.render('Tap to scroll left.', False, (255, 255, 255))
right = font.render('Tap to scroll right.', False, (255, 255, 255))

# slots

slots = [0, 1, 2, 3, 4, 5, 6, 7]
timeout = 0
slotnum = 0
maxSlot = slots[-1]

# main loop

# If the window close button is pressed, quit the app.
running = True
while running:
    for event in pygame.event.get():
        if event.type == QUIT:
            running = False

    # Grab the mouse coordinates
    mx = pygame.mouse.get_pos()[0]
    my = pygame.mouse.get_pos()[1]

    screen.fill((30, 30, 30))

    # Add backdrop
    pygame.draw.rect(screen, (40, 40, 40), (0, 0, 480, 1080))
    pygame.draw.rect(screen, (255, 255, 255), (0, 80, 480, 2))
    screen.blit(left, (90, 10))
    pygame.draw.rect(screen, (40, 40, 40), (1440, 0, 480, 1080))
    pygame.draw.rect(screen, (255, 255, 255), (1440, 80, 480, 2))
    screen.blit(right, (1540, 10))

    # If the mouse is pressed, timeout the person
    keys = pygame.key.get_pressed()
    if timeout > 0:
        timeout -= 1

    # Add the slots in. To add a new slot, simply add another elif statement
    for slot in slots:
        if slots[slotnum] == 0:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\IMG-5715.jpg")
            color = (0, 0, 0)
        elif slots[slotnum] == 1:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\IMG_6004.png")
            color = (0, 0, 0)
        elif slots[slotnum] == 2:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\IMG_5996.png")
            color = (0, 0, 0)
        elif slots[slotnum] == 3:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\IMG_6001.png")
            color = (0, 0, 0)
        elif slots[slotnum] == 4:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\silly.jpg")
            color = (0, 0, 0)
        elif slots[slotnum] == 5:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\gtchsnews1.png")
            color = (0, 0, 0)
        elif slots[slotnum] == 6:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\spanishSalute.jpg")
            color = (0, 0, 0)
        elif slots[slotnum] == 7:
            img = pygame.image.load("C:\\Users\\Albert.Mathisz\\Downloads\\IMG_5994.png")
            color = (0, 0, 0)
        if slots[slot] != 1:
            # pygame.draw.rect(screen, color, (-690 + (slots[slot] * 1200), 310, 900, 440), border_radius = 25)
            img = pygame.transform.scale(img, (900, 440))
            screen.blit(img, (-690 + (slots[slot] * 1200), 310))
        else:
            # pygame.draw.rect(screen, color, (-690 + (slots[slot] * 1200), 260, 900, 540), border_radius = 50)
            img = pygame.transform.scale(img, (900, 540))
            screen.blit(img, (-690 + (slots[slot] * 1200), 260))
        slotnum += 1
    slotnum = 0

    # If the left side of the screen is pressed, scroll to the left
    if mx > 1410 and pygame.mouse.get_pressed()[0]:
        for num in slots:
            if timeout == 0 and slots[slotnum] > 0:
                slots[slotnum] -= 1
            elif timeout == 0 and slots[slotnum] == 0:
                slots[slotnum] += maxSlot
            slotnum += 1
        slotnum = 0
        timeout = 5

    # If the right side of the screen is pressed, scroll to the right
    if mx < 510 and pygame.mouse.get_pressed()[0]:
        for num in slots:
            if timeout == 0 and slots[slotnum] < maxSlot:
                slots[slotnum] += 1
            elif timeout == 0 and slots[slotnum] == maxSlot:
                slots[slotnum] -= maxSlot
            slotnum += 1
        slotnum = 0
        timeout = 5

    # Start the loop over

    pygame.display.flip()
    clock.tick(fps)

pygame.quit()

# Template Given by Acrux, Comments and codew improvements made by Neplo

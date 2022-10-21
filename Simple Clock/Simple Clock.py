from __future__ import print_function
import time
import sys
import datetime

while True:
    now = datetime.datetime.now()
    print(now.strftime("%H:%M:%S"), end="\r")
    sys.stdout.flush()
    time.sleep(.4)

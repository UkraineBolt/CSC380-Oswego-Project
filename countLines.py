import subprocess
import os
from sys import argv 
from os import listdir
from os.path import isfile, join


def countLines( mypath ):

    onlyfiles = [f for f in listdir(mypath) if isfile(join(mypath, f))]

    for file in onlyfiles:
        f = mypath + "/" + file
        lineCount = subprocess.check_output(["wc", "-l", f]).split()[0]
        print(file,"=",str(lineCount, encoding="utf-8"))

countLines(argv[1])

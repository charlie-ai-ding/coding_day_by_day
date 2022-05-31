import os
import shutil

java_spring = "/\\192.168.0.113\\Video2\\jike\\107-小马哥讲Spring核心编程思想\\1-99"

test ="C:\\Users\\charl\\Desktop\\mp3"

all_pdf = "/\\192.168.0.113\\Video2"

all_pdf2 = "C:\\Users\\charl\\Desktop\\80-网络编程实战"

target ="C:\\Users\\charl\\Desktop\\mp3"

def  allfiles(path):
    for filename in os.listdir(path):
        f = os.path.join(path,filename)
        if os.path.isfile(f):
            if f.__contains__(".mp3"):
                print(filename)
        elif os.path.isdir(f):
            allfiles(f)


# allfiles(all_pdf2)

def copy_file(src,target,filename):
    path = os.path.join(target,filename)
    shutil.copy(src,path)








import os
from moviepy.editor import *

# video = VideoFileClip(os.path.join("/\\192.168.0.113\\Video2\\jike\\107-小马哥讲Spring核心编程思想\\1-99","01kcjs.mp4"))
# video.audio.write_audiofile(os.path.join("C:\\Users\\charl\\Desktop\\mp4_mp3","java1.mp3"))

java_spring = "/\\192.168.0.113\\Video2\\jike\\107-小马哥讲Spring核心编程思想\\1-99"

def _mp4_to_mp3(mp4file,mp3fileName):
    video = VideoFileClip(os.path.join(mp4file))
    video.audio.write_audiofile(os.path.join("C:\\Users\\charl\\Desktop\\mp4_mp3",mp3fileName))


def _fileName(str):
    ss = str.split("\\")
    return ss[len(ss)-1]

def _fileName_mp4_mp3(filename):
    if(filename.__contains__(".mp4")):
        return filename.replace(".mp4", ".mp3")
    elif (filename.__contains__(".mp4")):
        return filename.replace(".flv", ".mp3")


def  allfiles(path):
    for filename in os.listdir(path):
        f = os.path.join(path,filename)
        if os.path.isfile(f):
            filename =  _fileName_mp4_mp3(_fileName(f))
            print(filename)

# allfiles(java_spring)

def  transMp4ToMp3(sourcePath,targetPath):
    for filename in os.listdir(sourcePath):
        f = os.path.join(sourcePath,filename)
        if os.path.isfile(f):
            filename =  _fileName_mp4_mp3(_fileName(f))
            _mp4_to_mp3(f,filename)


node= "/\\192.168.0.113\\Video2\\jike\\78-TypeScript开发实战"

node ="C:\\Users\\charl\\Desktop\\01 网络编程"
target ="C:\\Users\\charl\\Desktop\\python_01"

transMp4ToMp3(node,target)

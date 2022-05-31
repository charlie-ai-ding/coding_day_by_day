import os
from moviepy.editor import *

from concurrent.futures import ThreadPoolExecutor
import threading
import time


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
    return filename.replace(".mp4",".mp3")

def  allfiles(path):
    for filename in os.listdir(path):
        f = os.path.join(path,filename)
        if os.path.isfile(f):
            filename =  _fileName_mp4_mp3(_fileName(f))
            print(filename)

# allfiles(java_spring)

def _allfilesToArr(path):
    result =[]
    for filename in os.listdir(path):
        f = os.path.join(path,filename)
        if os.path.isfile(f):
            result.append(f)
    return result

def  transMp4ToMp3(sourcePath,targetPath):
    for filename in os.listdir(sourcePath):
        f = os.path.join(sourcePath,filename)
        if os.path.isfile(f):
            filename =  _fileName_mp4_mp3(_fileName(f))
            _mp4_to_mp3(f,filename)


node= "/\\192.168.0.113\\Video2\\jike\\78-TypeScript开发实战"
target ="C:\\Users\\charl\\Desktop\\mp4_mp3"

# transMp4ToMp3(node,target)

# 定义一个准备作为线程任务的函数
def action(max):
    my_sum = 0
    for i in range(max):
        print(threading.current_thread().name + '  ' + str(i))
        my_sum += i
    return my_sum

def action_mp4_mp3(fileAbsPath,target="C:\\Users\\charl\\Desktop\\mp4_mp3"):
    mp3fileName = _fileName_mp4_mp3(_fileName(fileAbsPath))
    targetPath = os.path.join(target,mp3fileName)
    _mp4_to_mp3(fileAbsPath,targetPath)


# 创建一个包含4条线程的线程池
with ThreadPoolExecutor(max_workers=47) as pool:
    # 使用线程执行map计算
    # 后面元组有3个元素，因此程序启动3条线程来执行action函数
    results = pool.map(action_mp4_mp3, _allfilesToArr(node))
    print('--------------')
    for r in results:
        print(r)
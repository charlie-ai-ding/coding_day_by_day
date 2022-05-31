from pydub import AudioSegment
from pydub.silence import split_on_silence, detect_nonsilent
import os

filename = "now2"
path_from = "C:\\Users\\charl\\workspace\\coding_day_by_day\\python\\cs61a\\tools\\mp3\\data\\"
path_output = "C:\\Users\\charl\\workspace\\coding_day_by_day\\python\\cs61a\\tools\\mp3\\output\\"
song = AudioSegment.from_mp3(path_from + filename + ".mp3")

allsounds = split_on_silence(song)


def split_sound_and_export():
    for i, chunk in enumerate(allsounds[::180000]):
        # with open("C:/Users/charl/workspace/coding_day_by_day/python/cs61a/tools/mp3/output/sound-%s.mp3" % i,"wb") as f:
        #     chunk.export(f,format="mp3")
        print(i)



split_sound_and_export()



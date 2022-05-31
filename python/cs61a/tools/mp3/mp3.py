# Import the AudioSegment class for processing audio and the
# split_on_silence function for separating out silent chunks.
from pydub import AudioSegment
from pydub.silence import split_on_silence, detect_nonsilent

import os

# Define a function to normalize a chunk to a target amplitude.
def match_target_amplitude(aChunk, target_dBFS):
    ''' Normalize given audio chunk '''
    change_in_dBFS = target_dBFS - aChunk.dBFS
    return aChunk.apply_gain(change_in_dBFS)


def deal_chunks(chunks):
    # Process each chunk with your parameters
    for i, chunk in enumerate(chunks):
        # Create a silence chunk that's 0.5 seconds (or 500 ms) long for padding.
        silence_chunk = AudioSegment.silent(duration=100)

        # Add the padding chunk to beginning and end of the entire chunk.
        audio_chunk = silence_chunk + chunk + silence_chunk

        # Normalize the entire chunk.
        normalized_chunk = match_target_amplitude(audio_chunk, -20.0)

        # Export the audio chunk with new bitrate.
        print("Exporting chunk{0}.mp3.".format(i))
        normalized_chunk.export(
            "mp3/chunk{0}.mp3".format(i),
            bitrate="192k",
            format="mp3"
        )


def merge_chunks(chunks):
    new_mp3= AudioSegment.silent(duration=200)
    for i, chunk in enumerate(chunks):
        silence_chunk = AudioSegment.silent(duration=1000)
        audio_chunk = silence_chunk + chunk + silence_chunk
        new_mp3 = new_mp3 + audio_chunk

    normalized_chunk = match_target_amplitude(new_mp3, -30.0)

    normalized_chunk.export(
        "mp3/new_version.mp3",
        bitrate="192k",
        format="mp3"
    )

def merge_chunks_interval(chunks,interval,path,filename):
    new_mp3= AudioSegment.silent(duration=200)
    for i, chunk in enumerate(chunks):
        silence_chunk = AudioSegment.silent(duration=interval[i])
        audio_chunk = silence_chunk + chunk + silence_chunk
        new_mp3 = new_mp3 + audio_chunk

    normalized_chunk = match_target_amplitude(new_mp3, -30.0)

    normalized_chunk.export(
        path+filename+".mp3",
        bitrate="192k",
        format="mp3"
    )

def help_get_interval(ls):
    result =[]
    for item in ls:
        temp= item[1]-item[0]
        result.append(temp)
    return result



# Load your audio.
# song = AudioSegment.from_mp3("power1.mp3")

# Split track where the silence is 2 seconds or more and get chunks using
# the imported function.
# chunks = split_on_silence (
#     # Use the loaded audio.
#     song,
#     # Specify that a silent chunk must be at least 2 seconds or 2000 ms long.
#     min_silence_len = 250,
#     # Consider a chunk silent if it's quieter than -16 dBFS.
#     # (You may want to adjust this parameter.)
#     silence_thresh = -30
# )

# chunks2 = detect_nonsilent(song, min_silence_len=250,silence_thresh= -30)
# interval = help_get_interval(chunks2)
#
# merge_chunks_interval(chunks,interval)


# chunks = detect_nonsilent(song,150)

# print(len(chunks))
# print(len(chunks2))




# print(chunks2)
# print(interval)


# deal_chunks(chunks)

# merge_chunks(chunks)
#

def trans_audio_with_silence(path_from,filename,outpath):
    song = AudioSegment.from_mp3(path_from+filename+".mp3")
    chunks_audio = split_on_silence(song,min_silence_len=250,silence_thresh=-30)
    chunks_silence_interval = detect_nonsilent(song, min_silence_len=250, silence_thresh=-30)
    intervals = help_get_interval(chunks_silence_interval)
    merge_chunks_interval(chunks_audio,intervals,outpath,filename+"_")


# trans_audio_with_silence("power1")

# /Users/dzgygmdhx/3409/21F/ucb/ucb_cs61a_cs61b/cs61a/being/charlie/ding/tools/workspace/from
def iterate_trans_mp3_files(path_from,path_to,endswith):
    for filename in os.listdir(path_from):
        if filename.endswith("."+endswith):
            # print(filename)
            temp = filename.split(".")[0]
            # print(temp)
            trans_audio_with_silence(path_from,temp,path_to)



# iterate_trans_mp3_files("workspace/from/","workspace/to/","mp3")

def split_sound_and_export():
    sound = AudioSegment.from_file("/Users/dzgygmdhx/Desktop/out000.mp3")
    for i, chunk in enumerate(sound[::180000]):
        with open("/Users/dzgygmdhx/Desktop/thepon/sound-%s.mp3" % i,"wb") as f:
            chunk.export(f,format="mp3")


split_sound_and_export()



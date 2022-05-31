from pytube import YouTube

yt = YouTube('https://www.youtube.com/watch?v=kqtD5dpn9C8')

print(yt.captions)
caption = yt.captions.get_by_language_code('a.en')

all = caption.xml_captions

print(all)


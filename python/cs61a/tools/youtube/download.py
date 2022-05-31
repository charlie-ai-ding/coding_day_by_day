from pytube import Playlist
ted='https://www.youtube.com/playlist?list=PLsRNoUx8w3rMTFeDGtWgNB9uwCZ2NXK26';
jimkwik ='https://www.youtube.com/playlist?list=PLwf_ceM-L-lOhmoyl0Qe2O1zLL9qOkBR0'
data8='https://www.youtube.com/watch?v=xcgrnZay9Yc&list=PLFeJ2hV8Fyt7mjvwrDQ2QNYEYdtKSNA0y'
p = Playlist(data8)


print(f'Downlaoding videos by: {p.title}')

for video in p.videos:
    # video.streams.first().download()
    video.streams.get_highest_resolution().download()



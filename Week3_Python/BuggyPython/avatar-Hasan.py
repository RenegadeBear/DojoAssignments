from PIL import Image
from random import randint, getrandbits

def genAvatar(filename):
    rand_img = [[bool(getrandbits(1)) for _ in xrange(5)] for _ in xrange(3)]
    rand_img.append(rand_img[1])
    rand_img.append(rand_img[0])
    im = Image.new('RGB', (5,5), color='white')
    color = randint(0,255), randint(0,255), randint(0,255) 

    for i in xrange(5):
        for j in xrange(5):
            if rand_img[j][i]: 
                im.putpixel((j,i), color)

    im = im.resize((200,200))
    im.save(filename + ".png")
    im.show()

genAvatar("test")
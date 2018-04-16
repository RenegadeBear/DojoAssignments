from PIL import Image
from random import randint, getrandbits



def genAvatar(filename):
	rand_img = [[bool(getrandbits(1)) for _ in range(5)] for _ in range(3)]
	# print (rand_img)
	rand_img.append(rand_img[1])
	# print (rand_img)
	rand_img.append(rand_img[0])
	# print (rand_img)
	color = (randint(0,255), randint(0,255), randint(0,255))
	im = Image.new('RGB', (5,5), color='white')
	print (im)

	for i in range(5):
		for j in range(5):
			if rand_img[j][i]:
				im.putpixel((j,i), color)

	im = im.resize((200,200))
	im.save(filename + ".png")
	im.show()

genAvatar("test")


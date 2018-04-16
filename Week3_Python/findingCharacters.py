# input
word_list = ['hello','world','my','name','is','Anna']
char = 'o'
# output
# new_list = ['hello','world']

def findChar(word_list,char):
	new_list = []
	for i in range(len(word_list)):
		if char in word_list[i]:
			new_list.append(word_list[i])
	print new_list

findChar(word_list,char)

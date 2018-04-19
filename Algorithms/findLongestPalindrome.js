

function longestPalindrome(phrase){
	var temp = ""
	var longest = ""
	for (var i =1, j =1; i < phrase.length-1; i++){
		if (i-j > 0 && i+j < phrase.length){
			if (phrase[i] == phrase[i-j]){
				var temp = phrase[i-j]+str[i]
				// Temp needs to iterate from j back to i each way...
				if (temp.length > longest.length){
					longest = temp;
				}
				j++
			}
			else if (phrase[i -j] == phrase[i+j]){
				// temp = phrase[i]
				// temp = temp.shift("").shift()
				// temp[0] = phrase[i-j]
				// temp.push(phrase[i+j])
				var temp = phrase[i-j] + phrase [i] + phrase[i + j]{
				}
				j++
			}
		}
	}
}
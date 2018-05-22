

function rotateString(str, idx) {
	if(str && idx) {
		idx = idx % str.length;
		for (var i =0; i < idx; i++) {
			str = str[str.length-1] + str.slice(0, str.length-1)
		}
		return str;
	}
	return null;
}

function isRotation(str1, str2) {
	if(str1.length == str2.length) {
		for(var i=0; i<str1.length; i++) {
			if (str1 == str2) {
				return true;
			}
			str2 = rotateString(str2, 1);
		}
	}
	return false;
}

function rRotate(str, idx) {
	if(idx == 0) {
		return str;
	}
	return rRotate((str[str.length-1]+str.slice(0,str.length-1)), idx-1);
}

function rIsRotation(str1, str2) {
	if(str1.length == str2.length) {
		if(str1==str2){
			return true;
		}
		rIsRotation(rRotate(str2, str2.length))
	}
}


//needs work currently returns a1a2a2a1b2b1c1d2d should return a3b2c1d2
function endcode(str) {
	if(str) {
		var newstr = str[0];
		var count = 0;
		var temp = str[0];
		
		for (var i=0; i< str.length; i++) {
			if(str[i] == temp) {
				count += 1;
			}
			newstr = newstr + count + str[i];
			temp = str[i];
			count = 1;
			console.log(newstr, count, temp);
		}
		// if (str.length <= newstr.length) {
		// 	return str;
		// }
		return newstr;
	}
}

console.log(endcode("aaabbcdd"));

function decode(str) {
	if (str.length > 1) {
		var newstr = "";
		var index = 0;
		if (parseInt(str[1]) == NaN) {
			return str;
		}
		function helper(char, times) {
			for(var i=0; i<times; i++) {
				newstr = newstr + char;
			}
			index +=2;
			if (index<= str.length-2) {
				helper(str[index], parseInt(str[index+1]));
			}
			else {
				return newstr;
			}
		}
		helper(str[index], parseInt(str[index+1]));
		return newstr;
	}
	return str;
}

// console.log(decode("a3b2c1d2"));

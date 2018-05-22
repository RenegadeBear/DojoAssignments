// Find arr2 within arr1 and return the index positions of arr2 within arr1
// Acurately finding arrays within arrays, but returning incorrect indices.  Needs further review.

function matrixSearch(arr1,arr2){
    if(arr1 && arr2){
        for(var x=0; x<arr2.length; x++){
            for(var w=0; w<arr1.length;w++){
                var temp1=arr1[w];
                var temp2=arr2[x];
                var find='False'; var found=[];
                for(var y=0; y<temp1.length; y++){ found.push(w,y);
                    if(temp1.length-y >= temp2.length){
                        if(temp1[y]==temp2[0]){
                            for(var a=y+1, z=1; a<temp1.length, z<temp2.length; a++, z++){
                                if(temp1[a]==temp2[z]){

                                }
                                found.push('True');
                            }
                        }

                    }
                }
            }
        }
    }
    return found;
}

arr1 =[[12,34,45,56],[98,87,76,65],[56,67,78,89],[54,43,32,21]];
arr2 =[[67,78],[43,32]];

matrixSearch(arr1,arr2);
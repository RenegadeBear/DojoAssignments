canvas2D = [[3,2,3,4,3],
            [2,3,3,4,0],
            [7,3,3,5,3],
            [6,5,3,4,1],
            [1,2,3,3,3]]

function floodFill(canvas2D, startXY, color) {



    function painter(oldcolor, X, Y) {
        X = startXY[0];
        Y = startXY[1];
        oldcolor = canvas2D[Y][X];

    
        if(canvas2D[Y][X] == oldcolor){
            canvas2D[Y][X] = color;
        }
        console.log("first");
        if(Y-1 >0) {
            if (canvas2D[Y-1][X] == oldcolor) {
                painter(oldcolor, Y-1, X);
            }
        }
        if(X-1 > 0) {
            if (canvas2D[Y][X-1] == oldcolor) {
                painter (oldcolor, Y, X-1);
            }
        }
        if(Y+1 < canvas2D.length) {
            if (canvas2D[Y+1][X] == oldcolor) {
                painter(oldcolor, Y+1, X);
            }
        }
        if(X+1 < canvas2D[0].length) {
            if (canvas2D[Y][X+1] == oldcolor) {
                painter(oldcolor, Y, X+1);
            }
        }
    }
    painter(canvas2D[startXY[1]][startXY[0]], startXY.X, startXY.Y);
    
    return canvas2D;
}

console.log(floodFill(canvas2D, [2,2], 8));
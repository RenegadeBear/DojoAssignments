function BTNode(val) {
    this.val = val;
    this.left = left;
    this.right = right;
}

function BST() {
    this.root = null;
    this.add = function(val) {
        if(!this.root) {
            this.root = new BTNode(val);
            return this;
        }
        else {
            let squirrel = this.root;
            while (squirrel) {
                if (val < squirrel.val) {
                    if (squirrel.left) {
                        squirrel = squirrel.left;
                    }
                    else {
                        squirrel.left = new BTNode(val);
                    }
                }
                else {
                    if (squirrel.right) {
                        squirrel = squirrel.right;
                    }
                    else {
                        squirrel.right = new BTNode(val);
                        return this;
                    }
                }
            }
        }
    }
    this.size = function() {
        let count = 0;
        if (this.root) {
            count ++;
            let squirrel = this.root;
            function nuts(squirrel) {
                if (this.left) {
                    count ++;
                    squirrel = squirrel.left;
                    nuts(squirrel);
                }
                if (this.right) {
                    count ++;
                    squirrel = squirrel.right;
                    nuts(squirrel);
                }
                return count;
            }
            helper(squirrel);
            return count;
        }
    }
    this.height = function() {
        var height = 0;
        var dist = 0;
        if (this.root) {
            height += 1;
            dist += 1;
            var sqrl = this.root;
            function climb(sqrl, dist) {
                if (sqrl.left) {
                    sqrl = sqrl.left;
                    climb(sqrl, dist+1);
                }
                if (sqrl.right) {
                    sqrl = sqrl.right;
                    climb(sqrl, dist+1);
                }
                if (!sqrl.left && !sqrl.right) {
                    if (dist > height) {
                        height = dist;
                    }
                    return hiegh;
                }
            }
            climb(sqrl, dist);
            return height;
        }
    }
}
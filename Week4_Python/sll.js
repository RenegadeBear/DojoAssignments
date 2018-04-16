// class singlies(object):

function Node(val){
    this.val = val;
    this.next = null;
}

function SLL(){
    this.head = null;
    this.add = function(val){
        if(this.head === null){
            this.head = new Node(val);
        }else{
            var runner = this.head;
            while(runner.next !== null){
                runner = runner.next;
                console.log (runner.val)
            }
            runner.next = new Node(val);
            console.log (runner.next.val)
        }
        return this;
    }
    this.removeFront = function(){
        if (this.head != null){
            this.head=this.head.next;
        }
        console.log (this.head.val);
        return this;
    }
    this.length = function() {
        var length = 0;
        if (this.head == null){
            break;
        }
        else if (this.head != null){
            length += 1;
            var runner = this.head;
            while(runner.next!= null){
                length += 1;
                runner = runner.next
            }
        }
        return length;
    }
    this.removeFront = function(){
        if (this.head != null){
            this.head=this.head.next;
        }
        console.log (this.head.val);
        return this;
    }
    this.contains = function(match){
        if (this.head == null){
            return false;
        }
        else if(this.head.val == match){
            return true;
        }
        else if(this.head.value != match){
            var runner = this.head;
            while(runner.next != null){
                if(runner.next.val == match){
                    return true;
                }
                runner = runner.next;
            }
            return False;
        }
    }
    this.removeBack = function(){
        if (this.head == null){
            return this;
        }
        else if (this.head.next != null){
            var runner = this.head;
            while(runner.next.next != null){
                runner = runner.next;
                if (runner.next.next == null){
                    runner.next = runner.next.next;
                    return this;
                }
            }
        }
        this.head = this.head.next;
        return this;
    }
    this.max = function(){
        let max = this.head == nul? null: this.head.val
        // if(this.head == nul){
        // 	return False;
        // }
        // var max = this.head.val;
        var runner = this.head;
        while(runner.next != null){
            if(runner.next.val > max){
                max = runner.next.val;
            }
            runner = runner.next;
        }
        return max;
    }
    this.removeVal = function(yourval){
        if(this.head == null){
            return False
        }
        var count = 0
        while(this.head.val == yourval){
            this.head = this.head.next;
            count += 1;
        }
        var runner = this.head
        while(runner != null) {
            if(runner.val == yourval){
               var runner2 = runner;
                while (runner2.val == value){
                   runner2 = runner2.next;
                count += 1;
                }
            runner = runner2;
            }
            else {
                runner = runner.next;
            }
        }
        print ("As requested ", value, " has been removed from SLL ", count, " times.")
        return this
    }
    this.removeNeg = function(){
        if(this.head == null){
            return False;
        }
        var counter = 0
        while (this.head.val <0){
            this.head = this.head.next;
            counter += 1;
        }
    }
}

var listy = new SLL();
listy.add(2).add(6).add(8).add(10).add(5).add(3).add(12);
console.log(listy);



listy.length();
console.log (length);
listy.removeFront();
console.log(listy);




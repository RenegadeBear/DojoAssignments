<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>2018 FIFA WORLD CUP</title>
    <link rel="stylesheet" type="text/css" href="jquery.bracket.min.css" />
</head>
<body>
    <h1>2018 FIFA WORLD CUP</h1>
    <div class="tournament"></div>
    <script type="text/javascript" src="jquery-1.6.2.min.js"></script>
    <script type="text/javascript" src="jquery.bracket.min.js"></script>
    <script>
        var minData = {
            teams: [
                ["Russia", "Saudi Arabia"],
                ["Portugal", "Spain"],
                ["France", "Australia"],
                ["Argentina", "Iceland"],
                ["Brazil", "Switzerland"],
                ["Germany", "Mexico"],
                ["Belgium", "Panama"],
                ["Poland", "Senegal"]
            ],
            result : [

            ]
        }
        
        // $('.tournament').bracket({
        //     init: minData
        // });

        var saveData = {
            teams: [
                ["Russia", "Saudi Arabia"],
                ["Portugal", "Spain"],
                ["France", "Australia"],
                ["Argentina", "Iceland"],
                ["Brazil", "Switzerland"],
                ["Germany", "Mexico"],
                ["Belgium", "Panama"],
                ["Poland", "Senegal"]
            ],
            results: [
                [[1,0], [null,null],[null,null],[null,null] , [1,0],[null,null],[null,null],[null,null]],
                [[null, null], [null, null], [null, null], [null, null]],
                [[null, null], [null, null]],
                [[null, null], [null, null]]
            ]
        }

        $('.tournament').bracket({
            init: saveData
        });


    </script>
   
</body>
</html>
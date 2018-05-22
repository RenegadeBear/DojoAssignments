<!DOCTYPE html>
<html>
	<head>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<title>Ninja Money</title>
		<style>
			/** {
				margin: 0px auto;
				padding: 0px;
				display: flex;
			}*/
			.places {
				display:flex;
			}
			.place {
				/*display: flex;*/
				border: 1px black solid;
				border-radius: 7px;
				margin: 10px;
				width: 250px;
				text-align: center
				/*padding: 5px;*/
			}
			.header {
				display: flex;
			}
			.yourGold {
				display: flex;
				padding: 0px 5px;
				border: 1px black solid;
				border-radius: 5px
			}
			button {
				margin: 5px;
			}
		</style>
	</head>
	<body>
		<div class = "header">
			<h3>Your Gold:</h3>
			<div class = "yourGold"><p>${yourgold}</p></div>
		</div>
		<div class = "places">
				<div class = "place">
					<h1>Farm</h1>
					<p>(earns 10-20 golds)</p>
                    <form action ="/process_money" method="POST">
                        
                        <input type="hidden" name="place" value="farm">
						<button type = "submit">Find Gold!</button>
					</form>
				</div>
				<div class = "place">
					<h1>Cave</h1>
					<p>(earns 5-10 golds)</p>
                    <form action ="/process_money" method="POST">
                        
						<input type="hidden" name="place" value="cave">
						<button type = "submit">Find Gold!</button>
					</form>
				</div>
				<div class = "place">
					<h1>House</h1>
					<p>(earns 2-5 golds)</p>
                    <form action ="/process_money" method="POST">
                        
						<input type="hidden" name="place" value="house">
						<button type = "submit">Find Gold!</button>
					</form>
				</div>
				<div class = "place">
					<h1>Casino</h1>
					<p>(earns/takes 0-50 golds)</p>
                    <form action ="/process_money" method="POST">
                        
						<input type="hidden" name="place" value="casino">
						<button type = "submit">Find Gold!</button>
					</form>
				</div>
				<div class = "place">
					<h1>Spa</h1>
					<p>(takes 5-20 golds)</p>
                    <form action ="/process_money" method="POST">
                        
						<input type="hidden" name="place" value="spa">
						<button type = "submit">Find Gold!</button>
					</form>
				</div>
			</div>
		<a href ="/reset"><button type=submit>Reset Game</button></a>
		<div class = "activities">
            <h3>Activities:</h3>
            ${log}
 
		</div>


	</body>
</html>
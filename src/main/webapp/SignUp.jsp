<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="zxx">

<head>
<title>Gathering Log In form Responsive Widget Template ::
	W3layouts</title>
<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8" />
<!-- //Meta tag Keywords -->
<link
	href="//fonts.googleapis.com/css2?family=Kumbh+Sans:wght@300;400;700&display=swap"
	rel="stylesheet">
<!--/Style-CSS -->
<link rel="stylesheet" href="css/style.css" type="text/css" media="all" />
<!--//Style-CSS -->
<link rel="stylesheet" href="css/font-awesome.min.css" type="text/css"
	media="all">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
	crossorigin="anonymous"></script>

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-primary">

		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link"
					href="index.jsp"><ul>Home
						</ul> <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link" href="SignUp.jsp">Sign
						Up</a></li>
				<li class="nav-item"><a class="nav-link" href="login.jsp">Log
						In</a></li>
		</div>
		</li>
		</ul>
		</div>
	</nav>
	<div class="w3l-signinform">
		<!-- container -->
		<div class="wrapper">
			<!-- main content -->
			<div class="w3l-form-info">
				<div class="w3_info">
					<h1>Welcome Back</h1>
					<p class="sub-para">Lorem ipsum dolor sit amet, consectetur
						adipiscing elit</p>
					<h2>Sign Up</h2>
					<form action="UserController" method="post">
						<br>
						<div class="input-group ">
							<input type="text" name="first_name" placeholder="First Name"
								required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="text" name="last_name" placeholder="Last Name"
								required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="text" name="mobile" placeholder="Mobile" required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="text" name="gender" placeholder="Gender" required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="text" name="address" placeholder="Address"
								required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="email" name="email" placeholder="Email" required="">
						</div>
						<br>
						<div class="input-group ">
							<input type="Password" name="password" placeholder="Password"
								required=""> <span><i class="fa fa-key"
								aria-hidden="true"></i></span>
						</div>
						<br>
						<div class="input-group ">
							<input type="submit" name="action" value="Register">
						</div>
					</form>

					<p class="account">
						Don't have an account? <a href="SignUp.jsp">Register</a>
					</p>
				</div>
			</div>
			<!-- //main content -->
		</div>
		<!-- //container -->
		<!-- footer -->
		<div class="footer">
			<p>&copy; 2023 Gathering Log In form. All Rights Reserved |
				Design by ::</p>
		</div>
		<!-- footer -->
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>

</html>
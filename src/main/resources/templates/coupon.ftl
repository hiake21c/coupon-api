<!DOCTYPE html>
<html>
<head>
	<title>kakao games Coupon page</title>
	<meta charset="utf-8"/>
	<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
	<meta name="viewport" content="width=device-width, initial-scale=1"/>

	<style type="text/css">
		body {
			background: #ffffff url("/image/bg.png") no-repeat;
			background-size: 350px 506px;
		}
		}

		#name {
			width: 350px;
			text-align: center;
			margin-top: 400px;
		}

		#price {
			width: 350px;
			text-align: center;
			margin-top: 10px;
			font-size: 45px;
			color: black;
		}

		#qrCode {
			margin-left: 75px;
			width: 200px;
			height: 200px;
		}

		#barcode {
			width: 350px;
			height: 100px;
		}
	</style>
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div id="name">
		${name}! Coupon arrived from Kakao!! <br/><br/>
		<p style="font-size:11px;">If you show us the barcode at the point of use, it will be discounted!</p>
	</div>

	<div id="price">
		$${price}
	</div>

	<img id="qrCode" alt="QRCode" src="data:image/png;base64,${qrCode}"/> <br/>
	<img id="barcode" alt="Barcode" src="data:image/png;base64,${barcode}"/>
</body>
</html>

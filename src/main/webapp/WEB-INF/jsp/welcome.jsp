<!DOCTYPE html>
<html ng-app="weatherBureau">
<meta charset="utf-8" />
<head>
<script src="resources/js/angular.min.js"></script>
<script src="resources/js/app.js"></script>
<link href="resources/css/bootstrap.css" rel="stylesheet">
<title>Weather cities demo</title>
</head>
<body ng-controller="WeatherController as weather">

	<div class="container">
		<h4>Weather Information</h4>
		<div style="margin-top: 20px;">
			Select city: <select ng-model="selectedCity"
				ng-options="item.cityId as item.cityName for item in cities"
				ng-change="getWeather()">
				<option value="">Select City</option>
			</select>

		</div>

		<div ng-show="isReady()" class="col-sm-6">
			<table class="table table-bordered" style="margin-top: 20px;">
				<tr>
					<td>City</td>
					<td>{{weather.cityName}}</td>
				</tr>

				<tr>
					<td>Updated Time</td>
					<td>{{dt | date:'EEEE hh:mm a'}}</td>
				</tr>
				
				<tr>
					<td>Weather</td>
					<td>{{weather.currentCondition}}</td>
				</tr>
				
				<tr>
					<td>Temperature</td>
					<td>{{weather.temp}} &deg;C</td>
				</tr>

				<tr>
					<td>Wind</td>
					<td>{{weather.speed}} km/h</td>
				</tr>

			</table>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="css/style.css">
<title>Simulateur Online</title>
</head>
<body>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js" ></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	<script>
	$(document).ready(function(){
		$("#parentTab li:first-child a").tab("show")
		$("#childTab-0 li:first-child a").tab("show")
	
		$("#nav-tabs a").click(function(){
			$(this).tab("show")
		});
	  	$('#parentTab a').on('hide.bs.tab', function(e){
	  		
	  		var ev = e.target.getAttribute("href")
	  		//console.log(ev)
	  		ev = ev.replace("#","")
	  		//console.log(ev)
	  		ev = document.getElementById(ev)
	  		//console.log(ev)
	  		ev = ev.getElementsByTagName("a")
	  		
	  		for(i=0; i < ev.length; i++) {
	  			console.log($(ev[i]))
	  			$(ev[i].hash).removeClass("active show")
	  			$("#"+ev[i].id).removeClass("active show")
	  		}
	  		
	  		var rev = e.relatedTarget.getAttribute("href")
	  		rev = rev.concat(" li:first-child a")
	  		//console.log("------------------------------------"+rev)
	  		$(rev).addClass("active show")
	  		var href = $(rev).attr("href")
	  		$(href).addClass("active show")
	  		
	  		
	  	});
	  	$(".custom-range").on("input change",function(){
	  		console.log("eeeeeeeeeeeeeeeeeeeeeeeeeee")
	  		var childLabel = $(this).parent()[0].children
	  		console.log(childLabel)
	  		$(childLabel[2]).html($(this).val())
	  		
	  		//$("#slider_value").html($(this).val())
	  	})
	  	$("form").submit( function(e){
	  		e.preventDefault()
	  		var form = $(this) 
	  		
	  		var idAjax =  $(this)[0].children[3]
	  		form.attr("action")
	  		$.ajax({
	  			type : 'POST',
	  			url : 'simulation',
	  			data : form.serialize(),
	  			success : function(responseText){
	  				$(idAjax).html(responseText)
	  			}
	  		});
	  	})
	
	});
	  
</script>
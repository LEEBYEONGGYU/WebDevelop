
/* jqueryui modal 관련*/
$(function(){
//	$("#nav_t").click(function(){
//		$("#login_frm").dialog({
//			title:"로그인",
//			width:480,
//			modal:true,
//		});
//	});
	
		$("#datepicker").datepicker({
			 changeYear:true,
			  changeMonth:true
		});
});


//var slideIndex = 0;
//showSlides();

//function showSlides() {
//  var i;
//  var slides = document.getElementsByClassName("mySlides");
//  var dots = document.getElementsByClassName("dot");
//  for (i = 0; i < slides.length; i++) {
//     slides[i].style.display = "none";  
//  }
//  slideIndex++;
//  if (slideIndex > slides.length) {slideIndex = 1}    
//  for (i = 0; i < dots.length; i++) {
//      dots[i].className = dots[i].className.replace(" active", "");
//  }
//  slides[slideIndex-1].style.display = "block";  
//  dots[slideIndex-1].className += " active";
//  setTimeout(showSlides, 1500); // Change image every 2 seconds
//}
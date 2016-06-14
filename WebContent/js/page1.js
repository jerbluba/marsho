$(document).ready(function (){
/*
	$('#page1_1').click(function(){
		$('.paragraph').animate({scrollTop:$('#table0').offset().top-$('#table0').offset().top},800);
	});
	$('#page1_2').click(function(){
		$('.paragraph').animate({scrollTop:$('#table4').offset().top-$('#table0').offset().top},800);
	});
	$('#page1_3').click(function(){
		$('.paragraph').animate({scrollTop:$('#table5').offset().top-$('#table0').offset().top},800);
	});
	$('#page1_4').click(function(){
		$('.paragraph').animate({scrollTop:$('#table6').offset().top-$('#table0').offset().top},800);
	});	


*/

	
	$('.pie_progress').asPieProgress({
		namespace: 'asPieProgress',
		classes: {
		  element: 'pie_progress',
		  number: 'pie_progress__number',
		  content: 'pie_progress__content'
		},
		min: 0,
		max: 100,
		goal: 100,
		size: 160,
		speed: 15, // speed of 1/100
		barcolor: '#ef1e25',
		barsize: '4',
		trackcolor: '#f2f2f2',
		fillcolor: 'none',
		easing: 'ease',
		numberCallback: function(n) {
		  var percentage = Math.round(this.getPercentage(n));
		  if(percentage>=100){
			  $('#invisibleOne').css({'display':'none'});
		  }
		  return percentage + '%';
		},
		contentCallback: null
	});

$('#invisibleOne').css({
'display':'block',
'opacity':'0.8'
});
			$('.pie_progress').asPieProgress('start');
});



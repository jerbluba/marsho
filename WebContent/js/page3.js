function deleteWindow(){			
	$('#showGood').html("").css({
		'display':'none'
		});
		
	$('#invisibleOne').css({
		'opacity':'1',
		'cursor':'auto',
		'display':'none',
	});
	
	$('#closeWindow').css({
		'cursor':'auto',
		'display':'none',
		
	});
				$('.container ').css({
	'position':'relative'
	
	});
			$('.subright ').css({
	'position':'relative'
	
	});
			$('.paragraph ').css({
	'position':'relative'
	
	});
	$(this).attr('class','close');					
			
}



$( document ).ready(function() {
	
	$("#list div").each(function(index){

		$(this).click(function(){
				$("#showGood").html(
					"<iframe id='chaos' src='Viewer2?index="+index+"'/>"
				).css({					
//					'width':500,
//					'height':500,
//					'margin-top':-(height*(4-f)),
//					'margin-left':(width*(l-1))+parseInt($('#main-table').css('margin-left').replace('px','')),
					'display': 'block',
				});
				$('#invisibleOne').html('').css({
					'opacity': '0.9',
					'cursor': 'pointer', 
					'display': 'block',
				});	
				$('.container ').css({
	'position':'static'
	
	});
			$('.subright ').css({
	'position':'static'
	
	});
			$('.paragraph ').css({
	'position':'static'
	
	});
		});
   });	
	$("#invisibleOne").click(function(){
		deleteWindow();	
	});
});   
function goTop(id){
	switch(id){
		case "1":
			$('.paragraph').animate({scrollTop:$('#table0').offset().top-$('#table0').offset().top},800);
		break;
		case "2":
				$('.paragraph').animate({scrollTop:$('#table4').offset().top-$('#table0').offset().top},800);

		break;
		case "3":
		$('.paragraph').animate({scrollTop:$('#table5').offset().top-$('#table0').offset().top},800);

		break;
		case "4":
			$('.paragraph').animate({scrollTop:$('#table6').offset().top-$('#table0').offset().top},800);
	
		break;
	}
}

function getUrlVars(){
      var vars = [], hash;
      var hashes = window.location.href.slice(window.location.href.indexOf('?') + 1).split('&');
   
      for(var i = 0; i < hashes.length; i++){
          hash = hashes[i].split('=');
      hash[1] = unescape(hash[1]);
      vars.push(hash[0]);
          vars[hash[0]] = hash[1];
      }
   
      return vars;
  }
  var urlVars = getUrlVars();
var path = window.location.pathname;
var page = path.split("/").pop();


$(document).ready(function (){


if(console.log( page )!="page1.html"){
	$('#page1_1').click(function(){window.location.assign('page1.html?scroll=1')}); 
	$('#page1_2').click(function(){window.location.assign('page1.html?scroll=2')}); 
	$('#page1_3').click(function(){window.location.assign('page1.html?scroll=3')}); 
	$('#page1_4').click(function(){window.location.assign('page1.html?scroll=4')}); 


}

});


$(window).load(function(){
	goTop(getUrlVars()['scroll']);
});
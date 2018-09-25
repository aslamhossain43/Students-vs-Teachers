//manage active menu
switch (menu) {
case 'About':
	$('#about').addClass('active');
	break;
	
case 'Login':
	$('#login').addClass('active');
	break;
case 'Registration':
	$('#registration').addClass('active');
	break;
	
case 'addme':
	$('#addme').addClass('active');
	break;
	
case 'lookteachers':
	$('#lookteachers').addClass('active');
	break;
case 'manage':
	$('#manage').addClass('active');
	break;

	
default:
	     if (menu='Home') {
			
		$('#home').addClass('active');
	     }
		break;
	
}





//adding a pre loader

var preloader=$('.preLoader');
if (preloader.length) {
	
setTimeout(function(){

	$('.preLoader').fadeOut("slow");
	
},2000);

}


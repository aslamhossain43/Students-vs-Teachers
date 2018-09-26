//manage active menu
switch (menu) {
case 'About':
	$('#about').addClass('active');
	break;
	
case 'Login':
	$('#login').addClass('active');
	break;
case 'Signup':
	$('#signup').addClass('active');
	break;
	
case 'Addme':
	$('#addme').addClass('active');
	break;
	
case 'Look-teachers':
	$('#lookteachers').addClass('active');
	break;
case 'Manage':
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



//alert message
var alert=$('.alert');
if(alert.length){
	setTimeout(function(){
		
		alert.fadeOut("slow");
		
		
	},15000);
	
}




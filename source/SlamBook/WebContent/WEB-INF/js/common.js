function hide_error(element){
		var divElement = element.parent().find('p');
		divElement.empty();
	}
function show_error(element,message){
	var divElement = element.parent().find('p').find('i');
	element.focus();
	divElement.addClass('fa-info-circle');
	divElement.text(message);
	
}
function validateEmail(email){
	var emailRegex = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
	if(!emailRegex.test(email))
		return false;
	else
		return true;

}
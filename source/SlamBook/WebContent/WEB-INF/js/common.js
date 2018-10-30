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

function hide_error(element){
		var divElement = element.find('div');
		divElement.empty();
	}
function show_error(element,message){
	var divElement = element.find('div');
	divElement.text(message);
}
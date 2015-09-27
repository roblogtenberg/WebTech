var opened = false;
var cancelClose = false;


function mopen(id)
{	
	ddmenuitem = document.getElementById(id);

	if(opened) {
		ddmenuitem.style.display = 'none';
		opened = false;
	} else {
		ddmenuitem.style.display = 'block';
		opened = true;
		cancelClose = true;
	}

}

window.onresize = function() {
	if(window.innerWidth >= 520) {
		ddmenuitem.style.display = 'block';
	} else {
		ddmenuitem.style.display = 'none';
	}
};

document.onclick = function() {
	if(opened && !cancelClose) {
		ddmenuitem.style.display = 'none';
		opened = false;
	}

	cancelClose = false;
};

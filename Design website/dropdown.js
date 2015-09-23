var opened = false;
// close layer when click-out
// this causes the menu to never open!! fix this shit!
// document.onclick = mclose;

// open hidden layer
function mopen(id)
{	
	// get new layer and show it
	ddmenuitem = document.getElementById(id);

	if(opened) {
		ddmenuitem.style.visibility = 'hidden';
		opened = false;
	} else {
		ddmenuitem.style.visibility = 'visible';
		opened = true;
	}

}
// close showed layer
function mclose()
{
	if(ddmenuitem) ddmenuitem.style.visibility = 'hidden';
}
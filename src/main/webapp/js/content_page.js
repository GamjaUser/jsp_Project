/**
 * 
 */
 
 function isShowDiv(loc){
		document.all.subcontainer1.style.display = 'block';
		document.all.subcontainer2.style.display = 'none';
		switch(loc){
		case 'freeBoard':
			document.all.subcontainer1.style.display = 'block';
			document.all.subcontainer2.style.display = 'none';
			break;
		case 'reviewBoard':
			document.all.subcontainer1.style.display = 'none';
			document.all.subcontainer2.style.display = 'block';
			break;
		case 'QABoard':
			document.all.subcontainer1.style.display = 'block';
			document.all.subcontainer2.style.display = 'none';
			break;
		}
			
	}
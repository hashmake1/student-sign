function goto(url){
    window.location.href=url;
}
        
function getIpUrl(){
	var start = window.location.href.indexOf("//");
	var end = window.location.href.indexOf("8080");
	console.log(window.location.href.slice(0,end+4));
	if(window.location.href.toUpperCase().indexOf("HTTP") != -1){
    	return window.location.href.slice(0,end+4);
	}else{
    	return "http://"+ window.location.href.slice(0,end+4);
	}
}


(function (doc, win) {
    var docEl = doc.documentElement,
      resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
      recalc = function () {
        var clientWidth = docEl.clientWidth;
        if (!clientWidth) return;
        docEl.style.fontSize = 20 * (clientWidth / 320) + 'px';
      };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
 })(document, window);


function pageTransfer(o1){
	window.location.href= getIpUrl() + "/redirectPage?pagename=" + o1 ;
}

function goto(o1){
	window.location.href= getIpUrl() + "/redirectPage?pagename=" + o1 ;
}
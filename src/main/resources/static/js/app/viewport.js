var viewport_meta = document.getElementById('viewport-meta');

var viewports = {
    default: viewport_meta.getAttribute('content'),
    landscape: 'width=990'
};

var viewport_set = function(){
    if(screen.width > 768)
        viewport_meta.setAttribute('content', viewports.landscape);
    else
        viewport_meta.setAttribute('content', viewports.default);
}

viewport_set();

window.onresize = function() {
    viewport_set();
}
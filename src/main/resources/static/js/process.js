$(() => {
    var links =document.getElementsByTagName("a");
    $.each(links, function(index, value) {
        var dataValue = value.getAttribute('data-value');
        if (dataValue === 'false') {
            links[index].style.pointerEvents = "none";
            links[index].style.color = "gray";
        }
    })
})
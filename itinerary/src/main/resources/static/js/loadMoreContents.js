function loadMore(id) {
    $.ajax({
        url: 'https://localhost:8443/units/{{id}}/contents/?page=1&size=3'
    }).done(function (items) {
        
    })
}
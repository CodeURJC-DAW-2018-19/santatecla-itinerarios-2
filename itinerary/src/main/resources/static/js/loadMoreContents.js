var nextPage = 1;
function loadMore(button, id) {
    $.ajax({
        url: "/units/" + id + "/contents/list/?page=" + nextPage,
    }).done(function (contentsList) {
        $(button).replaceWith(contentsList);
        nextPage++;
    });
}
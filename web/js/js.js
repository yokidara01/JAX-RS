
$(document).ready(function(){
    var rootURL = "http://localhost:8080/rest/livre";
        $("#btnDelete").hide();





$('#btnDelete').hide();

var current;
//initialement le bouton delete est invisible


//rechercher tous les types locaux au démarrage de l'application
findAll();
});


function findAll() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rest/livre"+"/getAll",
        dataType: "json",
        cache: false,
        contentType: "application/json",
        success: function(data) {

           // $('#folio').html("<ul/>");
            $.each(data.posts, function(i,post){
                $('#tl_list ul').append('<li>post.titre</li>');
            });
        },
        error: function(xhr, status, error) {
            alert(xhr.status);
        }
    });









  /*  $.ajax({
        type: 'GET',
        url: "http://localhost:8080/rest/livre"+"/getAll",
        dataType:  "json",  //"text" // type de la réponse

        success:renderList,
        error: function(jqXHR, textStatus, errorThrown){
            alert('error'+textStatus);
        }
    });*/
}

function renderList(data) {
    console.log(data);
    var list_tl = data;

    $('#tl_list li').remove();
    $('#tl_list').append('<li><a href="#">ghgh</a></li>');
    alert(data);
    /*$.each(list_tl, function(index, tl) {

        $('#tl_list').append('<li><a href="#">ghgh</a></li>');
    });*/

}


//click  sur le bouton rechercher
$('#btnSearch').click(
    function() {
        search($('#searchKey').val());
        return false;
    });

function search(searchKey) {
    if (searchKey == '')
        findAll();
    else
        findByName(searchKey);
}

function findByName(searchKey) {

    $.ajax({
        type: 'GET',
        url: rootURL + '/search/' + searchKey,
        dataType: "json",
        success: renderList
    });
}

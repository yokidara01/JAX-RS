
$(document).ready(function(){
    var rootURL = "http://localhost:8080/rest/livre";
        $("#btnDelete").hide();





$('#btnDelete').hide();

var current;
//initialement le bouton delete est invisible


//rechercher tous les types locaux au démarrage de l'application
findAll();
});



$('#btnSearch').click(
    function() {

        search($('#searchKey').val());

        return false;
    });

function findAll() {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rest/livre/getAll",
        dataType: "xml",
        cache: false,

        success:renderList,

        error: function(xhr, status, error) {
            alert(xhr.status);
        }
    });
}

    function renderList(xml) {
        // JAX-RS serializes an empty list as null, and a 'collection of one' as an object (not an 'array of one')
        $('#tl_list li').remove();
        {
            var  isbn= "";

            $(xml).find('livre').each(function () {
                isbn=$(this).find('isbn').text();
                $('#tl_List').append('<li><a href="#" data-identity="' + $(this).find('isbn').text() +'">'+$(this).find('titre').text()+'</a></li>');

            });



        }
    }





function search() {
     var searchKey = document.getElementById("searchKey").value;


    if (searchKey == '')
        findAll();
    else
        findByName(searchKey);
}

function findByName(searchKey) {

    $.ajax({
        type: "GET",
        url: "http://localhost:8080/rest/livre/search/isbn-"+searchKey,
        dataType: "xml",
        cache: false,

        success:renderList,

        error: function(xhr, status, error) {
            alert(xhr.status);
        }
    });



}


function callSave() {





    var titre,auteur,isbn;
    titre = document.getElementById("titre").value;
    isbn= document.getElementById("isbn").value;
    auteur= document.getElementById("auteur").value;
    var data ='{"isbn": "'+isbn+'","titre": "'+titre+'", "auteur":"'+auteur+'" }';





    $.ajax({
        type: 'POST',
        url: "http://localhost:8080/rest/livre/post",
        dataType : "json",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(data),
        success: findAll(),
        error: function() {
            alert("");
        }
    });

}





function save()
{

    callSave() ;

}

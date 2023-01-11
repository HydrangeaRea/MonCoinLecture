/* Dans ce document seront le code pour :
Le header, le footer, la nav barre et l'aside membre
comme ça on a à le coder une seule fois
*/

$.get("head.html", function (data) {
    $(".head-placeholder").replaceWith(data);
});

$.get("membre.html", function (data) {
    $(".membre-placeholder").replaceWith(data);
});

let data2 = {pseudo: sessionStorage.getItem('pseudo')};

$.ajax({
            type: "POST",
            headers: {"Content-Type": "application/JSON"},
            url: "http://localhost:8080/API/mesInformations",
            data: JSON.stringify(data2),
            success: function(resultat) {
              console.log(resultat.pseudo);
              $('.pseudo-membre').html(resultat.pseudo);
              $('.date-inscription').html("Inscrit depuis le : <br>"+resultat.dateInscription);
              $('.descript').html("Ma description : <br>"+resultat.description);
              $('.auteur-fav').html("Auteur favori : <br>"+resultat.auteurFavori);
              $('.livre-fav').html("Livre favori : <br>"+resultat.livreFavori);
            }
            });
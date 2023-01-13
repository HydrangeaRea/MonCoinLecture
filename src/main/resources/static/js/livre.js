var val = document.URL;
start = val.search(/ouvrage=/);
var end;
end = val.search(/&/);
var thispos = val.substring(start + 8, end);
let newString = thispos.replaceAll('%20', ' ');
let finalString = newString.replaceAll('%27',' ');

$.post("http://localhost:8080/API/AffichageLivresRecherchesTitre/" + newString, function (retour) {
    let nombre = retour.length;
    let nb = nombre;
    console.log(retour);
   if (localStorage.idLivre == null) {
        localStorage.idLivre = retour[(0)].id;
        console.log(localStorage.idLivre);
    } else {
        localStorage.clear();
        console.log(localStorage.idLivre);
        localStorage.idLivre = retour[(0)].id;
    }
    $("#titre").html(retour[(0)].titre);
    $("#auteur-livre").html(retour[(0)].auteur);
    $("#illustrateur").html(retour[(0)].illustrateur);
    $("#couverture").attr("src", retour[(0)].couverture);
    $("#type").html(retour[(0)].genre);
    $("#type1").html(retour[(0)].type);
    $("#editeur").html(retour[(0)].editeur);
    $("#date_de_sortie").html(retour[(0)].datePubli);
    $("#avancement").html(retour[(0)].avancement);
    $("#serie-livre").html(retour[(0)].titreSerie);
    $("#volume").html(retour[(0)].volume);
    $("#resume").html(retour[(0)].resume);
});

    function ajouterAMaListe(){
    let data= {titre : document.getElementById("titre"), auteur : document.getElementById("auteur-livre")}
    $.ajax({
    type: "POST",
    headers: {"Content-Type": "application/JSON"},
    url: "http://localhost:8080/API/AffichageLivresRecherchesTitre/"+newString,
            data: JSON.stringify(data),
    success: function(resultat) {
    console.log("data="+data);
    console.log("stringify="+JSON.stringify(data));
        sessionStorage.auteur= $('#auteur-livre').val();
    }
    });
}
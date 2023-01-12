var val = document.URL;
start = val.search(/ouvrage=/);
var end;
end = val.search(/&/);
var thispos = val.substring(start + 8, end);
let newString = thispos.replaceAll('%20', ' ');
$.post("http://localhost:8080/API/AffichageLivresRecherchesTitre/" + newString, function (retour) {
    let nombre = retour.length;
    let nb = nombre;

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
    $("#type").html(retour[(0)].genre);
    $("#type1").html(retour[(0)].type);
    $("#editeur").html(retour[(0)].editeur);
    $("#date_de_sortie").html(retour[(0)].datePubli);
    $("#avancement").html(retour[(0)].avancement);
    $("#serie-livre").html(retour[(0)].titreSerie);
    $("#volume").html(retour[(0)].volume);
    $("#resume").html(retour[(0)].resume);
});

var val = document.URL;
start = val.search(/ouvrage=/);
var end;
end = val.search(/&/);
var thispos = val.substring(start + 8, end);
let string1 = thispos.replaceAll('%20', ' ');
let string2 = string1.replaceAll('%27','\'');
let string3 = string2.replaceAll('%29','\'');

$.post("http://localhost:8080/API/AffichageLivresRecherchesTitre/" +string3, function (retour) {
    let nombre = retour.length;
    let nb = nombre;
    console.log(retour);
   if (localStorage.idLivre == null) {
        localStorage.idLivre = retour[(0)].id;
        console.log("id livre ="+localStorage.idLivre);
    } else {
        localStorage.clear();
        localStorage.idLivre = retour[(0)].id;
                console.log("id livre ="+localStorage.idLivre);
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

$.get("http://localhost:8080/API/voirTousLesAvisParLivre/"+localStorage.idLivre, function (retour) {
console.log("etape1= OK");
    let nombre = retour.length;
    let nb=nombre;

    console.log("retour="+retour.length);
    if (nombre ==0){
    liste_vide.innerHTML= "Soyez le premier à donner votre avis!"
    document.getElementById("tableau").style.display="none";
    }
    else{
    $('#liste_vide').html("Voici les avis de notre communauté :")
    for (let i = 0; i < nombre; i++){
        $("#id"+i).after(
            "<tr id='id"+(i+1)+"'><td id='pseudo"+(i+1)+"'>"+(i+1)+"</td>"+
        '<td id="note'+(i+1)+'"></td>'+
        '<td id="commentaire'+(i+1)+'"></td>'+
        '<td id="avancement'+(i+1)+'"></td>'
)
};
    for(let i = 1; i <= nombre; i++){
        console.log(retour[i-1].note);
        $("#pseudo"+i).html(retour[(i-1)].utilisateur.pseudo);
        $("#note"+i).html(retour[(i-1)].note);
        $("#commentaire"+i).html(retour[(i-1)].commentaire);
        $("#avancement"+i).html(retour[(i-1)].avancement);
    }};
})
let data = {pseudo: sessionStorage.pseudo};
$.ajax({
    type: "POST",
    headers: {"Content-Type": "application/JSON"},
    url: "http://localhost:8080/API/mesInformations",
    data: JSON.stringify(data),
    success: function(resultat) {
      console.log("resultat id="+resultat.id);
      $('#input_pseudo').val(resultat.id);
      localStorage.idMembre = resultat.id;

    }
});
$('#input_nom_livre').val(localStorage.idLivre);

function getValue() {
    var input_nom_membre = document.getElementById("input_pseudo").value;
    var input_nom_livre = document.getElementById("input_nom_livre").value;
    var a=document.getElementById("avancement");
    var input_avancement = a.options[a.selectedIndex].text;
    var n=document.getElementById("note");
    var input_note = n.options[n.selectedIndex].text;
    var input_commentaire= document.getElementById("input_commentaire").value;

    console.log("membre=" + input_nom_membre);
    console.log("livre=" + input_nom_livre);

if(sessionStorage.pseudo == null){
    $('#messageAvis').html("Vous devez être inscrit sur MonCoinLecture pour déposer un commentaire.")
}
else{
    if (input_note != 0 && input_note != 1 && input_note != 2 && input_note != 3 && input_note != 4 && input_note != 5){
    input_note = null;}
let avis1= {avancement: input_avancement, commentaire: input_commentaire, livre: {id: input_nom_livre}, utilisateur: {id: input_nom_membre}, note: input_note}

    $.ajax({
        type: "POST",
        headers: { "Content-type": "application/JSON" },
        url: "http://localhost:8080/API/Avis",
        data: JSON.stringify(avis1),
        success: function(resultat) {
            $('#messageAvis').html(resultat);
            console.log(JSON.stringify(avis1));
        }
    })
    }
};
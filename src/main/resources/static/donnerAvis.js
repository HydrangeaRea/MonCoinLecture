function getValue() {
    var input_nom_membre = document.getElementById("input_nom_membre").value;
    var input_nom_livre = document.getElementById("input_nom_livre").value;
    var a=document.getElementById("avancement");
    var input_avancement = a.options[a.selectedIndex].text;
    var n=document.getElementById("note");
    var input_note = n.options[n.selectedIndex].text;
    var input_commentaire= document.getElementById("input_commentaire").value;
    var input_suggestion_livre = document.getElementById("input_suggestion_livre").value;

if(input_nom_membre != ""){
    alert("Vous devez être inscrit sur LeCoinLecture pour déposer un commentaire.")
}
else{
    if (input_note != 0 && input_note != 1 && input_note != 2 && input_note != 3 && input_note != 4 && input_note != 5){
    input_note = null;
let avis1= {avancement: input_avancement, commentaire: input_commentaire, id_livre: input_nom_livre, id_livre_suggestion: input_suggestion_livre, id_utilisateur: input_nom_membre, note: input_note}

    $.ajax({
        type: "POST",
        headers: { "Content-type": "application/JSON" },
        url: "http://localhost:8080/API/Avis",
        data: JSON.stringify(avis1),
        success: function(resultat) {
            alert(resultat);
            console.log(JSON.stringify(avis1));
        }
    })
    }
};
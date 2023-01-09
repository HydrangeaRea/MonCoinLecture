function getValue() {
    var input_nom_membre = document.getElementById("input_nom_membre").value;
    var input_nom_livre = document.getElementById("input_nom_livre").value;
    var input_avancement = document.getElementById("avancement").value;
    var input_note = document.getElementById("note").value;
    var input_commentaire= document.getElementById("input_commentaire").value;
    var input_suggestion_livre = document.getElementById("input_suggestion_livre").value;
console.log(input_note);
console.log(input_avancement);
console.log(input_commentaire);
console.log(input_suggestion_livre);


    let avis1= {avancement: avancement, commentaire: input_commentaire, id_livre: input_nom_livre, id_livre_suggestion: input_suggestion_livre, id_utilisateur: input_nom_membre, note: input_note}
    $.ajax({
        type: "POST",
        headers: {"Content-type" : "application/json"},
        url: "http://localhost:8080/API/ajouterAvis",
        data: JSON.stringify(avis1),
        success: function(avis1) {
            alert("L'API m'a retourné "+ avis1);
            console.log(avis1);
        }
    });
}


$.get("http://localhost:8080/API/voirTousLesAvis/"+sessionStorage.pseudo, function (retour) {
    let nombre = retour.length;

    let nb = nombre;

    //Création des lignes
    for (let i = 0; i < nombre; i++) {
        $("#listeid" + i).after(
            "<tr id='listeid"+(i+1)+"'><td id='idlivre"+(i+1)+"'>"+(i+1)+"</td>"+
            '<td id="couverture-liste-livre'+(i+1)+'"><img src="css/date-a-live-vol-3.webp" id="miniature-couverture'+(i+1)+'" class="miniature-couverture" /></td>' +
            '<td id="titre-livre'+(i+1)+'">Titre du livre</td>' +
            '<td id="avancement-livre'+(i+1)+'">lu</td>' +
            '<td id="avis'+(i+1)+'">5/5</td>' +
            '<td id="commentaire'+(i+1)+'"> <button class="afficher-commentaire">Commentaire</button><br>' +
            '<button id="bouton-livre'+(i+1)+'">Fiche du livre</button><br>' +
            '<button id="bouton-suggestion'+(i+1)+'">Suggestions</button></td></tr>'

        )
    };

    //Remplissage des lignes
    for (let i = 1; i <= nombre; i++) {
        console.log(retour[i - 1].id);
        console.log(retour[i-1])
        $("#couverture-liste-livre" + i).attr('src', retour[(i - 1)].couverture); //Je trouve pas l'erreur
        $("#titre-livre" + i).html(retour[(i - 1)].livre.titre);
        $("#avancement-livre" + i).html(retour[(i - 1)].avancement);
        $("#avis" + i).html(retour[(i - 1)].note+"/5");
        

    }; 

});
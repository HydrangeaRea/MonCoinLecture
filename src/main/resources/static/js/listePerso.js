console.log("http://localhost:8080/API/voirTousLesAvis/"+sessionStorage.pseudo);

$.get("http://localhost:8080/API/voirTousLesAvis/"+sessionStorage.pseudo, function (retour) {
    let nombre = retour.length;

    let nb = nombre;
console.log(retour);
    //Création des lignes
    for (let i = 0; i < nombre; i++) {
        $("#listeid" + i).after(
            "<tr id='listeid"+(i+1)+"'><td id='idlivre"+(i+1)+"'>"+(i+1)+"</td>"+
            '<td id="couverture-liste-livre'+(i+1)+'"><img src="css/date-a-live-vol-3.webp" id="miniature-couverture'+(i+1)+'" class="miniature-couverture" /></td>' +
            '<td id="titre-livre'+(i+1)+'">Titre du livre</td>' +
            '<td id="avancement-livre'+(i+1)+'">lu</td>' +
            '<td id="avis'+(i+1)+'">5/5</td>' +
            '<td id="commentaire'+(i+1)+'">Mon commentaire</td>' +
            '<td><button id="bouton-livre'+(i+1)+'">Fiche du livre</button><br>'

        )
    };

    //Remplissage des lignes
    for (let i = 1; i <= nombre; i++) {
        console.log("id");
        console.log(retour[i - 1].id);
        console.log("retour");
        console.log(retour[i-1])
        $("#miniature-couverture" + i).attr("src", retour[(i - 1)].livre.couverture); //Je trouve pas l'erreur
        $("#titre-livre" + i).html(retour[(i - 1)].livre.titre);
        $("#avancement-livre" + i).html(retour[(i - 1)].avancement);
        $("#avis" + i).html(retour[(i - 1)].note+"/5");
        $("#commentaire" + i).html(retour[(i - 1)].commentaire);
        $("#bouton-livre" + i).html('<a href="livre.html?ouvrage='+retour[(i-1)].livre.titre+'&">Fiche du livre</a>');

    }; 

});
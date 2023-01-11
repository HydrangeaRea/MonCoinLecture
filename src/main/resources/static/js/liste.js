$.get("http://localhost:8080/API/voirTousLesLivres", function (retour) {
    let nombre = retour.length;

    let nb=nombre;

//Création des lignes
    for (let i = 0; i < nombre; i++){
        $("#id"+i).after(
            "<tr id='id"+(i+1)+"'><td id='idlivre"+(i+1)+"'>"+(i+1)+"</td>"+
        '<td id="couverture-liste'+(i+1)+'"><img src="css/date-a-live-vol-3.webp" class="miniature-couverture id="couverture'+(i+1)+'" /></td>'+
        '<td id="titre-livre'+(i+1)+'">Titre du livre</td>'+
        '<td id="auteur'+(i+1)+'">auteur</td>'+
        '<td id="illustrateur'+(i+1)+'">illustrateur</td>'+
        '<td id="genre'+(i+1)+'">genre</td>'+
        '<td id="type'+(i+1)+'">type</td>'+
        '<td id="info'+(i+1)+'"> <button id="afficher-info'+(i+1)+'">Info</button></td></tr>');
    };

//Remplissage des lignes
    for(let i = 1; i <= nombre; i++){
        console.log(retour[i-1].id);
        $("#idlivre"+i).html(retour[(i-1)].id);
        $("#couverture"+i).attr('src', retour[(i-1)].couverture); //Je trouve pas l'erreur
        $("#titre-livre"+i).html(retour[(i-1)].titre);
        $("#auteur"+i).html(retour[(i-1)].auteur);
        $("#illustrateur"+i).html(retour[(i-1)].illustrateur);
        $("#genre"+i).html(retour[(i-1)].genre);
        $("#type"+i).html(retour[(i-1)].type);
        $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="/voirLeLivre/'+retour[(i-1)].titre+'">Info</a></button></td></tr>'); //Mettre lien info

    };
        
});
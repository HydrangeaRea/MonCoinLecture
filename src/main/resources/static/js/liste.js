var liste_vide = document.getElementById("liste_vide");

var val = document.URL;
start = val.search(/recherche=/);
var end;
end = val.search(/&/);
var thispos = val.substring(start + 10, end);
console.log("val= " + val);
console.log("thispos= " + thispos);
let string1 = thispos.replaceAll('%20',' ');
let newString = string1.replaceAll('+', ' ');
console.log("newString= " + newString);

  $(document).ready(function() {
    if (window.location.href.indexOf("Titre") > -1) {
$.post("http://localhost:8080/API/AffichageLivresRecherchesTitre/"+newString, function (retour) {
    let nombre = retour.length;
    let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    document.getElementById("tableau").style.display="none";
    }
    else{
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

    for(let i = 1; i <= nombre; i++){
        console.log(retour[i-1].couverture);
        $("#idlivre"+i).html(retour[(i-1)].id);
        $("#couverture"+i).attr('src'+retour[(i-1)].couverture); //Je trouve pas l'erreur
        $("#titre-livre"+i).html(retour[(i-1)].titre);
        $("#auteur"+i).html(retour[(i-1)].auteur);
        $("#illustrateur"+i).html(retour[(i-1)].illustrateur);
        $("#genre"+i).html(retour[(i-1)].genre);
        $("#type"+i).html(retour[(i-1)].type);
        $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info

    };
}
})
    }
    else if (window.location.href.indexOf("Auteur") > -1) {
$.post("http://localhost:8080/API/AffichageLivresRecherchesAuteur/"+newString, function (retour) {
    let nombre = retour.length;
    let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    }
    else{
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
        $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info

    };
}
})
    }
    else if (window.location.href.indexOf("Illustrateur") > -1) {
$.post("http://localhost:8080/API/AffichageLivresRecherchesIllustrateur/"+newString, function (retour) {
    let nombre = retour.length;
    let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    }
    else{
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
        $("#couverture"+i).attr('src=', retour[(i-1)].couverture); //Je trouve pas l'erreur
        $("#titre-livre"+i).html(retour[(i-1)].titre);
        $("#auteur"+i).html(retour[(i-1)].auteur);
        $("#illustrateur"+i).html(retour[(i-1)].illustrateur);
        $("#genre"+i).html(retour[(i-1)].genre);
        $("#type"+i).html(retour[(i-1)].type);
        $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info

    };
}
})
    }
    else if (window.location.href.indexOf("Roman") > -1) {
    $.post("http://localhost:8080/API/AffichageLivresRecherchesType/"+newString, function (retour) {
        let nombre = retour.length;
        let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    }
    else{
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
            $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info
        };
        }
    })}
    else if (window.location.href.indexOf("Manga") > -1) {
    $.post("http://localhost:8080/API/AffichageLivresRecherchesType/"+newString, function (retour) {
        let nombre = retour.length;
        let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    }
    else{
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
            '<td id="info'+(i+1)+'"> <button id="afficher-info'+(i+1)+'"></button></td></tr>');
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
            $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info

        };
}
    })}
    else if (window.location.href.indexOf("BD") > -1) {
    $.post("http://localhost:8080/API/AffichageLivresRecherchesType/"+newString, function (retour) {
        let nombre = retour.length;
        let nb=nombre;
    if (nombre ==0){
    liste_vide.innerHTML= "Désolé, aucun ouvrage ne correspond à votre recherche..."
    }
    else{
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
            $("#info"+i).html('<td id="info'+(i)+'"> <button id="afficher-info'+(i)+'"><a href="livre.html?ouvrage='+retour[(i-1)].titre+'&">Info</a></button></td></tr>'); //Mettre lien info
        };
        }
    })}
});
/* Dans ce document seront le code pour :
Le header, le footer, la nav barre et l'aside membre
comme ça on a à le coder une seule fois
*/

$(".head-placeholder").replaceWith(data);



$(".membre-placeholder").replaceWith(data);


let data2 = {pseudo: sessionStorage.getItem('pseudo')};
console.log(data2);
alert("cucou");
        $.ajax({
            type: "POST",
            headers: {"Content-Type": "application/JSON"},
            url: "http://localhost:8080/API/mesInformations",
            data: JSON.stringify(data),
            success: function(resultat) {
                console.log(resultat.pseudo);
              $('.pseudo-membre').html(resultat.pseudo);
            }
            });
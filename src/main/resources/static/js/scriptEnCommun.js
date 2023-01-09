/* Dans ce document seront le code pour :
Le header, le footer, la nav barre et l'aside membre
comme ça on a à le coder une seule fois
*/

$.get("head.html", function (data) {
    $(".head-placeholder").replaceWith(data);
});

$.get("membre.html", function (data) {
    $(".membre-placeholder").replaceWith(data);
});
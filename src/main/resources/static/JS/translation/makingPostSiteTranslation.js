const translations = {}
document.addEventListener("DOMContentLoaded", function (){
    fetch("/api/makingPost/language", {
        method: 'GET',
        headers: {
            'used-language' : navigator.language
        }

    })
        .then(response => response.json())
        .then(data => {
            document.querySelector('label[for="postTitle"]').textContent = data.title;
            document.querySelector('label[for="postDescription"]').textContent = data.description;
            document.querySelector('label[for="addMapName"]').textContent = data.mapName;
            document.querySelector('label[for="addMapImg"]').textContent = data.map;
        })
        .catch(error => console.error('Error:', error));

})
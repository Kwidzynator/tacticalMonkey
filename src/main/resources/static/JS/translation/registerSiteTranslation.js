document.addEventListener("DOMContentLoaded", function(){
    fetch("/api/register/language", {
        method: 'GET',
        headers: {
            'used-language': navigator.language
        }
    })
        .then(response => response.json())
        .then(data => {
            console.log(data);
            document.querySelector('label[for="RegisterUsername"]').textContent = data.username;
            document.querySelector('label[for="RegisterPasswd"]').textContent = data.password;
            document.querySelector('label[for="RegisterEmail"]').textContent = data.email;
            document.querySelector('#registerSubmit').textContent = data.sbmit;
            document.querySelector('#registerLogin').textContent = data.login;
            }
        ).catch(() => console.error("something might be empty"))



});
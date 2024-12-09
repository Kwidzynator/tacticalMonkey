document.addEventListener("DOMContentLoaded", function() {
    fetch("/api/login/language", {
        method: 'GET',
        headers: {
            'used-language': navigator.language
        }
    })
        .then(response => response.json())
        .then(data => {
            document.querySelector('label[for="loginUsername"]').textContent = data.username;
            document.querySelector('label[for="loginPasswd"]').textContent = data.password;
            document.querySelector('#loginSubmit').textContent = data.sbmit;
            document.querySelector('#loginRegister').textContent = data.register;
        })
        .catch(error => console.error('Error:', error));
});
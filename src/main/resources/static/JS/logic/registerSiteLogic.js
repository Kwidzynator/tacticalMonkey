import {getCookie, getCsrfToken, getCsrfHeader } from './csrfToken.js';
document.getElementById("registerSubmit").addEventListener('click', async function(event) {
    event.preventDefault()
    let username = document.getElementById('RegisterUsername').value
    let email = document.getElementById('RegisterEmail').value
    let passwd = document.getElementById('RegisterPasswd').value

    try {
        const response = await fetch("/api/register/createAcc", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': getCsrfToken()
            },
            body: JSON.stringify({ username: username, email: email, password: passwd })
        });
        window.location.href = "http://127.0.0.1:8080/login";
        const data = await response.json();
        console.log("register successful:", data);
    } catch (error) {
        console.error("issue", error);
    }



})

document.getElementById("registerLogin").addEventListener('click', function(event){
    event.preventDefault()
    window.location.href = "http://127.0.0.1:8080/login"
})
import {getCookie, getCsrfToken, getCsrfHeader } from './csrfToken.js';
document.getElementById("loginSubmit").addEventListener('click', async function(event) {
    event.preventDefault();

    let username = document.getElementById("loginUsername").value;
    let passwd = document.getElementById("loginPasswd").value;


    try {
        const response = await fetch("/api/login/loginInto", {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({ username: username, password: passwd })
        });
        if (response.ok) {
            const data = await response.json();
            window.location.href = "http://127.0.0.1:8080/"
            console.log("Login successful:", data);
        } else {
            console.log("Login failed:", response.statusText);
        }
    } catch (error) {
        console.error("issue", error);
    }
});


document.getElementById("loginRegister").addEventListener('click', function(event){
    event.preventDefault()
    window.location.href = "http://127.0.0.1:8080/register"
})
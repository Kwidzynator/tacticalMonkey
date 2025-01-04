export function getCookie(name) {
    const value = `; ${document.cookie}`;
    const parts = value.split(`; ${name}=`);
    if (parts.length === 2) return parts.pop().split(';').shift();
    return null;
}

// Adjusted CSRF token functions to use correct cookie names
export function getCsrfToken() {
    return getCookie('csrftoken'); // Correct cookie name for CSRF token
}

export function getCsrfHeader() {
    return getCookie('XSRF-TOKEN'); // Correct cookie name for CSRF header
}
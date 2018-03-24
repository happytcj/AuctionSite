/**
 * Created by Steph on 2/24/2018.
 */
function verifyFields() {
    var username = document.getElementById('txtUsername').value;
    var pass = document.getElementById('txtPass').value;
    var message = '';
    if (username === '') {
        message = 'Please fill in Username field.\n';
    }
    if (pass === '') {
        message += 'Please fill in Password field.\n';
    }
    if (message !== '') {
        alert(message);
        return false;
    }
    return true;
}
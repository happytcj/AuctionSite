/**
 * Created by TJ on 3/28/2018.
 */
function verifyRegisterFields() {
    var username = document.getElementById('txtUsername').value;
    var pass = document.getElementById('txtPass').value;
    var confirm_pass = document.getElementById('txtConfirmpass').value;
    var firstname = document.getElementById('txtFirstname').value;
    var lastname = document.getElementById('txtLastname').value;
    var message = '';
    if (username === '') {
        message = 'Please fill in User Name field.\n';
    }
    if (pass === '') {
        message += 'Please fill in Password field.\n';
    }
    if (confirm_pass === '') {
        message += 'Please fill in Confirm Password field.\n';
    }
    if (firstname === '') {
        message = 'Please fill in First Name field.\n';
    }
    if (lastname === '') {
        message += 'Please fill in Last Name field.\n';
    }
    if (pass !== confirm_pass) {
        message += 'Please check that Password and Confirm Password are the same.\n';
    }
    if (message !== '') {
        alert(message);
        return false;
    }
    return true;
}
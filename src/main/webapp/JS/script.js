$(document).ready(function(){
    let inputMail = document.getElementById("emailLog");
    let inputPwd = document.getElementById("pwdLog");
    let button = document.getElementById("btnConnect");
    
    let valBool = false;
    let valBool1 = false;
    
    button.disabled = true;
    
    inputMail.addEventListener("keyup", function(){
        if(this.value === ""){
            valBool = false;
            checkInput();
        }else{
            valBool = true;
            checkInput();
        }
    }, false);

    inputPwd.addEventListener("keyup", function(){
        if(this.value === ""){
            valBool1 = false;
            checkInput();
        }else{
            valBool1 = true;
            checkInput();
        }
    }, false);

    function checkInput() {
        if(valBool == true && valBool1 == true){
            button.disabled = false;
        }else{
            button.disabled = true;
        }
    }
    
}); //fin ready


let nome = document.getElementById('nome');
let email = document.querySelector('#email');
let idade = document.querySelector('input#idade');
let assunto = document.querySelector('#assunto');
let mapa = document.querySelector('#mapa');

let nomeOk = false;
let emailOk = false;
let idadeOk = false;
let assuntoOk = false;

nome.style.width = '100%'
email.style.width = '100%'
idade.style.width = '100%'
assunto.style.width = '100%'

function validaNome(){
    let txtNome = document.querySelector('#txtNome')
    const regex = /[0-9]/;
    if(nome.value.length < 3 || regex.test(nome.value) == true || nome.value[0] == " "){
        txtNome.innerHTML = 'Nome inválido'
        txtNome.style.color = '#FF0000'
    }else{
        txtNome.innerHTML = 'Nome válido'
        txtNome.style.color = '#008000'
        nomeOk = true
    }
}

//Outra forma de só aceitar letras no inputText 

// function ApenasLetras(e, t) {
//     try {
//         if (window.event) {
//             var charCode = window.event.keyCode;
//         } else if (e) {
//             var charCode = e.which;
//         } else {
//             return true;
//         }
//         if (
//             (charCode > 64 && charCode < 91) || 
//             (charCode > 96 && charCode < 123) ||
//             (charCode > 191 && charCode <= 255) // letras com acentos 
//             || (charCode == 32)
//         ){
//             return true;
//         } else {
//             return false;
//         }
//     } catch (err) {
//         alert(err.Description);
//     }
// }

function validaEmail(){
    let txtEmail = document.querySelector('#txtEmail')

    if(email.value.indexOf('@')== -1 || email.value.indexOf('.') == -1){
        txtEmail.innerHTML = 'Email inválido'
        txtEmail.style.color = '#FF0000'
    }else{
        txtEmail.innerHTML = 'Email válido'
        txtEmail.style.color = '#008000'
        emailOk = true
    }
}

function validaIdade(){
    let txtIdade = document.getElementById('txtIdade');
     if(idade.value <= 0 || idade.value >= 120){
        txtIdade.innerHTML = 'Idade inválida'
        txtIdade.style.color = '#FF0000'
    }else{
        txtIdade.innerHTML = 'Idade válida'
        txtIdade.style.color = '#008000'
        idadeOk = true
    }
}

function validaRadio() {
    if (document.formulario.assunto[0].checked == false 
      && document.formulario.assunto[1].checked == false 
      && document.formulario.assunto[2].checked == false) {
      alert('Por favor, selecione o assunto.');
      return false;
    }else{
        return true;

    }
    
  }

function validaAssunto(){
   let txtAssunto = document.querySelector('#txtAssunto');

   if (assunto.value.length >= 100){
       txtAssunto.innerHTML = 'O texto é muito grande, por favor reduza-o.'
       txtAssunto.style.color = '#FF0000'
       txtAssunto.style.display = 'block'
   }else
    txtAssunto.style.display = 'none'
    assuntoOk = true
}

function enviar(){
    if(nomeOk == true && emailOk == true && idadeOk && assuntoOk == true){
        alert('Formulário enviado com sucesso!')
    }else{
        alert('Por favor, preencha todos os dados corretamente.')
    }
}

function ampliarMapa(){
    mapa.style.width = '800px'
    mapa.style.height = '600px'
}

function mapaNormal(){
    mapa.style.width = '450px'
    mapa.style.height = '300px'
}


API_URL = "http://localhost:8080/api/v1/usuarios/login";
//Metodo para autenticar el usuario registrado en la base de datos
function login(){
    fetch(API_URL, {
        method: "POST",
        headers: {"Content-type": "application/json"},
        body: JSON.stringify({
            email: document.getElementById("email").value,//valida el nombre ingresado en el login con el de la base de datos 
            password: document.getElementById("password").value//Valida el password ingresado en el login con la de la base de datos 

        })
    })
    .then(response => response.json())
    .then(data => {//manejamos la respuesta del servidor
        if(data.result === "OK"){// si la validacion es correcta
            sessionStorage.setItem("nombreUsuario", data.nombre);//se muestra el nombre del usuario
            window.location.href = "/index.html";// sse carga el index.html
        }else{//si la validacion es incorrecta
            alert("Acceso a sido denegado")//se niega el acceso
        }
    });
}
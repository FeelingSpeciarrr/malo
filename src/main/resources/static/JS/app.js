const API_URL = "http://localhost:8080/api/v1/cursos";

function listarCursos(){
    fetch(API_URL)
        .then(response => response.json())
        .then(cursos => {
            const tbody = document.querySelector("#tablaCursos tbody");
            tbody.innerHTML = "";
            cursos.forEach(curso => {
                const fila = `
                    <tr>
                        <td>${curso.id}</td>
                        <td>${curso.nombre}</td>
                        <td>${curso.categoria}</td>
                        <td>${curso.precio}</td>
                        <td>${curso.instructor}</td>
                        <td>${curso.fechaActualizacion}</td>
                        <td>
                            <button class="btn btn-success btn-sm" onclick="carrito.agregarCurso(${curso.id})">💳 Agregar al Carrito</button>
                        </td>
                    </tr>
                `;
                tbody.innerHTML += fila;
            });
        });
}

let curso
listarCursos();


































































































































































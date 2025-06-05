const API = "http://localhost:8080/api/v1/cursos";


function buscar(nombre1) {
    fetch(`${API}/buscarCurso/${nombre1}`, { method: "GET" })
    const nombre = document.getElementById("nombre").value;
    tbody.innerHTML = "";
    if (nombre.trim() === "nombre1") {
        curso.forEach(curso => {
            const fila = `
                <tr>
                    <td>${curso.id}</td>
                    <td>${curso.nombre}</td>
                    <td>${curso.categoria}</td>
                    <td>${curso.precio}</td>
                    <td>${curso.instructor}</td> 
                    <td>${curso.fechaActualizacion}</td> 
                    <td>
                        <button onClick="carrito.eliminarCurso(${curso.id})">Eliminar</button>
                    </td>
                </tr>
            `;
            tbody.innerHTML += fila


        })
    };
}


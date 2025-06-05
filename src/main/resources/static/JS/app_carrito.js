const carrito =(() => {
    const API = "/api/v1/carrito";

    async function listarCarrito(){
        try {
            const response= await fetch(API);
            const curso= await response.json();
            const tbody=document.querySelector("#tablaCarrito tbody");
            const TotalCurso=document.getElementById("totalCarrito");
            const totalPrecio = document.getElementById("totalPrecio");
            tbody.innerHTML="";
            TotalCurso.textContent=curso.length;
           let sumaTotal = 0;
            curso.forEach(curso  => {
                sumaTotal+=curso.precio ?? 0;
            const fila=`
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
            tbody.innerHTML+=fila;
            
           }); 
           totalPrecio.textContent = sumaTotal;
        } catch (err) {
            console.error("Error al cargar el carrito: ",err);
            
        }
    }//Cerrando la estructura
    //Funcion para agregar un curso al carrito de compras
    async function agregarCurso(id){
        try {
            await fetch(`${API}/agregar/${id}`, {method:"POST"} 
            
            );
            alert("Curso agregado al carrito")
            listarCarrito();
        } catch (err) {
            console.error("Error al agregar al carrito: "+err);            
        }
    }
    //Funcion para eliminar un libro del carrito
    async function eliminarCurso(id) {
        try {
            await fetch(`${API}/eliminar/${id}`, {method: "DELETE"}
            );
            alert("Curso se eliminó del carro");
            listarCarrito();
        } catch (err) {
            console.error("Error al eliminar el curso del carrito", err);
        }
    }
    //Funcion para vaciar el carrito
    async function vaciarCarrito(){
        if (confirm("¿Estas seguro de vaciar el carrito?")){
            await fetch (`${API}/vaciar`, {method:"DELETE"});
            alert("El carrito está vacio.");
            listarCarrito();
        }
    }
    //Funcion para confirmar la compra
    async function confirmarCompra() {
        
         const total = document.getElementById("totalPrecio").textContent;
        if (parseInt(total)===0){
            alert("El carrito está vacío.");
            return;
        }
        if (confirm(`¿Desea confirmar tu compra por $${total}?`)){
            await fetch(`${API}/vaciar`, {method: "DELETE"});
            alert("¡Gracias por darme plata!");
            listarCarrito();
        }
        
    }
    return {listarCarrito, agregarCurso, eliminarCurso, vaciarCarrito, confirmarCompra};
})();
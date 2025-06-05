const API_URL2 = "http://localhost:8080/noti";

// Obtener todas las notificaciones
async function listarNoti() {
  try {
    const response = await fetch(API_URL2);
    if (!response.ok) throw new Error("Error al listar notificaciones");
    return await response.json();
  } catch (error) {
    console.error("Error en listarNoti:", error);
    return [];
  }
}

// Obtener una notificación por ID
async function buscarNoti(id) {
  try {
    const response = await fetch(`${API_URL2}/${id}`);
    if (!response.ok) throw new Error("No se pudo obtener la notificación");
    return await response.json();
  } catch (error) {
    console.error("Error en buscarNoti:", error);
  }
}

// Crear una nueva notificación
async function agregarNoti(mensaje) {
  try {
    const response = await fetch(API_URL2, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ mensaje }),
    });
    return await response.json();
  } catch (error) {
    console.error("Error en agregarNoti:", error);
  }
}

// Actualizar una notificación existente
async function actualizarNoti(id, mensaje) {
  try {
    const response = await fetch(`${API_URL2}/${id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({ id, mensaje }),
    });
    return await response.json();
  } catch (error) {
    console.error("Error en actualizarNoti:", error);
  }
}

// Eliminar una notificación por ID
async function eliminarNoti(id) {
  try {
    const response = await fetch(`${API_URL2}/${id}`, {
      method: 'DELETE',
    });
    return await response.text(); // Devuelve un string
  } catch (error) {
    console.error("Error en eliminarNoti:", error);
  }
}

// Obtener el total de notificaciones usando el método totalNotiV2()
async function totalNotiV2() {
  try {
    const response = await fetch(`${API_URL2}/total`);
    if (!response.ok) throw new Error("No se pudo obtener el total de notificaciones");
    return await response.json(); // Devuelve un número
  } catch (error) {
    console.error("Error en totalNotiV2:", error);
    return 0;
  }
}

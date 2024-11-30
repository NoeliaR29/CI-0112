# **Interfaz de Estructuras de Datos**

## **Descripción**
Este proyecto es una aplicación gráfica desarrollada en Java que permite visualizar y manipular tres estructuras de datos comunes:
- Árbol binario
- Lista circular
- Lista doblemente enlazada

La interfaz gráfica divide la ventana en diferentes paneles, cada uno diseñado para representar visualmente una estructura específica. Los usuarios pueden interactuar con las estructuras a través de botones y campos de texto.

---

## **Características**
### **Interfaz gráfica (Clase `Interfaz`)**
- La ventana principal organiza los paneles de las estructuras de datos utilizando `JSplitPane` para una visualización flexible.
- Permite visualizar y manipular las tres estructuras de manera independiente.

### **Paneles individuales**
1. **`PanelArbolBinario`**: Representación gráfica de un árbol binario.
   - Los nodos se pueden agregar y visualizar de forma jerárquica.
2. **`PanelListaCircular`**: Maneja una lista circular.
   - Operaciones incluidas: agregar, eliminar y buscar nodos.
   - Representación gráfica circular.
3. **`PanelListaDoble`**: Maneja una lista doblemente enlazada.
   - Operaciones incluidas: agregar al inicio/final, eliminar y buscar nodos.
   - Representación gráfica lineal con flechas que muestran las conexiones entre nodos.

---

## **Estructuras principales**
### **Árbol Binario (`PanelArbolBinario`)**
- Implementado como un árbol binario clásico.
- Permite agregar nodos e inspeccionar la estructura en tiempo real.

### **Lista Circular (`PanelListaCircular`)**
- Implementa una lista enlazada circular.
- Los nodos se enlazan formando un ciclo.
- Operaciones:
  - **Agregar nodo**: Inserta un nuevo nodo.
  - **Eliminar nodo**: Busca y elimina un nodo específico.
  - **Buscar nodo**: Comprueba si un nodo está presente en la lista.

### **Lista Doblemente Enlazada (`PanelListaDoble`)**
- Los nodos contienen referencias al nodo anterior y al nodo siguiente.
- Operaciones:
  - **Agregar al inicio/final**: Inserta un nodo al principio o final.
  - **Eliminar nodo**: Busca y elimina un nodo específico.
  - **Buscar nodo**: Verifica si un nodo está en la lista.

---

## **Tecnologías Utilizadas**
- **Swing**: Biblioteca gráfica para construir la interfaz de usuario.
- **AWT**: Para las operaciones de dibujo en los paneles gráficos.

---
## **Cómo Ejecutar**
1. Clona el repositorio o descarga los archivos fuente del proyecto.
2. Compila y ejecuta la clase `Interfaz` desde tu IDE o desde la línea de comandos:
   ```bash
   javac Interfaz.java
   java Interfaz

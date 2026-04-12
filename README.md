![Java](https://img.shields.io/badge/Java-21-blue)
![Status](https://img.shields.io/badge/status-finished-brightgreen)
![Platform](https://img.shields.io/badge/platform-desktop-lightgrey)

# 🧮 Calculadora Java

Calculadora de escritorio desarrollada en Java con interfaz gráfica usando Swing.  
Implementa operaciones básicas con precisión decimal, manejo de errores y soporte para entrada por teclado, además de historial de operaciones.

---

## 🚀 Descripción del proyecto

Este proyecto fue desarrollado de manera incremental, priorizando primero la interfaz gráfica y posteriormente robusteciendo la lógica de negocio.

### Proceso de desarrollo

1. **Construcción de la interfaz (UI)**
   - Diseño inicial de la calculadora con `JFrame`, `JPanel` y `GridLayout`.
   - Implementación de botones y display principal.

2. **Implementación de lógica básica**
   - Soporte para operaciones simples: suma, resta, multiplicación y división.
   - Manejo de operaciones en cadena (ej: `3 + 2 * 4` ejecutado secuencialmente).

3. **Mejoras en precisión**
   - Uso de `BigDecimal` para evitar errores de punto flotante.
   - Corrección de casos como:
     ```
     0.1 + 0.2 != 0.3 (double)
     ```
     → solucionado con `BigDecimal`.

4. **Validaciones y control de entrada**
   - Solo un punto decimal por número.
   - Eliminación de ceros a la izquierda.
   - Prevención de división por cero.
   - Límite de longitud del display.

5. **Nuevas funcionalidades**
   - Porcentaje (`%`)
   - Cambio de signo (`+/-`)
   - Borrado (`⌫`)
   - Reinicio (`AC`)

6. **Mejoras visuales**
   - Tema oscuro.
   - Ajuste dinámico de fuente según longitud del número.

7. **Historial de operaciones**
   - Registro en `JTextArea`.
   - Visualización opcional mediante botón.

8. **Soporte de teclado**
   - Entrada directa desde teclado (números, operadores, enter, escape, backspace).

---

## 🧠 Ejemplo de uso
<img width="413" height="510" alt="image" src="https://github.com/user-attachments/assets/f5495dbc-450c-4cd8-8efd-ba234a6ce69e" />

## 📸 Preview


<img width="406" height="513" alt="image" src="https://github.com/user-attachments/assets/74409e46-1598-4793-8496-f9fb1bc7f8dc" />
<img width="406" height="513" alt="image" src="https://github.com/user-attachments/assets/1f82fe85-7c7d-4d5d-a9ae-ba2ce67a6b08" />


---

## 🛠️ Tecnologías

- Java (JDK 17 o superior)
- Swing (GUI)
- BigDecimal (precisión matemática)

---

## 📥 Descargar

- 👉 [Calculator.exe](https://drive.google.com/file/d/1azqHCrkKBBJOqPX_6MXuvhcC9B7BRpvJ/view?usp=sharing)

- 👉 [Calculator.jar](https://drive.google.com/file/d/1QqZJu2fmjzFTRtOT9Hp8USmTYUmR1iOh/view?usp=sharing)


## 📦 Ejecución

### Opción 1: Ejecutar .EXE

### Opción 2: Ejecutar desde código fuente

`bash`<br>
`javac -d out src/com/devjunior/malfonso/**/*.java`<br>
`java -cp out com.devjunior.malfonso.Run.Main`

#### Desde JAR
java -jar Calculator.jar


| Tecla     | Acción          |
| --------- | --------------- |
| 0-9       | Números         |
| + - * / % | Operadores      |
| Enter o = | Calcular (=)    |
| Backspace | Borrar          |
| Esc       | Limpiar (AC)    |
| .         | Decimal         |



##📁 Estructura del proyecto

src/
 └── com.devjunior.malfonso/
      ├── Control/
      │    └── CalculatorLogic.java
      ├── GUI/
      │    └── CalculatorGUI.java
      └── Run/
           └── Main.java

##⚙️ Arquitectura

Separación básica por responsabilidades:

GUI: interfaz de usuario (CalculatorGUI)
Lógica: procesamiento (CalculatorLogic)
Entry point: (Main)

##📌 Posibles mejoras en una Versión 2.0
Implementar prioridad de operadores (PEMDAS)
Agregar tests unitarios (JUnit)
Soporte para teclado numérico completo
Exportar historial
Modo científico

##👨‍💻 Autor

**Miguel Alfonso**
Desarrollador Java Junior enfocado en mejorar calidad de código, arquitectura y buenas prácticas.

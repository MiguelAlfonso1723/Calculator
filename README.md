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
   - Tema oscuro personalizado.
   - Ajuste dinámico de fuente según longitud del número.

7. **Historial de operaciones**
   - Registro en `JTextArea`.
   - Visualización opcional mediante botón.

8. **Soporte de teclado**
   - Entrada directa desde teclado (números, operadores, enter, escape, backspace).

---

## 🧠 Ejemplo de uso

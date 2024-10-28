
# Optimización de Asignación de Paquetes - Inteligencia Artificial

Este proyecto fue desarrollado como parte de la asignatura de **Inteligencia Artificial** en nuestra universidad. 
La implementación utiliza el paquete **AIMA** para aplicar métodos de búsqueda local, específicamente **Hill Climbing** 
y **Simulated Annealing**. Estos algoritmos permiten encontrar la mejor asignación de paquetes a distintas ofertas de 
transporte, optimizando el proceso en función del tiempo y el costo.

## Descripción del Proyecto

El objetivo de este proyecto es optimizar la asignación de paquetes a transportistas, utilizando algoritmos de búsqueda 
local para mejorar el rendimiento en términos de tiempo y costo. Al usar Hill Climbing y Simulated Annealing, el sistema 
busca minimizar los costos sin comprometer la eficiencia del tiempo de entrega.

Los algoritmos exploran distintas configuraciones de asignación y ajustan continuamente las combinaciones hasta encontrar 
la solución más favorable para los criterios establecidos.

### Algoritmos Implementados

- **Hill Climbing**: Algoritmo de búsqueda local que optimiza progresivamente la asignación de paquetes sin retroceder en 
  el espacio de soluciones.
- **Simulated Annealing**: Algoritmo inspirado en el proceso de enfriamiento térmico que permite aceptar soluciones subóptimas 
  temporalmente para escapar de mínimos locales y explorar un espacio más amplio de soluciones.

### Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal del proyecto.
- **AIMA**: Biblioteca para algoritmos de inteligencia artificial utilizada en la implementación de los métodos 
  de búsqueda.

## Estructura del Proyecto

El proyecto está organizado en las siguientes carpetas:

- `/src`: Contiene el código fuente del proyecto.
  - `/MSN`: Carpeta con el código fuente para la asignación de paquetes, incluyendo los archivos descritos a continuación:

    - **AzamonFrame**: Código de una interfaz gráfica para ejecutar el programa visualmente, permitiendo cambiar valores 
      para realizar pruebas interactivas.
    - **AzamonGoalTest**: Clase requerida por AIMA que siempre devuelve `false`, evitando que se detenga la búsqueda prematuramente.
    - **AzamonHeuristicFunction**: Función que evalúa la calidad de una solución de dos maneras: considerando solo el precio, o 
      considerando precio y la satisfacción adicional de los clientes.
    - **AzamonMain**: Código principal para ejecutar el programa en consola.
    - **AzamonState**: Representación del problema de asignación de paquetes, incluyendo los paquetes, ofertas de transporte, 
      asignaciones y métodos necesarios.
    - **AzamonSuccesorFunction**: Genera todos los sucesores posibles de un estado actual mediante dos movimientos: reasignar 
      un paquete a una oferta diferente o intercambiar dos paquetes entre ofertas.
    - **AzamonSuccesorFunctionSA**: Genera una única solución al azar utilizando los mismos dos movimientos posibles de 
      `AzamonSuccesorFunction`, optimizado para Simulated Annealing.
- `/lib`: Carpeta con las bibliotecas necesarias para la ejecución del proyecto, incluyendo el paquete AIMA y Azamon.

## Ejecución del Proyecto

Para ejecutar el proyecto, sigue los pasos a continuación:

1. Clona el repositorio y asegúrate de tener **Java** instalado en tu sistema.
2. Compila el proyecto desde la carpeta raíz que contiene `src` y `lib`.

   ```bash
   javac -cp lib/* src/MSN/*.java
   ```

3. Una vez compilado, ejecuta la clase `AzamonFrame` que contiene el método principal para iniciar el programa:

   ```bash
   java -cp "lib/*:src" MSN.AzamonFrame
   ```

## Contribuciones

Este es un proyecto educativo, por lo que las contribuciones están enfocadas en fines académicos y de aprendizaje. Si 
deseas colaborar, crea un fork del repositorio y envía un pull request con tus mejoras o sugerencias.

## Licencia

Este proyecto está diseñado con fines educativos y no tiene licencia para uso comercial.

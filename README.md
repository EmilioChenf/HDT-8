# Sistema de Atención de Emergencias

Este proyecto implementa un sistema completo para la gestión y simulación de atención a pacientes en un servicio de emergencias. Está desarrollado en Java (para la interfaz y lógica principal) y Python (para la simulación).

## Características

- Registro de pacientes con nombre, síntoma y código de prioridad (A-E).
- Atención de pacientes basada en prioridad usando una cola de prioridad (VectorHeap).
- Interfaz gráfica construida con JavaFX para la gestión de pacientes.
- Simulación del comportamiento de un hospital con recursos limitados usando SimPy.
- Generación de gráficas y análisis estadístico del rendimiento del sistema.

## Estructura del Proyecto

```
proyecto/
│
├── src/                    # Código fuente Java
│   ├── controller/         # Controladores para la interfaz
│   ├── model/              # Modelos y entidades (Paciente)
│   ├── utils/              # Utilidades (VectorHeap, PriorityQueue)
│   ├── view/               # Vistas y componentes de UI
│   └── Main.java           # Punto de entrada de la aplicación
│
├── test/                   # Pruebas unitarias
│   └── VectorHeapTest.java # Tests para la implementación de VectorHeap
│
├── test-lib/               # Bibliotecas para pruebas
│   ├── hamcrest-core-1.3.jar
│   └── junit-4.13.2.jar
│
├── simulacion/             # Código Python para simulación
│   ├── graficas.py         # Generación de gráficas con Matplotlib
│   ├── recursos.py         # Definición de recursos del hospital
│   └── simulacion_emergencias.py  # Simulación principal con SimPy
│
├── pacientes.txt           # Datos de ejemplo de pacientes
└── README.md               # Este archivo
```

## Instalación y Configuración

### Requisitos previos

#### Para la parte Java:
- Java JDK 17 o superior
- JavaFX SDK 24 o superior
- VS Code con Extension Pack for Java

#### Para la simulación:
- Python 3.10 o superior
- SimPy (`pip install simpy`)
- Matplotlib (`pip install matplotlib`)

### Configuración en VS Code

1. Clona este repositorio:
   ```
   git clone https://github.com/tu-usuario/sistema-emergencias.git
   cd sistema-emergencias
   ```

2. Configura JavaFX en tu entorno:
   - Descarga [JavaFX SDK](https://gluonhq.com/products/javafx/) y descomprímelo
   - Crea un archivo `.vscode/settings.json` con:
     ```json
     {
       "java.project.referencedLibraries": [
         "ruta/a/tu/javafx-sdk-24/lib/**/*.jar",
         "test-lib/**/*.jar"
       ]
     }
     ```
   - Crea un archivo `.vscode/launch.json` con:
     ```json
     {
       "version": "0.2.0",
       "configurations": [
         {
           "type": "java",
           "name": "Run JavaFX App",
           "request": "launch",
           "mainClass": "Main",
           "vmArgs": "--module-path ruta/a/tu/javafx-sdk-24/lib --add-modules javafx.controls,javafx.fxml"
         }
       ]
     }
     ```

## Ejecución

### Aplicación Java

Para ejecutar la aplicación principal:

1. Abre el proyecto en VS Code
2. Asegúrate de que la configuración de JavaFX es correcta
3. Haz clic en Run/Debug en VS Code o ejecuta:
   ```
   javac --module-path "ruta/a/tu/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml -d out src/**/*.java
   java --module-path "ruta/a/tu/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml -cp out Main
   ```

### Pruebas Unitarias

Para ejecutar los tests:

1. En VS Code, ve a la vista de Tests
2. Haz clic en Run Test junto a cada prueba o a todas
3. Alternativamente, ejecuta desde terminal:
   ```
   javac -cp "test-lib/junit-4.13.2.jar:test-lib/hamcrest-core-1.3.jar:out" -d out test/*.java
   java -cp "test-lib/junit-4.13.2.jar:test-lib/hamcrest-core-1.3.jar:out" org.junit.runner.JUnitCore test.VectorHeapTest
   ```

### Simulación Python

Para ejecutar la simulación:

1. Navega al directorio de simulación:
   ```
   cd simulacion
   ```

2. Ejecuta el script principal:
   ```
   python simulacion_emergencias.py
   ```

## Diseño y Funcionamiento

### Estructura de Datos Principal

El sistema utiliza un `VectorHeap` como implementación de una cola de prioridad para organizar a los pacientes según su código de emergencia. Esta estructura garantiza que los pacientes con mayor urgencia (códigos A, B) sean atendidos antes que los de menor urgencia (códigos D, E).

### Interfaz Gráfica

La interfaz JavaFX permite:
- Cargar pacientes desde un archivo
- Agregar nuevos pacientes con sus síntomas y prioridad
- Atender pacientes en orden de prioridad
- Visualizar un registro de las acciones realizadas

### Simulación

La simulación en Python modela:
- Llegada aleatoria de pacientes
- Atención en diferentes estaciones (triage, doctor, laboratorio, rayos X)
- Recursos limitados (doctores, enfermeras, equipamiento)
- Medición de tiempos de espera y atención

## Pruebas

Se han implementado pruebas unitarias para verificar el funcionamiento correcto de `VectorHeap`, comprobando:
- Inserción y extracción de elementos
- Mantenimiento del orden por prioridad
- Comportamiento con elementos del mismo tipo (Integer)
- Comportamiento con objetos personalizados (Paciente)

## Contribución

Si deseas contribuir a este proyecto:
1. Haz un fork del repositorio
2. Crea una rama para tus cambios (`git checkout -b feature/nueva-funcionalidad`)
3. Haz commit de tus cambios (`git commit -m 'Añadir nueva funcionalidad'`)
4. Haz push a la rama (`git push origin feature/nueva-funcionalidad`)
5. Abre un Pull Request

## Autores

- Fátima Navarro
- Emilio Chen

## Licencia

Este proyecto está licenciado bajo la Licencia MIT - ver el archivo LICENSE para más detalles.

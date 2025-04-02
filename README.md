# 🏥 Sistema de Atención de Emergencias

Este proyecto es una implementación completa de un **sistema de atención a pacientes en emergencias** desarrollado en **Java (JavaFX)** y **Python (SimPy)**. Está dividido en dos partes:

1. Una interfaz gráfica para registrar y atender pacientes con prioridad usando estructuras de datos personalizadas.
2. Una simulación realista del sistema hospitalario utilizando recursos limitados, con análisis mediante gráficas.

---

## 🎯 Objetivo

- Registrar pacientes con nombre, síntoma y código de prioridad (A–E).
- Atender a los pacientes en orden de prioridad (A = más urgente).
- Simular el comportamiento de un hospital usando recursos limitados.
- Analizar tiempos de espera, carga de trabajo y generar gráficas.

---

## 🗂️ Estructura del Proyecto

HDT-8/ ├── src/ # Parte Java (interfaz y lógica) │ ├── controller/ │ ├── model/ │ ├── utils/ │ ├── view/ │ └── Main.java ├── simulacion/ # Parte Python (simulación y gráficas) │ ├── simulacion_emergencias.py │ ├── recursos.py │ ├── graficas.py ├── resultados/ # Salida de gráficas y (pronto) informe PDF │ ├── tiempos_atencion.png │ └── tiempo_promedio.png ├── pacientes.txt # Archivo con pacientes └── .vscode/ # Configuración de VS Code ├── launch.json └── settings.json

markdown
Copiar
Editar

---

## 💻 Tecnologías Utilizadas

- Java 17+
- JavaFX SDK 21 o 24
- Visual Studio Code (con extensión Java Extension Pack)
- Python 3.10+
- SimPy (para simulación)
- Matplotlib (para gráficas)

---

## 🧩 Parte 1 – Interfaz Java (JavaFX + Cola de Prioridad)

### ✅ Funcionalidades

- Interfaz amigable para agregar y atender pacientes.
- Lectura/escritura en `pacientes.txt`.
- Uso de `VectorHeap` para manejar prioridad.
- Atención automática por urgencia.
- Registro visual en pantalla (TextArea).
- Pruebas unitarias con JUnit.

### ⚙️ Requisitos Java

- Java JDK 17 o superior
- [JavaFX SDK 21 o 24](https://gluonhq.com/products/javafx/) descomprimido
- Visual Studio Code

### 🛠️ Configuración en `.vscode/settings.json`

```json
{
  "java.project.referencedLibraries": [
    "C:/Users/TU_USUARIO/Documents/javafx-sdk-24/lib/**/*.jar"
  ]
}
⚠️ Cambia "TU_USUARIO" por tu nombre de usuario o ruta real.

🛠️ Configuración en .vscode/launch.json
json
Copiar
Editar
{
  "version": "0.2.0",
  "configurations": [
    {
      "type": "java",
      "name": "Run JavaFX App",
      "request": "launch",
      "mainClass": "Main",
      "vmArgs": "--module-path C:/Users/TU_USUARIO/Documents/javafx-sdk-24/lib --add-modules javafx.controls,javafx.fxml"
    }
  ]
}
▶️ Cómo ejecutar la app JavaFX
Abre el proyecto en VS Code

Asegúrate de que Main.java esté en src/ y no tenga package

Compila y ejecuta:

bash
Copiar
Editar
cd HDT-8

javac --module-path "C:/Users/TU_USUARIO/Documents/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml -d out src/Main.java src/controller/*.java src/model/*.java src/utils/*.java src/view/*.java

java --module-path "C:/Users/TU_USUARIO/Documents/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml -cp out Main
🧬 Parte 2 – Simulación en Python (SimPy)
✅ ¿Qué simula?
Llegada aleatoria de pacientes con prioridad 1–5

Atención en etapas: triage → doctor → laboratorio → rayos X

Recursos limitados: 2 doctores, 2 enfermeras, 1 laboratorio, 1 rayos X

Registro del tiempo total por paciente

Gráficas automáticas generadas

⚙️ Requisitos Python
Python 3.10 o superior

Instalar dependencias:

bash
Copiar
Editar
pip install simpy matplotlib
▶️ Cómo ejecutar la simulación
bash
Copiar
Editar
cd simulacion
python simulacion_emergencias.py
📂 Salida generada
resultados/tiempos_atencion.png: Tiempo total en el hospital por paciente

resultados/tiempo_promedio.png: Tiempo promedio de atención
# 🏥 Sistema de Atención de Emergencias

Este proyecto es una implementación completa de un **sistema de atención a pacientes en emergencias** desarrollado en **Java** utilizando **JavaFX** para la interfaz gráfica. Utiliza una **cola de prioridad basada en un heap** para atender a los pacientes según su nivel de urgencia.

## 🎯 Objetivo

Desarrollar un sistema de atención de pacientes en la sala de emergencias de un hospital, en el que:
- Los pacientes son ingresados con nombre, síntoma y código de prioridad (A–E).
- La prioridad **A** indica mayor urgencia, la **E** menor.
- El sistema gestiona la atención de pacientes en orden de prioridad.
- Se pueden agregar pacientes desde una interfaz gráfica.
- Se guarda y carga la información desde un archivo `pacientes.txt`.

## 🧱 Estructura del Proyecto

EmergencySystem/
├── lib/                            <-- Aquí puedes poner javafx-sdk si gustas
├── src/
│   ├── model/
│   │   └── Paciente.java
│   ├── utils/
│   │   └── VectorHeap.java
│   ├── controller/
│   │   └── EmergencyController.java
│   ├── view/
│   │   └── EmergencyUI.java
│   └── Main.java
├── pacientes.txt
└── .vscode/
    └── launch.json
    └── settings.json


## 💻 Tecnologías Utilizadas

- Java 17 o superior
- JavaFX SDK 21+
- Visual Studio Code
- JavaFX (para GUI)
- Java Collections y manejo de archivos
- Estructuras de datos (heap, PriorityQueue)

## 📦 Funcionalidades Principales

### ✔️ Carga de pacientes desde archivo
- El archivo `pacientes.txt` contiene los pacientes con el formato:

### ✔️ Atención automática por prioridad
- Los pacientes se atienden según la letra de prioridad (A es más urgente).

### ✔️ Interfaz gráfica moderna (JavaFX)
- Botones para cargar, atender y agregar pacientes.
- Campos de entrada para nuevo paciente.
- Visualización del historial en un `TextArea`.

### ✔️ Agregar pacientes desde la interfaz
- Se ingresan directamente desde la ventana.
- Se guardan en `pacientes.txt`.
- Se recargan automáticamente en la cola.

### ✔️ Pruebas unitarias
- Pruebas para insertar y retirar pacientes del `VectorHeap`.

## 🚀 Cómo Ejecutar el Proyecto en VS Code

### 1. Requisitos:
- [Java Development Kit (JDK) 17+](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
- [JavaFX SDK](https://gluonhq.com/products/javafx/)
- [Java Extension Pack en VS Code](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)

### 2. Configurar VS Code:

- En `.vscode/settings.json`:

```json
{
"java.project.referencedLibraries": [
  "C:/ruta/a/javafx-sdk-24/lib/**/*.jar"
]
}
3. Ejecutar:
cd HDT-8
javac --module-path "ruta/a/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml src/**/*.java
java --module-path "ruta/a/javafx-sdk-24/lib" --add-modules javafx.controls,javafx.fxml -cp src Main

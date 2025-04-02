"""
Módulo para generación de gráficas del sistema de atención de emergencias.

Contiene funciones para visualizar:
- El tiempo total que cada paciente pasó en el hospital.
- El tiempo promedio de atención.

Autores:
- Fátima Navarro
- Emilio Chen
"""

import matplotlib.pyplot as plt

def grafica_tiempos(tiempos_espera):
    """
    Genera una gráfica de línea que muestra el tiempo total de atención
    para cada paciente, en el orden en que llegaron.

    Parámetros:
    - tiempos_espera (list of float): Lista de tiempos totales por paciente.

    Salida:
    - Archivo de imagen PNG: 'resultados/tiempos_atencion.png'
    """
    plt.figure(figsize=(10, 5))
    plt.plot(tiempos_espera, marker='o', linestyle='-', color='teal')
    plt.title("Tiempo total de atención por paciente")
    plt.xlabel("Paciente (orden de llegada)")
    plt.ylabel("Minutos en el hospital")
    plt.grid(True)
    plt.tight_layout()
    plt.savefig("../resultados/tiempos_atencion.png")
    plt.close()
    print("✅ Gráfica de tiempos generada: resultados/tiempos_atencion.png")

def grafica_promedio(tiempos_espera):
    """
    Genera una gráfica de barras que muestra el tiempo promedio de atención
    de todos los pacientes que completaron su proceso.

    Parámetros:
    - tiempos_espera (list of float): Lista de tiempos totales por paciente.

    Salida:
    - Archivo de imagen PNG: 'resultados/tiempo_promedio.png'

    Nota:
    - Si la lista está vacía, muestra un mensaje de advertencia.
    """
    if len(tiempos_espera) == 0:
        print("⚠️ No hay datos para calcular el promedio.")
        return

    promedio = sum(tiempos_espera) / len(tiempos_espera)
    plt.figure(figsize=(6, 4))
    plt.bar(["Promedio"], [promedio], color="orange")
    plt.title("Tiempo promedio de atención")
    plt.ylabel("Minutos")
    plt.tight_layout()
    plt.savefig("../resultados/tiempo_promedio.png")
    plt.close()
    print("Gráfica de promedio generada: resultados/tiempo_promedio.png")

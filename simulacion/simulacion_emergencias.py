"""
Simulación del sistema de atención en emergencias utilizando SimPy.

Este script modela la llegada de pacientes con distintos niveles de prioridad
y su paso por diferentes recursos hospitalarios como triage, doctor,
laboratorio y rayos X. También genera gráficas del tiempo total y promedio
de atención por paciente.

Autores:
- Fátima Navarro
- Emilio Chen
"""

import simpy
import random
from recursos import RecursosHospital
from graficas import grafica_tiempos, grafica_promedio

# Configuración para resultados consistentes
random.seed(10)

# Lista global para almacenar los tiempos de atención de cada paciente
tiempos_espera = []

class Paciente:
    """
    Clase que representa a un paciente en la simulación.

    Atributos:
    - nombre (str): Identificador del paciente.
    - prioridad (int): Nivel de urgencia (1 = muy urgente, 5 = leve).
    """
    def __init__(self, nombre, prioridad):
        self.nombre = nombre
        self.prioridad = prioridad

def proceso_paciente(env, paciente, recursos: RecursosHospital):
    """
    Define el flujo completo que sigue un paciente desde su llegada hasta su salida.

    Etapas:
    - TRIAGE (enfermera)
    - Consulta con DOCTOR
    - Posible paso por LABORATORIO
    - Posible paso por RAYOS X

    Cada etapa depende de la disponibilidad del recurso y la prioridad del paciente.
    """
    llegada = env.now
    print(f"[{llegada:.2f}] Llega {paciente.nombre} (Prioridad {paciente.prioridad})")

    # TRIAGE
    with recursos.enfermeras.request(priority=paciente.prioridad) as req:
        yield req
        print(f"[{env.now:.2f}] {paciente.nombre} entra a TRIAGE")
        yield env.timeout(10)

    # DOCTOR
    with recursos.doctores.request(priority=paciente.prioridad) as req:
        yield req
        print(f"[{env.now:.2f}] {paciente.nombre} entra con el DOCTOR")
        yield env.timeout(random.randint(15, 25))

    # LABORATORIO (50% de los casos)
    if random.random() < 0.5:
        with recursos.laboratorio.request(priority=paciente.prioridad) as req:
            yield req
            print(f"[{env.now:.2f}] {paciente.nombre} entra a LABORATORIO")
            yield env.timeout(random.randint(5, 10))

    # RAYOS X (30% de los casos)
    if random.random() < 0.3:
        with recursos.rayos_x.request(priority=paciente.prioridad) as req:
            yield req
            print(f"[{env.now:.2f}] {paciente.nombre} entra a RAYOS X")
            yield env.timeout(random.randint(5, 10))

    salida = env.now
    tiempo_total = salida - llegada
    tiempos_espera.append(tiempo_total)
    print(f"[{salida:.2f}] {paciente.nombre} sale del hospital (Tiempo total: {tiempo_total:.2f} min)")

def llegada_pacientes(env, recursos):
    """
    Genera pacientes que llegan al hospital de forma continua con prioridad aleatoria.

    La llegada ocurre siguiendo una distribución exponencial (1 cada ~5 minutos).
    """
    id_paciente = 1
    while True:
        prioridad = random.randint(1, 5)
        paciente = Paciente(f"Paciente{id_paciente}", prioridad)
        env.process(proceso_paciente(env, paciente, recursos))
        id_paciente += 1
        yield env.timeout(random.expovariate(1 / 5))

def ejecutar_simulacion(duracion):
    """
    Ejecuta la simulación durante una duración específica (en minutos).

    Al finalizar, genera dos gráficas:
    - Tiempo total de atención por paciente.
    - Tiempo promedio general.

    Parámetros:
    - duracion (int): Duración de la simulación en minutos.
    """
    env = simpy.Environment()
    recursos = RecursosHospital(env)
    env.process(llegada_pacientes(env, recursos))
    env.run(until=duracion)

    # Generar gráficas solo si hay datos
    if len(tiempos_espera) > 0:
        grafica_tiempos(tiempos_espera)
        grafica_promedio(tiempos_espera)
    else:
        print("No se registraron tiempos de atención.")

# Punto de entrada del script
if __name__ == "__main__":
    ejecutar_simulacion(180)  # Simular por 3 horas

"""
Módulo que define los recursos del hospital utilizados en la simulación.

Este módulo contiene una clase que encapsula los recursos limitados disponibles,
como doctores, enfermeras, laboratorio y rayos X. Todos los recursos utilizan
SimPy y están gestionados por prioridad (menor número = mayor prioridad).

Autores:
- Fátima Navarro
- Emilio Chen
"""

import simpy

class RecursosHospital:
    """
    Clase que representa los recursos disponibles en el hospital para la simulación.

    Recursos disponibles:
    - Doctores (👨‍⚕️)
    - Enfermeras (🧑‍⚕️)
    - Laboratorio (🧪)
    - Rayos X (🩻)

    Todos los recursos son instancias de simpy.PriorityResource, lo que permite
    que los pacientes sean atendidos según su nivel de urgencia (prioridad).
    """

    def __init__(self, env, num_doctores=2, num_enfermeras=2, num_lab=1, num_rayosx=1):
        """
        Inicializa los recursos del hospital con sus capacidades respectivas.

        Parámetros:
        - env (simpy.Environment): Entorno de simulación de SimPy.
        - num_doctores (int): Número de doctores disponibles (default = 2).
        - num_enfermeras (int): Número de enfermeras disponibles (default = 2).
        - num_lab (int): Número de laboratorios disponibles (default = 1).
        - num_rayosx (int): Número de estaciones de rayos X disponibles (default = 1).
        """
        self.env = env
        self.doctores = simpy.PriorityResource(env, capacity=num_doctores)
        self.enfermeras = simpy.PriorityResource(env, capacity=num_enfermeras)
        self.laboratorio = simpy.PriorityResource(env, capacity=num_lab)
        self.rayos_x = simpy.PriorityResource(env, capacity=num_rayosx)

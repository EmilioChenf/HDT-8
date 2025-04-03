package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import utils.VectorHeap;
import model.Paciente;

public class VectorHeapTest {
    
    private VectorHeap<Integer> heapNumeros;
    private VectorHeap<Paciente> heapPacientes;
    
    @BeforeEach
    public void setUp() {
        // Inicializar un heap para números
        heapNumeros = new VectorHeap<>();
        
        // Inicializar un heap para pacientes
        heapPacientes = new VectorHeap<>();
    }
    
    @Test
    public void testIsEmptyTrue() {
        // Comprobar que un heap recién creado está vacío
        assertTrue(heapNumeros.isEmpty());
    }
    
    @Test
    public void testIsEmptyFalse() {
        // Comprobar que después de agregar un elemento, el heap no está vacío
        heapNumeros.add(10);
        assertFalse(heapNumeros.isEmpty());
    }
    
    @Test
    public void testAddAndPeek() {
        // Agregar un elemento y verificar que peek devuelve ese elemento
        heapNumeros.add(5);
        assertEquals(5, heapNumeros.peek());
    }
    
    @Test
    public void testPeekEmptyHeap() {
        // Verificar que peek devuelve null en un heap vacío
        assertNull(heapNumeros.peek());
    }
    
    @Test
    public void testAddMultipleAndPeek() {
        // Agregar varios elementos y verificar que peek devuelve el de mayor prioridad
        heapNumeros.add(10);
        heapNumeros.add(5);
        heapNumeros.add(15);
        assertEquals(5, heapNumeros.peek());
    }
    
    @Test
    public void testRemove() {
        // Agregar elementos y verificar que remove devuelve el elemento correcto
        heapNumeros.add(15);
        heapNumeros.add(10);
        heapNumeros.add(5);
        
        assertEquals(5, heapNumeros.remove());
        assertEquals(10, heapNumeros.remove());
        assertEquals(15, heapNumeros.remove());
    }
    
    @Test
    public void testRemoveEmptyHeap() {
        // Verificar que remove devuelve null en un heap vacío
        assertNull(heapNumeros.remove());
    }
    
    @Test
    public void testEmptyAfterRemoveAll() {
        // Verificar que el heap está vacío después de eliminar todos los elementos
        heapNumeros.add(1);
        heapNumeros.add(2);
        heapNumeros.remove();
        heapNumeros.remove();
        assertTrue(heapNumeros.isEmpty());
    }
    
    @Test
    public void testPacientePrioridad() {
        // Probar con la clase Paciente para verificar que funciona la prioridad por código
        Paciente pacienteA = new Paciente("Juan", "Dolor", 'A');
        Paciente pacienteC = new Paciente("María", "Fiebre", 'C');
        Paciente pacienteB = new Paciente("Pedro", "Fractura", 'B');
        
        heapPacientes.add(pacienteC);
        heapPacientes.add(pacienteA);
        heapPacientes.add(pacienteB);
        
        // Verificar que se atienden en orden A, B, C
        assertEquals('A', heapPacientes.remove().getCodigo());
        assertEquals('B', heapPacientes.remove().getCodigo());
        assertEquals('C', heapPacientes.remove().getCodigo());
    }
    
    @Test
    public void testStabilityForEqualPriority() {
        // Verificar que el orden de llegada se mantiene para pacientes con la misma prioridad
        Paciente pacienteA1 = new Paciente("Juan", "Dolor", 'A');
        Paciente pacienteA2 = new Paciente("María", "Emergencia", 'A');
        
        heapPacientes.add(pacienteA1);
        heapPacientes.add(pacienteA2);
        
        // Debería mantener el orden de llegada para la misma prioridad
        assertEquals("Juan", heapPacientes.remove().getNombre());
        assertEquals("María", heapPacientes.remove().getNombre());
    }
}
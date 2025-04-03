package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import utils.VectorHeap;
import model.Paciente;

public class VectorHeapTest {
    
    private VectorHeap<Integer> heapNumeros;
    private VectorHeap<Paciente> heapPacientes;
    
    @Before  // Usa @Before en lugar de @BeforeEach
    public void setUp() {
        // Inicializar un heap para números
        heapNumeros = new VectorHeap<>();
        
        // Inicializar un heap para pacientes
        heapPacientes = new VectorHeap<>();
    }
    
    @Test
    public void testIsEmptyTrue() {
        assertTrue("Un heap recién creado debería estar vacío", heapNumeros.isEmpty());
    }
    
    @Test
    public void testIsEmptyFalse() {
        heapNumeros.add(10);
        assertFalse("Un heap con elementos no debería estar vacío", heapNumeros.isEmpty());
    }
    
    @Test
    public void testAddAndPeek() {
        heapNumeros.add(5);
        assertEquals("Peek debería devolver el elemento añadido", 5, (int)heapNumeros.peek());
    }
    
    @Test
    public void testPeekEmptyHeap() {
        assertNull("Peek en un heap vacío debería devolver null", heapNumeros.peek());
    }
    
    @Test
    public void testAddMultipleAndPeek() {
        heapNumeros.add(10);
        heapNumeros.add(5);
        heapNumeros.add(15);
        assertEquals("Peek debería devolver el elemento con mayor prioridad", 5, (int)heapNumeros.peek());
    }
    
    @Test
    public void testRemove() {
        heapNumeros.add(15);
        heapNumeros.add(10);
        heapNumeros.add(5);
        
        assertEquals("El primer remove debería devolver 5", 5, (int)heapNumeros.remove());
        assertEquals("El segundo remove debería devolver 10", 10, (int)heapNumeros.remove());
        assertEquals("El tercer remove debería devolver 15", 15, (int)heapNumeros.remove());
        assertTrue("Después de remover todos los elementos, el heap debería estar vacío", heapNumeros.isEmpty());
    }
    
    @Test
    public void testRemoveEmptyHeap() {
        assertNull("Remove en un heap vacío debería devolver null", heapNumeros.remove());
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
        
        // Verificar que se atienden en orden A, B, C (A tiene mayor prioridad)
        assertEquals("El primer paciente debería tener prioridad A", 'A', heapPacientes.remove().getCodigo());
        assertEquals("El segundo paciente debería tener prioridad B", 'B', heapPacientes.remove().getCodigo());
        assertEquals("El tercer paciente debería tener prioridad C", 'C', heapPacientes.remove().getCodigo());
    }
}
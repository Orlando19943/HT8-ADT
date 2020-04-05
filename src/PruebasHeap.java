import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * 
 */

/**
 * @author Orlando
 *
 */
class PruebasHeap {
	Paciente paciente1 = new Paciente("Juan Perez" ,"fractura de pierna" ,"C");
	Paciente paciente2 = new Paciente("Maria Ramirez", "apendicitis", "A");
	
	@Test
	void addTest() {
		VectorHeap<Paciente> heap = new VectorHeap<Paciente>();
		heap.add(paciente1);
		heap.add(paciente2);
		assertEquals(heap.remove(), paciente2);
		assertEquals(heap.remove(), paciente1);
	}

}

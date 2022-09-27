import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArestaTest {

	@Test
	void ExisteArestaTest() {
		Aresta a = new Aresta(1,2);
		assertEquals(a.peso(),1);
		assertEquals(a.destino(),2);
		
	}

}

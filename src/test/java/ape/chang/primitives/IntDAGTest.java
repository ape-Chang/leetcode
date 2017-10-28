package ape.chang.primitives;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IntDAGTest {
	
	@Test
	public void test() {
		IntDAG dag = new IntDAG(3);
		dag.addEdge(0, 2);
		dag.addEdge(1, 2);
		assertTrue(dag.maxDistance() == 2);
	}

}

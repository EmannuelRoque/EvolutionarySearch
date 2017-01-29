package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;

import junit.framework.TestCase;

/**
 * JUnit test for the Random Initialization operator
 * 
 * @author Sebastian Luna Valero
 *
 */
public class RandomInitializationTest extends TestCase {
	
	public RandomInitializationTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	// test the method 'execute' without starting set
	public void testExecute1() throws EvolutionaryException {
		int populationSize, sizeOfIndividuals, classIndex;
		int expectedSize;
		boolean hasClass;
		Population population;
		Random random;
		Operator randomInit;
		HashMap<String, Object> parameters;
		
		populationSize = 10;
		population = new Population(populationSize);
		sizeOfIndividuals = 4;
		classIndex = sizeOfIndividuals - 1;
		hasClass = true;
		random = new Random();
		parameters = new HashMap<String, Object>();
		parameters.put("random", random);
		parameters.put("populationSize", populationSize);
		parameters.put("classIndex", classIndex);
		parameters.put("sizeOfIndividuals", sizeOfIndividuals);
		parameters.put("hasClass", hasClass);
		
		randomInit = InitializationFactory.getInitializationOperator("RandomInitialization", parameters); 
		
		//System.out.println(population);
		randomInit.execute(population);
		//System.out.println(population);
		
		expectedSize = population.getSize();
		assertTrue(populationSize == expectedSize);
				
	}

	// test the method 'execute' with starting set
	public void testExecute2() throws EvolutionaryException {
		int populationSize, sizeOfIndividuals, classIndex;
		int expectedSize;
		int[] startingSet = {0, 5, 8};
		boolean hasClass;
		Population population;
		Random random;
		Operator randomInit;
		HashMap<String, Object> parameters;
		
		populationSize = 10;
		population = new Population(populationSize);
		sizeOfIndividuals = 10;
		classIndex = sizeOfIndividuals - 1;
		hasClass = true;
		random = new Random();
		parameters = new HashMap<String, Object>();
		parameters.put("random", random);
		parameters.put("startingSet", startingSet);
		parameters.put("populationSize", populationSize);
		parameters.put("classIndex", classIndex);
		parameters.put("sizeOfIndividuals", sizeOfIndividuals);
		parameters.put("hasClass", hasClass);
		
		randomInit = InitializationFactory.getInitializationOperator("RandomInitialization", parameters); 
		
		//System.out.println(population);
		randomInit.execute(population);
		//System.out.println(population);
		
		expectedSize = population.getSize();
		assertTrue(populationSize == expectedSize);
				
	}
	
}

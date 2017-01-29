package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;
import junit.framework.TestCase;

/**
 * Junit test for the Bit Flip Mutation operator
 * 
 * @author Sebastian Luna Valero
 *
 */
public class BitFlipMutationTest extends TestCase {
	
	public BitFlipMutationTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExecute() throws EvolutionaryException, CloneNotSupportedException {
		Random random;
		int individualSize, classIndex, populationSize;
		double probability, total, avg;
		long result, expected;
		HashMap<String, Object> parameters;
		Operator mutation, initOperator;
		Population populationBefore, populationAfter;
		int i;
		boolean hasClass;
		
		populationSize = 10; // number of individuals in the population
		individualSize = 10; // number of bits in the individual
		random = new Random();
		classIndex = individualSize - 1; // the class attribute at the end
		probability = (double) 1 / individualSize; // standard probability
		hasClass = true;
		populationBefore = new Population(populationSize);
		
		parameters = new HashMap<String, Object>();
		parameters.put("random", random);
		parameters.put("classIndex", classIndex);
		parameters.put("probability", probability);
		mutation = MutationFactory.getMutationOperator("BitFlipMutation", parameters);
		
		parameters = new HashMap<String, Object>();
		parameters.put("random", random);
		parameters.put("populationSize", populationSize);
		parameters.put("classIndex", classIndex);
		parameters.put("sizeOfIndividuals", individualSize);
		parameters.put("hasClass", hasClass);
		initOperator = InitializationFactory.getInitializationOperator("RandomInitialization"
		                                                               ,parameters);
		
		initOperator.execute(populationBefore);
//		System.out.println("Population before:");
		populationBefore.toString();
//		System.out.println("---\n\n");
		populationAfter = populationBefore.clone();
		mutation.execute(populationAfter);
//		System.out.println("Population after:");
		populationAfter.toString();
//		System.out.println("---\n\n");		

		total = 0.0;
		for (i = 0; i < populationSize; i++) {
			total += populationBefore.getIndividual(i).countDifferences(populationAfter.getIndividual(i));
		}

		avg = (double) total / populationSize;
		result = Math.round(avg);
		expected = Math.round(individualSize * probability);

//		System.out.println("Result: " + result);
//		System.out.println("Expected: " + expected);
		
		assertTrue(result == expected);
		
	}
	
}

package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;

import junit.framework.TestCase;

/**
 * JUnit test for the Random Selection operator
 * 
 * @author Sebastian Luna Valero
 *
 */
public class RandomSelectionTest extends TestCase {
	
	public RandomSelectionTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
//	public void testExecute() throws EvolutionaryException {
//		int populationSize, sizeOfIndividuals, classIndex;
//		boolean hasClass;
//		Population population;
//		Random random;
//		Operator randomInit;
//		HashMap<String, Object> initializationParams;
//		Operator randomSelec;
//		HashMap<String, Object> selectionParams;
//		Individual[] parents;
//		
//		random = new Random();
//		populationSize = 10;
//		sizeOfIndividuals = 10;
//		classIndex = sizeOfIndividuals - 1;
//		hasClass = true;
//		population = new Population(populationSize);
//		initializationParams = new HashMap<String, Object>();
//		initializationParams.put("random", random);
//		initializationParams.put("populationSize", populationSize);
//		initializationParams.put("sizeOfIndividuals", sizeOfIndividuals);
//		initializationParams.put("classIndex", classIndex);
//		initializationParams.put("hasClass", hasClass);
//		randomInit = InitializationFactory.getInitializationOperator("RandomInitialization"
//				                                                     ,initializationParams);
//		randomInit.execute(population);
//		//System.out.println(population);
//		
//		selectionParams = new HashMap<String, Object>();
//		selectionParams.put("random", random);
//		randomSelec = SelectionFactory.getSelectionOperator("RandomSelection"
//														    ,selectionParams);
//		parents = (Individual[]) randomSelec.execute(population);
//		//System.out.println(parents[0]);
//		//System.out.println(parents[1]);
//		
//	}
	
	public void testExecute() throws EvolutionaryException {
		int populationSize, sizeOfIndividuals, classIndex;
		boolean hasClass;
		Population population, offspring;
		Random random;
		Operator randomInit;
		HashMap<String, Object> initializationParams;
		Operator randomSelec;
		HashMap<String, Object> selectionParams;
		
		random = new Random();
		populationSize = 10;
		sizeOfIndividuals = 10;
		classIndex = sizeOfIndividuals - 1;
		hasClass = true;
		population = new Population(populationSize);
		initializationParams = new HashMap<String, Object>();
		initializationParams.put("random", random);
		initializationParams.put("populationSize", populationSize);
		initializationParams.put("sizeOfIndividuals", sizeOfIndividuals);
		initializationParams.put("classIndex", classIndex);
		initializationParams.put("hasClass", hasClass);
		randomInit = InitializationFactory.getInitializationOperator("RandomInitialization"
				                                                     ,initializationParams);
		randomInit.execute(population);
		System.out.println(population);
		
		selectionParams = new HashMap<String, Object>();
		selectionParams.put("random", random);
		randomSelec = SelectionFactory.getSelectionOperator("RandomSelection"
														    ,selectionParams);
		offspring = (Population) randomSelec.execute(population);
		System.out.println(offspring);
		
	}
	
}

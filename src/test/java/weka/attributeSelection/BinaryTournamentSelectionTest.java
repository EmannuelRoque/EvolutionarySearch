package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;
import junit.framework.TestCase;

public class BinaryTournamentSelectionTest extends TestCase {
	
	public BinaryTournamentSelectionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExecute() throws EvolutionaryException {
		int populationSize, sizeOfIndividuals, classIndex;
		boolean hasClass;
		Population population, offspring;
		Random random;
		Operator randomInit;
		HashMap<String, Object> initializationParams;
		Operator tournamentSelection;
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
		tournamentSelection = SelectionFactory.getSelectionOperator("BinaryTournament"
														    ,selectionParams);
		
		offspring = (Population) tournamentSelection.execute(population);
		System.out.println(offspring);
		
	}

}

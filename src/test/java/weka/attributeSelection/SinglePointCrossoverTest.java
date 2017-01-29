package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;

import junit.framework.TestCase;

public class SinglePointCrossoverTest extends TestCase {
	
	public SinglePointCrossoverTest(String name) {
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
		double crossoverProbability;
		boolean hasClass;
		Population population;
		Random random;
		Operator randomInit;
		HashMap<String, Object> initializationParams;
		Operator singlePointCrossover;
		HashMap<String, Object> crossoverParams;
		
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
		//System.out.println(population);
				
		crossoverProbability = 0.6;
		crossoverParams = new HashMap<String, Object>();
		crossoverParams.put("random", random);
		crossoverParams.put("crossoverProbability", crossoverProbability);
		crossoverParams.put("sizeOfIndividuals", sizeOfIndividuals);
		singlePointCrossover = CrossoverFactory.getCrossoverOperation("SinglePointCrossover",
				                                                      crossoverParams);
		singlePointCrossover.execute(population);
		//System.out.println(population);
		
	}

}

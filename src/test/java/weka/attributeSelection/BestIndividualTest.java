package weka.attributeSelection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import junit.framework.TestCase;

public class BestIndividualTest extends TestCase {

	public BestIndividualTest(String name) {
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
		Population population;
		Random random;
		Operator randomInit;
		HashMap<String, Object> parameters;
		double fitness;
		Iterator<Individual> iterator;
		
		populationSize = 10;
		population = new Population(populationSize);
		sizeOfIndividuals = 10;
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
		
		randomInit.execute(population);
		
		iterator = population.getIterator();
		fitness = 10.0;
		
		while(iterator.hasNext()) {
//			iterator.next().setFitness(random.nextDouble());
			iterator.next().setFitness(fitness);
//			fitness -= 0.1;
		}
		
//		System.out.println(population);
//		System.out.println(population.getBestIndividual());
		
	}
	
}

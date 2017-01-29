package weka.attributeSelection;

import java.util.HashMap;
import java.util.Random;

import junit.framework.TestCase;

public class GenerationalReplacementTest extends TestCase {
	
	public GenerationalReplacementTest(String name) {
		super(name);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testExecute() throws EvolutionaryException {
		Population parents, offspring, result;
		Random random;
		int populationSize, sizeOfIndividuals, classIndex;
		boolean hasClass;
		HashMap<String, Object> initializationParams;
		Operator randomInit;
		HashMap<String, Object> replacementParams;
		Operator generationalReplacement;
		Population[] parentsAndOffspring;
		
		random = new Random();
		populationSize = 10;
		sizeOfIndividuals = 10;
		classIndex = sizeOfIndividuals - 1;
		hasClass = true;
		parents = new Population(populationSize);
		initializationParams = new HashMap<String, Object>();
		initializationParams.put("random", random);
		initializationParams.put("populationSize", populationSize);
		initializationParams.put("sizeOfIndividuals", sizeOfIndividuals);
		initializationParams.put("classIndex", classIndex);
		initializationParams.put("hasClass", hasClass);
		randomInit = InitializationFactory.getInitializationOperator("RandomInitialization"
				                                                     ,initializationParams);
		randomInit.execute(parents);
		System.out.println("Before: parents.");
		System.out.println(parents);
		System.out.println();
		
		offspring = new Population(populationSize);
		randomInit.execute(offspring);
		System.out.println("Before: offspring.");
		System.out.println(offspring);
		System.out.println();
		
		replacementParams = new HashMap<String, Object>();
		// generational replacement has no arguments
		generationalReplacement = ReplacementFactory.getReplacementOperator("GenerationalReplacement"
				                                                            ,replacementParams);
		parentsAndOffspring = new Population[2];
		parentsAndOffspring[0] = parents;
		parentsAndOffspring[1] = offspring;
		result = (Population) generationalReplacement.execute(parentsAndOffspring);
		System.out.println("After: parents");
		System.out.println(parentsAndOffspring[0]);
		System.out.println();
		System.out.println("After: offspring");
		System.out.println(parentsAndOffspring[1]);
		System.out.println();
		System.out.println("After: result");
		System.out.println(result);

	}

}

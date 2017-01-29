
# EvolutionarySearch
An Evolutionary Algorithm (EA) to explore the space of attributes.

This is a package for WEKA:
http://www.cs.waikato.ac.nz/ml/weka/

You can find more information on how to use WEKA packages here:
http://weka.sourceforge.net/packageMetaData/

EvolutionarySearch looks for a good subset of attributes in order to improve the classification accuracy of supervised learning techniques in classification problems with a huge number of attributes involved. It implements a (mu, lambda)-EA (Evolutionary Algorithm) with the following operators: uniform random initialization, binary tournament selection, single point crossover, bit flip mutation and generational replacement with elitism (i.e., the best individual is always kept). This package is properly designed to easily add new operators. Please, see the document entitled developers-guide.pdf available within this package.<br/><br/>For more information about similar algorithms see: <a href="http://neo.lcc.uma.es">the NEO Group website</a>


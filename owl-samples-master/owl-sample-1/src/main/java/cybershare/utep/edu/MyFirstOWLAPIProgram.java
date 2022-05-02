package cybershare.utep.edu;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLClassAssertionAxiom;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLLiteral;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.ConsoleProgressMonitor;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.semanticweb.owlapi.reasoner.OWLReasonerConfiguration;
import org.semanticweb.owlapi.reasoner.OWLReasonerFactory;
import org.semanticweb.owlapi.reasoner.SimpleConfiguration;
import org.semanticweb.owlapi.reasoner.structural.StructuralReasonerFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLNamedIndividual;
import org.semanticweb.owlapi.model.OWLDataPropertyAssertionAxiom;
import org.semanticweb.HermiT.Reasoner;


/**
 * First OWL API exercise 
 * Web-based data ingetration
 * @author Instruction team Spring and Fall 2020 with contributions from L. Garnica
 * @version 2.0
 * Description: The purpose of these file is to provide  basic elements for using the OWLAPI
 * Resources:https://owlcs.github.io/owlapi/  -- OWL-API
 * Include your name here - ex. Modified by Omar Perez for Assignment 3
 *
 */
public class MyFirstOWLAPIProgram 
{
    
    // Here we will change the path to the mentioned ontologies. They are saved in the zip file. Also change the names because some of them 
    //private static final String PEOPLE_IRI = "http://owl.man.ac.uk/2006/07/sssw/people.owl";
    //private static final String PEOPLE_AND_PETS = "/Users/omarperez/Downloads/owl-samples-master/ontologies/PeopleAndPets.owl";
    //private static final String PET_TAXONOMY = "/Users/omarperez/Downloads/owl-samples-master/ontologies/pet-ncbi-taxonomy.owl";
    private static final String BASE = "http://www.semanticweb.org/omarperez/finance.owl";
    private static final String MY_ONTOLOGY = "C:/Users/elija/Dropbox/Elijah Pele/Spring 22/DataMining(Web)/finance_proj/owl-samples-master/ontologies/finance.owl";


    public static void main( String[] args )
    {
        System.out.println( "Running OWL demo" );

        OWLOntologyManager manager = createManager();
        try {
            OWLOntology ontology = loadOntologyFromFile(MY_ONTOLOGY, manager);
            OWLDataFactory dataFactory = manager.getOWLDataFactory();

            //Initializing Reasoner
            ConsoleProgressMonitor progressMonitor = new ConsoleProgressMonitor();
            OWLReasonerConfiguration config = new SimpleConfiguration(progressMonitor);
            OWLReasonerFactory reasonerFactory = new StructuralReasonerFactory();
            OWLReasoner reasoner = reasonerFactory.createReasoner(ontology, config);
            

            //Creating Ontology
            String[] dates = {"01-01-2005", "01-02-2005", "01-03-2005", "01-04-2005", "01-05-2005", "01-06-2005", "01-07-2005", "01-08-2005", "01-09-2005", "01-10-2005", "01-11-2005", "01-12-2005", "01-01-2006", "01-02-2006", "01-03-2006", "01-04-2006", "01-05-2006", "01-06-2006", "01-07-2006", "01-08-2006", "01-09-2006", "01-10-2006", "01-11-2006", "01-12-2006", "01-01-2007", "01-02-2007", "01-03-2007", "01-04-2007", "01-05-2007", "01-06-2007", "01-07-2007", "01-08-2007", "01-09-2007", "01-10-2007", "01-11-2007", "01-12-2007", "01-01-2008", "01-02-2008", "01-03-2008", "01-04-2008", "01-05-2008", "01-06-2008", "01-07-2008", "01-08-2008", "01-09-2008", "01-10-2008", "01-11-2008", "01-12-2008", "01-01-2009", "01-02-2009", "01-03-2009", "01-04-2009", "01-05-2009", "01-06-2009", "01-07-2009", "01-08-2009", "01-09-2009", "01-10-2009", "01-11-2009", "01-12-2009", "01-01-2010", "01-02-2010", "01-03-2010", "01-04-2010", "01-05-2010", "01-06-2010", "01-07-2010", "01-08-2010", "01-09-2010", "01-10-2010", "01-11-2010", "01-12-2010", "01-01-2011", "01-02-2011", "01-03-2011", "01-04-2011", "01-05-2011", "01-06-2011", "01-07-2011", "01-08-2011", "01-09-2011", "01-10-2011", "01-11-2011", "01-12-2011", "01-01-2012", "01-02-2012", "01-03-2012", "01-04-2012", "01-05-2012", "01-06-2012", "01-07-2012", "01-08-2012", "01-09-2012", "01-10-2012", "01-11-2012", "01-12-2012", "01-01-2013", "01-02-2013", "01-03-2013", "01-04-2013", "01-05-2013", "01-06-2013", "01-07-2013", "01-08-2013", "01-09-2013", "01-10-2013", "01-11-2013", "01-12-2013", "01-01-2014", "01-02-2014", "01-03-2014", "01-04-2014", "01-05-2014", "01-06-2014", "01-07-2014", "01-08-2014", "01-09-2014", "01-10-2014", "01-11-2014", "01-12-2014", "01-01-2015", "01-02-2015", "01-03-2015", "01-04-2015", "01-05-2015", "01-06-2015", "01-07-2015", "01-08-2015", "01-09-2015", "01-10-2015", "01-11-2015", "01-12-2015", "01-01-2016", "01-02-2016", "01-03-2016", "01-04-2016", "01-05-2016", "01-06-2016", "01-07-2016", "01-08-2016", "01-09-2016", "01-10-2016", "01-11-2016", "01-12-2016", "01-01-2017", "01-02-2017", "01-03-2017", "01-04-2017", "01-05-2017", "01-06-2017", "01-07-2017", "01-08-2017", "01-09-2017", "01-10-2017", "01-11-2017", "01-12-2017"};
            String[] consumerPriceIndex = {"190.7", "191.8", "193.3", "194.6", "194.4", "194.5", "195.4", "196.4", "198.8", "199.2", "197.6", "196.8", "198.3", "198.7", "199.8", "201.5", "202.5", "202.9", "203.5", "203.9", "202.9", "201.8", "201.5", "201.8", "202.416", "203.499", "205.352", "206.686", "207.949", "208.352", "208.299", "207.917", "208.49", "208.936", "210.177", "210.036", "211.08", "211.693", "213.528", "214.823", "216.632", "218.815", "219.964", "219.086", "218.783", "216.573", "212.425", "210.228", "211.143", "212.193", "212.709", "213.24", "213.856", "215.693", "215.351", "215.834", "215.969", "216.177", "216.33", "215.949", "216.687", "216.741", "217.631", "218.009", "218.178", "217.965", "218.011", "218.312", "218.439", "218.711", "218.803", "219.179", "220.223", "221.309", "223.467", "224.906", "225.964", "225.722", "225.922", "226.545", "226.889", "226.421", "226.23", "225.672", "226.665", "227.663", "229.392", "230.085", "229.815", "229.478", "229.104", "230.379", "231.407", "231.317", "230.221", "229.601", "230.28", "232.166", "232.773", "232.531", "232.945", "233.504", "233.596", "233.877", "234.149", "233.546", "233.069", "233.049", "233.916", "234.781", "236.293", "237.072", "237.9", "238.343", "238.25", "237.852", "238.031", "237.433", "236.151", "234.812", "233.707", "234.722", "236.119", "236.599", "237.805", "238.638", "238.654", "238.316", "237.945", "237.838", "237.336", "236.525", "236.916", "237.111", "238.132", "239.261", "240.229", "241.018", "240.628", "240.849", "241.428", "241.729", "241.353", "241.432", "242.839", "243.603", "243.801", "244.524", "244.733", "244.955", "244.786", "245.519", "246.819", "246.663", "246.669", "246.524"};
            String[] spyPrices = {"105.55", "102.97", "101.11", "104.6", "104.72", "108.37", "106.72", "106.82", "105.05", "109.78", "109.16", "111.52", "112.82", "113.32", "113.93", "110.27", "111.06", "111.22", "114.25", "116.32", "120.41", "122.37", "123.8", "124.25", "121.38", "123.85", "129.3", "134.04", "131.46", "126.47", "128.62", "132.94", "134.14", "129.08", "127.66", "116.21", "118.13", "114.37", "121.34", "121.81", "111.42", "110.99", "113.28", "98.886", "84.311", "77.21", "77.603", "74.031", "63.176", "68.411", "77.143", "79.641", "80.775", "85.938", "88.816", "92.657", "92.604", "95.37", "98.241", "94.21", "96.514", "102.62", "105.32", "96.399", "90.529", "97.558", "92.981", "100.24", "103.72", "102.78", "109.33", "111.57", "115.72", "116.72", "119.93", "117.91", "115.3", "113.36", "107.54", "101.15", "107.86", "109.12", "113.63", "117.65", "122.14", "125.65", "124.86", "115.61", "121.39", "124.54", "126.86", "130.48", "128.05", "128.9", "131.93", "136.29", "137.39", "143.02", "145.52", "149.63", "148.05", "156.07", "151.69", "155.12", "162.52", "167.28", "170.65", "164.2", "171.33", "173.91", "175.37", "179.06", "183.65", "180.26", "187.64", "185.01", "189.78", "193.67", "195.17", "189.27", "199.79", "196.89", "198.92", "201.33", "198.3", "200.9", "189.11", "184.31", "199.89", "200.97", "193.51", "183.4", "188.33", "199.77", "200.77", "204.29", "202.08", "211.11", "211.99", "211.38", "208.71", "217.25", "221.88", "225.06", "233.35", "233.51", "236.57", "239.49", "241.09", "246.15", "246.7", "251.49", "258.04", "258.97", "258.47", "257.73"};
            String[] unemploymentPercentage = {"5.3", "5.4", "5.2", "5.2", "5.1", "5", "5", "4.9", "5", "5", "5", "4.9", "4.7", "4.8", "4.7", "4.7", "4.6", "4.6", "4.7", "4.7", "4.5", "4.4", "4.5", "4.4", "4.6", "4.5", "4.4", "4.5", "4.4", "4.6", "4.7", "4.6", "4.7", "4.7", "4.7", "5", "5", "4.9", "5.1", "5", "5.4", "5.6", "5.8", "6.1", "6.1", "6.5", "6.8", "7.3", "7.8", "8.3", "8.7", "9", "9.4", "9.5", "9.5", "9.6", "9.8", "10", "9.9", "9.9", "9.8", "9.8", "9.9", "9.9", "9.6", "9.4", "9.4", "9.5", "9.5", "9.4", "9.8", "9.3", "9.1", "9", "9", "9.1", "9", "9.1", "9", "9", "9", "8.8", "8.6", "8.5", "8.3", "8.3", "8.2", "8.2", "8.2", "8.2", "8.2", "8.1", "7.8", "7.8", "7.7", "7.9", "8", "7.7", "7.5", "7.6", "7.5", "7.5", "7.3", "7.2", "7.2", "7.2", "6.9", "6.7", "6.6", "6.7", "6.7", "6.2", "6.3", "6.1", "6.2", "6.1", "5.9", "5.7", "5.8", "5.6", "5.7", "5.5", "5.4", "5.4", "5.6", "5.3", "5.2", "5.1", "5", "5", "5.1", "5", "4.9", "4.9", "5", "5", "4.8", "4.9", "4.8", "4.9", "5", "4.9", "4.7", "4.7", "4.7", "4.6", "4.4", "4.4", "4.4", "4.3", "4.3", "4.4", "4.2", "4.1", "4.2", "4.1"};
            String[] averageHousePrice = {"436837", "443513", "450413", "458365", "465652", "472231", "478611", "485241", "491879", "498341", "503102", "507522", "511096", "514407", "517669", "520522", "523489", "525182", "525456", "525191", "523599", "522235", "520817", "519702", "518829", "517649", "515863", "513626", "509903", "505971", "500752", "495657", "489715", "483593", "477547", "470904", "464521", "456471", "446819", "435600", "424103", "413409", "402362", "391960", "382506", "374585", "366428", "358645", "351485", "346993", "342932", "338854", "334861", "331578", "329358", "327379", "325894", "325378", "327115", "329744", "331920", "332303", "333509", "335004", "336600", "335879", "334160", "331707", "329564", "327227", "325309", "324126", "323164", "322122", "320281", "318513", "315580", "313764", "312089", "310075", "307594", "305068", "304407", "303818", "303605", "303349", "303493", "304198", "305456", "307251", "309303", "311640", "314267", "317810", "321729", "327203", "332789", "339247", "345822", "352917", "360060", "367557", "374693", "381300", "387137", "392629", "398199", "403481", "408896", "413548", "416030", "416958", "417294", "417842", "418307", "418103", "418798", "420429", "423185", "425666", "428296", "431104", "434165", "436313", "438613", "440267", "440944", "442255", "444478", "448273", "451304", "455460", "459350", "462760", "464540", "466856", "469096", "471474", "472095", "473707", "475554", "479177", "482052", "484623", "487546", "490555", "493555", "496054", "499025", "502380", "503933", "505651", "508021", "512221", "516541", "52083"};

            for(int i = 0; i < dates.length; i++){
                // Dates
                addClassIndividual(ontology, manager, dataFactory, dates[i], "date");
                OWLDataProperty dateIndexDataPropoerty = dataFactory.getOWLDataProperty(BASE + "#date");
                OWLNamedIndividual datePriceIndexInstance = dataFactory.getOWLNamedIndividual(BASE + "#" + dates[i]);
                OWLDataPropertyAssertionAxiom dataPropertyAssertion = dataFactory.getOWLDataPropertyAssertionAxiom(dateIndexDataPropoerty, datePriceIndexInstance, dates[i]);
                manager.addAxiom(ontology, dataPropertyAssertion);

                // CPI 
                addClassIndividual(ontology, manager, dataFactory, consumerPriceIndex[i], "consumerPriceIndex");
                addObjectPropertyAssertion(ontology, manager, dataFactory, consumerPriceIndex[i], dates[i], "registeredInDate");
                
                OWLDataProperty consumerPriceIndexDataPropoerty = dataFactory.getOWLDataProperty(BASE + "#consumerPriceIndex");
                OWLNamedIndividual consumerPriceIndexInstance = dataFactory.getOWLNamedIndividual(BASE + "#" + consumerPriceIndex[i]);
                dataPropertyAssertion = dataFactory.getOWLDataPropertyAssertionAxiom(consumerPriceIndexDataPropoerty, consumerPriceIndexInstance, Double.parseDouble(consumerPriceIndex[i]));
                manager.addAxiom(ontology, dataPropertyAssertion);
                
                // SPY Prices
                addClassIndividual(ontology, manager, dataFactory, spyPrices[i], "spyPrice");
                addObjectPropertyAssertion(ontology, manager, dataFactory, spyPrices[i], dates[i], "registeredInDate");
                
                OWLDataProperty spyPriceDataPropoerty = dataFactory.getOWLDataProperty(BASE + "#spyPrice");
                OWLNamedIndividual spyPriceInstance = dataFactory.getOWLNamedIndividual(BASE + "#" + spyPrices[i]);
                dataPropertyAssertion = dataFactory.getOWLDataPropertyAssertionAxiom(spyPriceDataPropoerty, spyPriceInstance, Double.parseDouble(spyPrices[i]));
                manager.addAxiom(ontology, dataPropertyAssertion);

                // Unemploymnent
                addClassIndividual(ontology, manager, dataFactory, unemploymentPercentage[i], "unemploymentPercentage");
                addObjectPropertyAssertion(ontology, manager, dataFactory, unemploymentPercentage[i], dates[i], "registeredInDate");
                
                OWLDataProperty unemploymentDataPropoerty = dataFactory.getOWLDataProperty(BASE + "#unemploymentPercentage");
                OWLNamedIndividual unemploymentInstance = dataFactory.getOWLNamedIndividual(BASE + "#" + unemploymentPercentage[i]);
                dataPropertyAssertion = dataFactory.getOWLDataPropertyAssertionAxiom(unemploymentDataPropoerty, unemploymentInstance, Double.parseDouble(unemploymentPercentage[i]));
                manager.addAxiom(ontology, dataPropertyAssertion);

                // House prices
                addClassIndividual(ontology, manager, dataFactory, averageHousePrice[i], "averageHousePrice");
                addObjectPropertyAssertion(ontology, manager, dataFactory, averageHousePrice[i], dates[i], "registeredInDate");
                OWLDataProperty averageHousePriceDataPropoerty = dataFactory.getOWLDataProperty(BASE + "#averageHousePrice");
                OWLNamedIndividual averageHousePriceInstance = dataFactory.getOWLNamedIndividual(BASE + "#" + averageHousePrice[i]);
                dataPropertyAssertion = dataFactory.getOWLDataPropertyAssertionAxiom(averageHousePriceDataPropoerty, averageHousePriceInstance, Integer.parseInt(averageHousePrice[i]));
                manager.addAxiom(ontology, dataPropertyAssertion);
            }

            saveOntology(MY_ONTOLOGY, manager, ontology);


            //Compute Inferences
            reasoner.precomputeInferences();
            getValuesWithinDateRange(ontology, manager, dataFactory, reasoner, "spyPrice", "01-01-2010", "01-01-2020");

            //Printing all instances of Class

            /*OWLClass spy = dataFactory.getOWLClass(IRI.create(BASE+"#spyPrice"));
            NodeSet<OWLNamedIndividual> individualsNodeSet = reasoner.getInstances(spy,true);
            // The reasoner returns a NodeSet. We just want the individuals, so get a flattened set.
            Set<OWLNamedIndividual> individuals = individualsNodeSet.getFlattened();
            System.out.println("Instances of Spy Prices: ");
            OWLObjectProperty dp = dataFactory.getOWLObjectProperty(IRI.create(BASE + "#registeredInDate"));



            for (OWLNamedIndividual ind : individuals) {
                String [] array = (ind.toString()).split("#"); 
                String value = array[1].split(">")[0];
               // System.out.println("    $" + value);
                NodeSet<OWLNamedIndividual> nodeSetInstances = reasoner.getObjectPropertyValues(ind, dp);
                Set<OWLNamedIndividual> instances = nodeSetInstances.getFlattened();
                for(OWLNamedIndividual instance: instances)
                {
                    String [] array2 = (instance.toString()).split("#"); 
                    String value2 = array2[1].split(">")[0];
                   // System.out.println("    " + value2);
                    Date date1 = new SimpleDateFormat("MM-dd-yyyy").parse(value2); 
                    Date date2 = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-2015");
                    Date date3 = new SimpleDateFormat("MM-dd-yyyy").parse("01-01-2018");

                    if(date1.after(date2) && date1.before(date3)){
                        System.out.println(value2);
                    }
                }

            }
            System.out.println("\n");
            */
        } catch (OWLOntologyCreationException | OWLOntologyStorageException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void getValuesWithinDateRange(OWLOntology ontology, OWLOntologyManager manager, OWLDataFactory dataFactory, OWLReasoner reasoner, String className, String startDate, String endDate){
       try{
        OWLObjectProperty dp = dataFactory.getOWLObjectProperty(IRI.create(BASE + "#registeredInDate"));
        OWLClass c = dataFactory.getOWLClass(IRI.create(BASE+"#"+className));
        NodeSet<OWLNamedIndividual> individualsNodeSet = reasoner.getInstances(c,true);
        Set<OWLNamedIndividual> individuals = individualsNodeSet.getFlattened();
        for (OWLNamedIndividual ind : individuals) { 
            String [] array = (ind.toString()).split("#"); 
            String value = array[1].split(">")[0];
            NodeSet<OWLNamedIndividual> nodeSetInstances = reasoner.getObjectPropertyValues(ind, dp);
            Set<OWLNamedIndividual> instances = nodeSetInstances.getFlattened();
            for(OWLNamedIndividual instance: instances)
            {
                String [] array2 = (instance.toString()).split("#"); 
                String value2 = array2[1].split(">")[0];
               // System.out.println("    " + value2);
                Date date1 = new SimpleDateFormat("MM-dd-yyyy").parse(value2); 
                Date date2 = new SimpleDateFormat("MM-dd-yyyy").parse(startDate);
                Date date3 = new SimpleDateFormat("MM-dd-yyyy").parse(endDate);


               if(date1.after(date2) && date1.before(date3)){
                    System.out.println("$"+value+"   "+value2);
                }
            }
        }
    }catch(ParseException e){
        e.printStackTrace();
    }
}


    /**
     * Creates a new ontology manager
     * @return
     */
    public static OWLOntologyManager createManager(){
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        return manager;
    }

    /**
     * Load an ontology to memory from URI source
     * @param source
     * @param manager
     */
    public static OWLOntology loadOntologyFromURI(String source, OWLOntologyManager manager) throws OWLOntologyCreationException {
        IRI iri = IRI.create(source);
        OWLOntology ontology;
        ontology = manager.loadOntologyFromOntologyDocument(iri);
        System.out.println("Loaded ontology: " + ontology);
        return ontology;
    }

    /**
     * Load ontology from local file
     * @param path
     * @param manager
     * @return
     * @throws OWLOntologyCreationException
     */
    public static OWLOntology loadOntologyFromFile(String path, OWLOntologyManager manager) throws OWLOntologyCreationException {
        File file = new File(path);
        // Load local ontology
        OWLOntology ontology = manager.loadOntologyFromOntologyDocument(file);
        System.out.println("Loaded ontology: " + ontology);
        // We can always obtain the location where an ontology was loaded from
        IRI documentIRI = manager.getOntologyDocumentIRI(ontology);
        System.out.println("    from: " + documentIRI);
        return ontology;
    }


    /**
     * Insert individual to a class
     * @param ontology
     * @param manager
     * @param dataFactory
     * @param subjectName
     * @param className
     * @return
     */
    public static void addClassIndividual(OWLOntology ontology, OWLOntologyManager manager, OWLDataFactory dataFactory, String subjectName, String className){
        OWLIndividual subject = dataFactory.getOWLNamedIndividual(IRI.create(BASE + "#" + subjectName));
        OWLClass someClass = dataFactory.getOWLClass(IRI.create(BASE + "#" + className));
        OWLClassAssertionAxiom ax = dataFactory.getOWLClassAssertionAxiom(someClass, subject);
        manager.addAxiom(ontology, ax);
    }

    /**
     * Add object property assertion (between individuals)
     * @param ontology
     * @param manager
     * @param dataFactory
     * @param individual_1
     * @param individual_2
     * @param property
     */
    public static void addObjectPropertyAssertion(OWLOntology ontology, OWLOntologyManager manager, OWLDataFactory dataFactory, String individual_1, String individual_2, String property){
        OWLIndividual i1 = dataFactory.getOWLNamedIndividual(IRI.create(BASE + "#" + individual_1));
        OWLIndividual i2 = dataFactory.getOWLNamedIndividual(IRI.create(BASE + "#" + individual_2));
        OWLObjectProperty o = dataFactory.getOWLObjectProperty(IRI.create(BASE + "#" + property));

        OWLAxiom assertion = dataFactory.getOWLObjectPropertyAssertionAxiom(o, i1, i2);
        manager.addAxiom(ontology, assertion);
    }


    /**
     * save ontology locally to specific path
     * @param path
     * @param manager
     * @param ontology
     * @throws IOException
     * @throws OWLOntologyStorageException
     */
    public static void saveOntology(String path, OWLOntologyManager manager, OWLOntology ontology) 
        throws IOException, OWLOntologyStorageException {
        File file = new File(path);

        // default format as they are loaded e.g. xml, turtle
        manager.saveOntology(ontology, IRI.create(file.toURI()));
        System.out.println("Ontology was saved");
    }


}

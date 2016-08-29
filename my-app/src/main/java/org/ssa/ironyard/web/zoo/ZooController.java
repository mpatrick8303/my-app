package org.ssa.ironyard.web.zoo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.ssa.ironyard.web.zoo.Animals.Continents;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/zoo")
public class ZooController
{

        static final Logger LOGGER = LogManager.getLogger(ZooController.class);

        @ModelAttribute 
        public void setResponseHeader(HttpServletResponse response)
        {
            response.setHeader("X-Powered-By","SSA Zoo");
        }
        
        @RequestMapping("/animals")
        ResponseEntity<List<String>>animals()
        {

            List<String> listOfAnimalStrings = new ArrayList<>();
            
            for(int i = 0;i < makeAnimals().size();i++)
            {
                listOfAnimalStrings.add(convertZooAnimalJson(zooAnimals().get(i)));
                
            }
            LOGGER.debug(listOfAnimalStrings);
            return ResponseEntity.ok().body(listOfAnimalStrings);
        }
        
        
        

        
        @RequestMapping("/animals/{animal}")
        ResponseEntity<String>animal(@PathVariable String animal)
        {
            
            for(int i = 0; i < makeAnimals().size();i++)
            {
                if(makeAnimals().get(i).getAnimal().equals(animal))
                    return ResponseEntity.ok().body(convertAnimalJson(makeAnimals().get(i)));
            }
            return ResponseEntity.ok().body(convertAnimalJson(notInZoo()));
        }

        @RequestMapping("/animals/search/continents/{continent}")
        ResponseEntity<List<String>>searchContinents(@PathVariable String continent)
        {
            List<String> searchContinents = new ArrayList<>();
            
            for(int i = 0;i < makeAnimals().size();i++)
            {
                if(makeAnimals().get(i).getContinents().contains(continent))
                {
                    searchContinents.add(convertZooAnimalJson(zooAnimals().get(i)));
                }
            }
            
            return ResponseEntity.ok().body(searchContinents);
        }
            
    


       
    
    
    public List<Animals> makeAnimals()
    {
        List<Animals> animalList = new ArrayList<>();
       

        
        
        animalList.add(new Animals("aardvark",continents("aardvark"),"It's somtimes colloquially called African ant bear"));
        animalList.add(new Animals("baboon",continents("baboon"),"They are some of the largest non-hominoid members of the primate order"));
        animalList.add(new Animals("chimpanzee",continents("chimpanzee"),"One of the largest-brained, and most intelligent of primates"));
        animalList.add(new Animals("donkey",continents("donkey"),"Has been used as a working animal for at least 5000 years"));
        animalList.add(new Animals("elephant",continents("elephant"),"Male elephants are the largest extant terrestrial anmimal"));
        animalList.add(new Animals("fish",continents("fish"),"They all breath underwater"));
        animalList.add(new Animals("gorilla",continents("gorilla"),"Their DNA is highly similar to that of humans"));
        animalList.add(new Animals("horse",continents("horse"),"They are able to sleep both standing and lying down"));
        animalList.add(new Animals("iguana",continents("iguana"),"THey have a tiny third eye on their head that senses light"));
        animalList.add(new Animals("jackalope",continents("jakalope"),"Not real"));
        animalList.add(new Animals("kangaroo",continents("kangaroo"),"Around 34.3 million kangaroos lived in Australia in 2011"));
        animalList.add(new Animals("loris",continents("loris"),"They are nocturnal"));
        animalList.add(new Animals("manatee",continents("manatee"),"They can weigh as much as 1,300 lbs"));
        animalList.add(new Animals("nightingale",continents("nightingale"),"It's song is described as one of the most beautiful sounds in nature"));
        animalList.add(new Animals("orangutan",continents("orangutan"),"They spend most of their time in trees"));
        animalList.add(new Animals("piranha",continents("piranha"),"They have one of the strongest bites found in bony fish"));
        animalList.add(new Animals("quail",continents("quail"),"In 2007 40 million quail were produced in the U.S."));
        animalList.add(new Animals("rhinoceros",continents("rhinoceros"),"Their skin is 1.5-5cm thick"));
        animalList.add(new Animals("squirrel",continents("squirrel"),"The earliest known squirrels date from the Eocene"));
        animalList.add(new Animals("tree_frog",continents("tree_frog"),"They live in trees"));
        animalList.add(new Animals("unicorn",continents("unicorn"),"Surfing rainbows"));
        animalList.add(new Animals("velociraptor",continents("velociraptor"),"Thought to have feathers"));
        animalList.add(new Animals("whale",continents("whale"),"They range from 8.5 feet to 98 feet"));
        animalList.add(new Animals("xray_tetra",continents("xray_tetra"),"Lives in large groups"));
        animalList.add(new Animals("yak",continents("yak"),"One of the largest bovids"));
        animalList.add(new Animals("zebu",continents("zebu"),"In 1999 researches at Texas A&M Univeristy successfully cloned it"));
      
        
        return animalList;
        
    }
    
    public List<ZooAnimals> zooAnimals()
    {
        List<ZooAnimals> zooAnimals = new ArrayList<>();
        
        for(int i = 0; i < makeAnimals().size();i++)
        {
            zooAnimals.add(new ZooAnimals(makeAnimals().get(i).getAnimal()));
        }
        
        return zooAnimals;
    }
    
    
    public Animals notInZoo()
    {
        Animals not = new Animals(" ");
        return not;
    }
    
    public List<Continents> continents(String animalName)
    {
        Map<String,List<Continents>> ac = new HashMap<>();
        
        ac.put("aardvark", Arrays.asList(Animals.Continents.AFRICA));//aardvark
        ac.put("baboon", Arrays.asList(Animals.Continents.AFRICA));//baboon
        ac.put("chimpanzee", Arrays.asList(Animals.Continents.AFRICA));//chimp
        ac.put("donkey", Arrays.asList(Animals.Continents.values()));//donkey
        ac.put("elephant", Arrays.asList(Animals.Continents.AFRICA,Animals.Continents.ASIA));//elephant
        ac.put("fish", Arrays.asList(Animals.Continents.OCEAN));//fish
        ac.put("gorilla", Arrays.asList(Animals.Continents.AFRICA));//gorilla
        ac.put("horse", Arrays.asList(Animals.Continents.values()));//horse
        ac.put("iguana", Arrays.asList(Animals.Continents.NORTH_AMERICA, Animals.Continents.SOUTH_AMERICA));//iguana
        ac.put("jakalope", Arrays.asList(Animals.Continents.FANTASY_LAND));//jackalope
        ac.put("kangaro", Arrays.asList(Animals.Continents.AUSTRALIA));//kangaro
        ac.put("loris", Arrays.asList(Animals.Continents.ASIA));//loris
        ac.put("manatee", Arrays.asList(Animals.Continents.OCEAN));//manate
        ac.put("nightangale", Arrays.asList(Animals.Continents.EUROPE,Animals.Continents.ASIA,Animals.Continents.AFRICA));//nightangale
        ac.put("orangutan", Arrays.asList(Animals.Continents.ASIA));//orangatang
        ac.put("piranha", Arrays.asList(Animals.Continents.SOUTH_AMERICA));//piranha
        ac.put("quail", Arrays.asList(Animals.Continents.NORTH_AMERICA, Animals.Continents.EUROPE, Animals.Continents.ASIA, Animals.Continents.AFRICA, Animals.Continents.SOUTH_AMERICA, Animals.Continents.SOUTH_AMERICA));//quail
        ac.put("rhinoceros", Arrays.asList(Animals.Continents.AFRICA, Animals.Continents.ASIA));//rhino
        ac.put("squirrel", Arrays.asList(Animals.Continents.NORTH_AMERICA, Animals.Continents.EUROPE, Animals.Continents.ASIA, Animals.Continents.AFRICA, Animals.Continents.SOUTH_AMERICA, Animals.Continents.SOUTH_AMERICA));//squirrel
        ac.put("tree_frog", Arrays.asList(Animals.Continents.NORTH_AMERICA, Animals.Continents.EUROPE, Animals.Continents.ASIA, Animals.Continents.AFRICA, Animals.Continents.SOUTH_AMERICA, Animals.Continents.SOUTH_AMERICA));//tree frog
        ac.put("unicorn", Arrays.asList(Animals.Continents.FANTASY_LAND));//unicorn
        ac.put("velociraptor", Arrays.asList(Animals.Continents.PANGAEA));//velociraptor
        ac.put("whale", Arrays.asList(Animals.Continents.OCEAN));//whale
        ac.put("xray_tetra", Arrays.asList(Animals.Continents.ASIA));//xray tetra
        ac.put("yak", Arrays.asList(Animals.Continents.ASIA));//yak
        ac.put("zebu", Arrays.asList(Animals.Continents.ASIA));//zebu
    
        return ac.get(animalName);
        
    }
    
    
    
    private String convertAnimalJson(Animals animal) 
    {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        String jsonInString2 = null;

        

        try {
            // Convert object to JSON string and save into a file directly
//            mapper.writeValue(new File("C:/javaproject/maven/my-app/animal.json"), animal);
            
            // Convert object to JSON string
            jsonInString = mapper.writeValueAsString(animal);
            //LOGGER.debug(jsonInString);
            
    

            // Convert object to JSON string and pretty print
            jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(animal);
            //LOGGER.debug(jsonInString2);
     
            
           

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
        
    }
    
    private String convertZooAnimalJson(ZooAnimals animal) 
    {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = null;
        String jsonInString2 = null;

        

        try {
            // Convert object to JSON string and save into a file directly
//            mapper.writeValue(new File("C:/javaproject/maven/my-app/animal.json"), animal);
            
            // Convert object to JSON string
            jsonInString = mapper.writeValueAsString(animal);
            //LOGGER.debug(jsonInString);
            
    

            // Convert object to JSON string and pretty print
            jsonInString2 = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(animal);
            //LOGGER.debug(jsonInString2);
     
            
           

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonInString;
        
    }

    
    
   

}

package org.ssa.ironyard.web.zoo;

import java.util.List;

public class ZooAnimals
{
   
        private String animal;
        private String url;
        
        public ZooAnimals(String animal)
        {
            this.animal = animal;
            this.url = "localhost:8080/zoo/animals/" + animal;
        }
              

        public String getAnimal()
        {
            return animal;
        }

        public String getUrl()
        {
            return url;
        }
        
        
}

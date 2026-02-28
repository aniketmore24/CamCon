package com.demo.CamCon.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "feed")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String knowledge;
    private String punctuality;
    private String speed;
    private String suggestion;
    private String infrastructure;
    private String cleanliness;
    private String module;
    
    public Feedback() {
    }

    

    public Feedback(int id, String knowledge, String punctuality, String speed, String suggestion,
            String infrastructure, String cleanliness, String module) {
        this.id = id;
        this.knowledge = knowledge;
        this.punctuality = punctuality;
        this.speed = speed;
        this.suggestion = suggestion;
        this.infrastructure = infrastructure;
        this.cleanliness = cleanliness;
        this.module = module;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getPunctuality() {
        return punctuality;
    }

    public void setPunctuality(String punctuality) {
        this.punctuality = punctuality;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getInfrastructure() {
        return infrastructure;
    }

    public void setInfrastructure(String infrastructure) {
        this.infrastructure = infrastructure;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }



    @Override
    public String toString() {
        return "Feedback [id=" + id + ", knowledge=" + knowledge + ", punctuality=" + punctuality + ", speed=" + speed
                + ", suggestion=" + suggestion + ", infrastructure=" + infrastructure + ", cleanliness=" + cleanliness
                + ", module=" + module + "]";
    }

    
    
    


    
   

}

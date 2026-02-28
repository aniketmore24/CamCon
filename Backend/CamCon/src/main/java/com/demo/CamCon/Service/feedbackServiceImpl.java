package com.demo.CamCon.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Service.*;
import com.demo.CamCon.Dao.*;

@Service
public class feedbackServiceImpl implements feedbackServiceIf{

    @Autowired
    FeedbackRepositoryImpl feedbackRepository;


    @Override
    public Feedback saveFeedback(Feedback fb) {
        
        return feedbackRepository.save(fb);
    }


   


    @Override
    public List<Feedback> getDataByModule(String module) {
        
    
    return feedbackRepository.findBymodule(module);
    }

   
    
    
    
}

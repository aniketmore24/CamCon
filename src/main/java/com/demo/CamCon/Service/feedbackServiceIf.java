package com.demo.CamCon.Service;

import java.util.List;

import com.demo.CamCon.Beans.*;


public interface feedbackServiceIf {

    Feedback saveFeedback(Feedback u1);

    

    List<Feedback> getDataByModule(String module);

}

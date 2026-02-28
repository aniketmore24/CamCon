package com.demo.CamCon.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Service.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private feedbackServiceIf feedbackService;

    @PostMapping("/submit")
    public Feedback addData(@RequestBody Feedback fb) {

        // Feedback fb = new Feedback();
        System.out.println(fb);
        Feedback fb1 = feedbackService.saveFeedback(fb);
        System.out.println(fb1);
        return fb1;

    }

    @GetMapping("/getbymodule/{module}")
    public List<Feedback> getDataByModule(@PathVariable String module){

        return feedbackService.getDataByModule(module);
    }
}

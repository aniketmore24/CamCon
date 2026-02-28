package com.demo.CamCon.Controller;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Dao.*;
import com.demo.CamCon.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/Report")
public class ReportDTOController {

    @Autowired
    private DiscussionPostRepository discussionPostRepository;

    @Autowired
    private ReportDTOService reportDTOService;

    public String reportPost(@RequestBody ReportDTO reportDTO){
        Optional<DiscussionPost> discussionPost = discussionPostRepository.findById(reportDTO.getId());
        if(!discussionPost.isPresent()){
            return "No Such comment exists";
        }
        reportDTOService.reportPost(reportDTO);
        return "Post is under scrutiny of admin";
    }
}

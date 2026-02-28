package com.demo.CamCon.Service;

import com.demo.CamCon.Beans.*;
import com.demo.CamCon.Dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportDTOServiceImpl implements ReportDTOService{

    @Autowired
    private ReportDTORepository reportDTORepository;

    @Override
    public ReportDTO reportPost(ReportDTO reportDTO) {
        return reportDTORepository.save(reportDTO);
    }
}

package rmit.job.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rmit.job.atm.model.Job;
import rmit.job.atm.repository.JobRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class JobController {

//    @Autowired
//    private JobRepository jobRepository;
//
//    @GetMapping(value = "/jobs/getAllByCategory/{cateId}")
//    public List<Job> getAllJobsByCategoryId(@PathVariable("cateId") Long cid) {
//        return jobRepository.findByCategoryId(cid);
//    }
}

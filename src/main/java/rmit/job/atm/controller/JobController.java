package rmit.job.atm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rmit.job.atm.model.Job;
import rmit.job.atm.repository.JobRepository;

import java.util.Optional;

import static rmit.job.atm.controller.ResponseUtil.resourceUri;

@RestController
@RequestMapping(value = "/api")
public class JobController {

    @Autowired
    private JobRepository jobRepository;

    @GetMapping(value = "/jobs")
    public Page<Job> getAllJobs(Pageable pageable) {
        return jobRepository.findAll(pageable);
    }

    @GetMapping(value = "/jobs/{id}")
    public Optional<Job> getById(@PathVariable("id") Long pid) {
        return jobRepository.findById(pid);
    }

//    @GetMapping(value = "/getAllByCategory/{cateId}")
//    public List<Job> getAllJobsByCategoryId(@PathVariable("cateId") Long cid) {
//        return jobRepository.findByCategoryId(cid);
//    }

    @PostMapping(value = "/jobs")
    public ResponseEntity<Job> saveJob(@RequestBody Job reqJob) {
        Job job = null;
        try {
            job = jobRepository.save(reqJob);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
        return new ResponseEntity<>(job, HttpStatus.OK);
    }

    @PutMapping(value = "/jobs/{id}")
    public ResponseEntity<Job> updateJob(@PathVariable("id") Long jobId,
                                   @RequestBody Job reqJob) {
        return jobRepository.findById(jobId)
                .map(job -> {
                    job.setLocation(reqJob.getLocation());
                    job.setPostalCode(reqJob.getPostalCode());
                    job.setSalaryRangeMax(reqJob.getSalaryRangeMax());
                    job.setSalaryRangeMin(reqJob.getSalaryRangeMin());
                    job.setTitle(reqJob.getTitle());
                    return job;
                })
                .map(jobRepository::save)
                .map(category -> ResponseEntity
                        .ok()
                        .location(resourceUri(jobId))
                        .body(category))
                .orElseThrow(
                        () -> new ResourceNotFoundException("CategoryID " + jobId + " not found")
                );
    }

    @DeleteMapping(value = "/jobs/{id}")
    public ResponseEntity<?> deleteJob(@PathVariable("id") Long jobId) {
        return jobRepository.findById(jobId)
                .map(job -> {
                    jobRepository.delete(job);
                    return ResponseEntity.ok().build();
                })
                .orElseThrow(
                        () ->new ResourceNotFoundException("JobId " + jobId + " not found!")
                );
    }
}

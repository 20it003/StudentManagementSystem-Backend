package in.ac.charusat.studentmgmtsystem.controller;

import in.ac.charusat.studentmgmtsystem.model.Result;
import in.ac.charusat.studentmgmtsystem.repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResultController {
    @Autowired
    ResultRepository resultRepository;


    @GetMapping("/getResultList")
    public List<Result> ResultList(){
        return resultRepository.findAll();
    }

    @GetMapping("/getResult/{id}")
    public Result getResult(@PathVariable Integer id) {
        return resultRepository.findById(id).get();
    }

    // Delete the result
    @DeleteMapping("/result/{id}")
    public List<Result> deleteResult(@PathVariable Integer id) {
        resultRepository.delete(resultRepository.findById(id).get());
        return resultRepository.findAll();
    }

    // Add new student
    @PostMapping("/result")
    public List<Result> addResult(@RequestBody Result result) {
        resultRepository.save(result);
        return resultRepository.findAll();
    }

    // Update the student information
    @PutMapping("/result/{id}")
    public List<Result> UpdateResult(@RequestBody Result result, @PathVariable Integer id) {
        Result resultObj = resultRepository.findById(id).get();
        resultObj.setSemester(result.getSemester());
        resultObj.setResult(result.getResult());
        resultRepository.save(resultObj);
        return resultRepository.findAll();
    }
}
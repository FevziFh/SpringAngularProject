package fevz.Employermanager.service;

import fevz.Employermanager.exception.UserNotFoundException;
import fevz.Employermanager.model.Employer;
import fevz.Employermanager.repo.EmployerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployerService {
    private final EmployerRepo employerRepo;
    @Autowired
    public EmployerService(EmployerRepo employerRepo) {
        this.employerRepo = employerRepo;
    }
    public Employer addEmployer(Employer employer){
        employer.setEmployerCode(UUID.randomUUID().toString());
        return employerRepo.save(employer);
    }
    public List<Employer> findAllEmployers(){
        return employerRepo.findAll();
    }
    public Employer updateEmployer(Employer employer){
        return employerRepo.save(employer);
    }
    public Employer findEmployerById(Long id){
        return employerRepo.findEmployerById(id).orElseThrow(()-> new UserNotFoundException("User by id" +id+"was nor found"));
    }
    public void deleteEmployer(Long id){
       employerRepo.deleteEmployerById(id);
    }
}

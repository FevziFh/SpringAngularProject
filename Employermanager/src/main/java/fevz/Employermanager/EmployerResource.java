package fevz.Employermanager;

import fevz.Employermanager.model.Employer;
import fevz.Employermanager.service.EmployerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerResource {
    public final EmployerService employerService;

    public EmployerResource(EmployerService employerService) {
        this.employerService = employerService;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Employer>> getAllEmployer(){
        List<Employer> employers= employerService.findAllEmployers();
        return new ResponseEntity<>(employers, HttpStatus.OK);
    }
    @GetMapping("/find/{id}")
    public ResponseEntity<Employer> getEmployerById(@PathVariable("id") Long id){
        Employer employer= employerService.findEmployerById(id);
        return new ResponseEntity<>(employer, HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<Employer> addEmployer(@RequestBody Employer employer)
    {
        Employer newEmployer = employerService.addEmployer(employer);
        return new ResponseEntity<>(newEmployer,HttpStatus.CREATED);
    }
    @PutMapping("/update")
    public ResponseEntity<Employer> updateEmployer(@RequestBody Employer employer)
    {
        Employer updateEmployer = employerService.updateEmployer(employer);
        return new ResponseEntity<>(updateEmployer ,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Employer> deleteEmployer(@PathVariable("id") Long id)
    {
        employerService.deleteEmployer(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

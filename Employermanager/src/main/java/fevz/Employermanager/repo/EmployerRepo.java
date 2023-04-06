package fevz.Employermanager.repo;

import fevz.Employermanager.model.Employer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployerRepo extends JpaRepository<Employer,Long> {
    void deleteEmployerById(Long id);

    Optional<Employer> findEmployerById(Long id);
}

package otms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;

import otms.model.Trip;

// This will be AUTO IMPLEMENTED by Spring into a Bean called tripRepository
// CRUD refers Create, Read, Update, Delete

public interface TripRepository extends CrudRepository<Trip, Integer> {
    Collection<Trip> findAll();
    @Query(value = "SELECT * FROM trip WHERE empId = ?1", nativeQuery = true)
    Collection<Trip> findByEmpId(Integer empId);
}

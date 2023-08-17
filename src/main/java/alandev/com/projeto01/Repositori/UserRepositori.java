package alandev.com.projeto01.Repositori;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import alandev.com.projeto01.Entities.Usua;

public interface UserRepositori extends JpaRepository<Usua, Long> {
    @Query("SELECT obj FROM Usua obj WHERE  obj.salary >=:minisalry AND obj.salary <=:maxsalary")
    Page<Usua> searchSalary(Double maxsalary, Double minisalry, Pageable pageable);

    @Query("SELECT obj FROM Usua obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
    Page<Usua> findBuscanome(String name, Pageable pageable);

}

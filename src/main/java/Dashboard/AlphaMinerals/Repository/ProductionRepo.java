package Dashboard.AlphaMinerals.Repository;

import Dashboard.AlphaMinerals.Model.Production;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface ProductionRepo extends JpaRepository<Production,Integer> {
    Production findProductionByID(Integer max);
    @Query("SELECT p From Production p WHERE p.date= :date AND p.heure <= :timeNow ")
    List<Production> findProductionByDateAndHeure2(@Param("date") String s,@Param("timeNow") LocalTime now);


}

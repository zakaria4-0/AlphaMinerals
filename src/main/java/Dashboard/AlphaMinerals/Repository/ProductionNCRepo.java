package Dashboard.AlphaMinerals.Repository;

import Dashboard.AlphaMinerals.Model.ProductionNC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalTime;
import java.util.List;

public interface ProductionNCRepo extends JpaRepository<ProductionNC,Integer> {
    ProductionNC findProductionNCByID(Integer max);

    @Query("SELECT p From ProductionNC p WHERE p.date= :date AND p.heure <= :timeNow ")
    List<ProductionNC> findProductionNCByDateAndHeure2(@Param("date") String s,@Param("timeNow") LocalTime now);
}

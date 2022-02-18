package Dashboard.AlphaMinerals.Service;

import Dashboard.AlphaMinerals.Model.Production;
import Dashboard.AlphaMinerals.Model.ProductionNC;
import Dashboard.AlphaMinerals.Repository.ProductionNCRepo;
import Dashboard.AlphaMinerals.Repository.ProductionRepo;

import javax.transaction.Transactional;
import java.time.LocalTime;
import java.util.List;

@org.springframework.stereotype.Service
@Transactional
public class Service {
    private final ProductionRepo productionRepo;
    private final ProductionNCRepo productionNCRepo;

    public Service(ProductionRepo productionRepo, ProductionNCRepo productionNCRepo) {
        this.productionRepo = productionRepo;
        this.productionNCRepo = productionNCRepo;
    }





    public Production getProductionByID(Integer max) {
        return productionRepo.findProductionByID(max);
    }





    public ProductionNC getProductionNCByID(Integer max) {
        return productionNCRepo.findProductionNCByID(max);
    }



    public List<Production> getProductionByDateAndHeure(String s, LocalTime now) {
        return productionRepo.findProductionByDateAndHeure2(s,now);
    }

    public List<ProductionNC> getProductionNCByDateAndHeure(String s, LocalTime now) {
        return productionNCRepo.findProductionNCByDateAndHeure2(s,now);
    }
}

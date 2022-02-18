package Dashboard.AlphaMinerals;

import Dashboard.AlphaMinerals.DTO.Response;
import Dashboard.AlphaMinerals.Model.Production;
import Dashboard.AlphaMinerals.Model.ProductionNC;
import Dashboard.AlphaMinerals.Service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.text.DecimalFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/AlphaMinerals")
public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/efficiencyppm1")
    public ResponseEntity<Response> efficiencyppm1(){
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime now=LocalTime.now().truncatedTo(ChronoUnit.SECONDS);
        Response response=new Response();
        List<Production> ListProduct=service.getProductionByDateAndHeure("2021-03-01",now);
        List<ProductionNC> ListProductnc=service.getProductionNCByDateAndHeure("2021-03-01",now);

            List<Integer> maxId =new ArrayList<Integer>();
        int max=0;
        if(!ListProduct.isEmpty()){
            for (int i=0;i<ListProduct.size();i++){
                maxId.add(ListProduct.get(i).getID());
            }
            max= Collections.max(maxId);
            Production product=service.getProductionByID(max);
            float efficiency=(float) 100*(product.getID())/900;
            response.setEfficiency(efficiency);
        }else {
            response.setEfficiency(0);
        }

        List<Integer> maxId2=new ArrayList<Integer>();
        int max2=0;
        if (!ListProductnc.isEmpty()){
            for (int i=0;i<ListProductnc.size();i++){
                maxId2.add(ListProductnc.get(i).getID());
            }
            max2= Collections.max(maxId2);
            ProductionNC productnc=service.getProductionNCByID(max2);
            float PPM=(float) 1000000*(productnc.getID())/900;
            response.setPPM(PPM);
        }else {
            response.setPPM(0);
        }
        return new ResponseEntity(response,HttpStatus.ACCEPTED);
    }

    @GetMapping("/products1")
    public ResponseEntity<List<Production>> chart(){
        LocalTime now=LocalTime.now();

        List<Production> ListProduct=service.getProductionByDateAndHeure("2021-03-01",now);

        return new ResponseEntity<>(ListProduct,HttpStatus.OK);
    }
    @GetMapping("/productsNC1")
    public ResponseEntity<List<ProductionNC>> chartNC(){
        LocalTime now=LocalTime.now();

        List<ProductionNC> ListProductnc=service.getProductionNCByDateAndHeure("2021-03-01",now);

        return new ResponseEntity<>(ListProductnc,HttpStatus.OK);
    }


}

package Dashboard.AlphaMinerals.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalTime;

@Entity
@Table(name = "production_nc")
public class ProductionNC {
    @Id
    private int ID;
    private String code_article;
    private String date;
    private LocalTime heure;


    public ProductionNC() {
    }

    public ProductionNC(int ID, String code_article, String date, LocalTime heure) {
        this.ID = ID;
        this.code_article = code_article;
        this.date = date;
        this.heure = heure;

    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getCode_article() {
        return code_article;
    }

    public void setCode_article(String code_article) {
        this.code_article = code_article;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    @Override
    public String toString() {
        return "ProductionNC{" +
                "ID=" + ID +
                ", code_article='" + code_article + '\'' +
                ", date=" + date +
                ", heure=" + heure +
                '}';
    }
}

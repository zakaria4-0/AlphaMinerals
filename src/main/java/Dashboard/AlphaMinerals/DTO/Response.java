package Dashboard.AlphaMinerals.DTO;

public class Response {
    private float efficiency;
    private float PPM;

    public Response() {
    }

    public Response(float efficiency, float PPM) {
        this.efficiency = efficiency;
        this.PPM = PPM;
    }

    public float getEfficiency() {
        return efficiency;
    }

    public void setEfficiency(float efficiency) {
        this.efficiency = efficiency;
    }

    public float getPPM() {
        return PPM;
    }

    public void setPPM(float PPM) {
        this.PPM = PPM;
    }
}

package demo.entity;

public class Game {

    private String code;
    private String name;
    private double price;
    private String publicBy;
    private String publicDate;
    private int status; // 0. deactive | 1. active

    public Game() {
    }

    public Game(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public Game(String code, String name, double price, String publicBy, String publicDate, int status) {
        this.code = code;
        this.name = name;
        this.price = price;
        this.publicBy = publicBy;
        this.publicDate = publicDate;
        this.status = status;
    }

    public void introduce(){
        System.out.println("Mã: " + this.code + ", name: " + this.name);
    }

    @Override
    public String toString() {
        return "Game{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", publicBy='" + publicBy + '\'' +
                ", publicDate='" + publicDate + '\'' +
                ", status=" + status +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPublicBy() {
        return publicBy;
    }

    public void setPublicBy(String publicBy) {
        this.publicBy = publicBy;
    }

    public String getPublicDate() {
        return publicDate;
    }

    public void setPublicDate(String publicDate) {
        this.publicDate = publicDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInString() {
        return status == 0 ? "Deactive" : "Active";
    }
}

public class NoteBook {
    
    private Integer diagonal;
    private Integer RAM;
    private String brand;
    private String model;
    private String OS;
    private Integer hardDisk;
    private Integer article;

    // public NoteBook (String brand, String model, Integer article) {
    //     this.brand = brand;
    //     this.model = model;
    //     this.article = article;
    //     System.out.println("Ноутбук " + this.model + " " + this.brand + ". Артикул " + this.article);
    // }

    public NoteBook(String brand, String model, Integer article) {

        this.brand = brand;
        this.model = model;
        this.article = article;
    }

    @Override
    public String toString() {
        return "Ноутбук " + model + " " + brand +". Артикул " + article;
    }

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    public Integer getRAM() {
        return RAM;
    }

    public void setRAM(Integer rAM) {
        RAM = rAM;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String oS) {
        OS = oS;
    }

    public Integer getHardDisk() {
        return hardDisk;
    }

    public void setHardDisk(Integer hardDisk) {
        this.hardDisk = hardDisk;
    }

    public Integer getArticle() {
        return article;
    }

    public void setArticle(Integer article) {
        this.article = article;
    }
    
    
}

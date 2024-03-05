public class Laptop {
    private int ram;
    private int hddSize;
    private String os;
    private String color;

    public Laptop(int ram, int hddSize, String os, String color){
        this.ram = ram;
        this.hddSize = hddSize;
        this.os = os;
        this.color = color;
    }
    public int getRam(){
        return ram;
    }
    public void setRam(int ram){
        this.ram = ram;
    }
    public int gethddSize(){
        return hddSize;
    }
    public void sethddSize(int hddSize){
        this.hddSize = hddSize;
    }
    public String getOs(){
        return os;
    }
    public void setOs(String os){
        this.os = os;
    } 
    public String getColor(){
        return color;
    }
    public void setColor(String color){
        this.color = color;
    }
    @Override
    public String toString(){
        return "Ноутбук [ОЗУ: " + ram + ", Обьем ЖД: " + hddSize + ", Операционная система: " + os + ", Цвет: " + color + "]";
    }
}
package model;

public class ImprovementArea {
    private String areaCode;
    private String nameArea;
    private String direction;

    public ImprovementArea(String areaCode, String nameArea, String direction) {
        this.areaCode = areaCode;
        this.nameArea = nameArea;
        this.direction = direction;
    } 
    
    @Override
    public String toString() {
        return "ImprovementArea [code=" + areaCode + ", nameArea=" + nameArea + ", direction=" + direction + "]";
    }

    public String getAreaCode() {
        return areaCode;
    }

    public String getNameArea() {
        return nameArea;
    }

    public String getDirection() {
        return direction;
    }

    


    


    
}

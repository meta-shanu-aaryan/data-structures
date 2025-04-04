package TreesAndGraphs.Assignment2;

public class TValue {
    private int data;
    private String name;

    public TValue(int data, String name) {
        this.data = data;
        this.name = name;
    }

    public TValue(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}

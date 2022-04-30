package models;

public class Squad {
    private String squadName;
    private String cause;
    private int size;

    public  Squad( String squadName, String cause,int size){
        this.squadName = squadName;
        this.cause = cause;
        this.size= size;

    }

    public String getSquadName() {
        return this.squadName;
    }

    public String getCause() {
        return this.cause;
    }

    public int getSize() {
        return this.size;
    }
}

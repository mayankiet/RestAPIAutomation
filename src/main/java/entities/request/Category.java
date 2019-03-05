package entities.request;

public class Category {



    private static int id;
    private static String name;

    public void setId(int id){

        this.id = id;
    }

    public int getId(){

        return id;
    }

    public void setName(String name){

        this.name = name;
    }

    public String getName(){

        return name;
    }

}

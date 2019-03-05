package entities.request;

public class CreatePetRequest {

    private int id;
    private Category category;
    private Tags[] tags;
    private String status;
    private String[] photoUrls;
    private String name;

    public void setId(int id){
        this.id = id;
    }

    public int getID() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setTags(Tags[] tags){

        this.tags = tags;
    }

    public Tags[] getTags(){

        return tags;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){

        this.status = status;
    }

    public void setCategory(Category category){

        this.category = category;
    }

    public Category getCategory(){
        return category;
    }

    public void setPhotoUrls(String[] photoUrls){
        this.photoUrls = photoUrls;
    }

    public String[] getPhotoUrls(){

        return photoUrls;
    }
}

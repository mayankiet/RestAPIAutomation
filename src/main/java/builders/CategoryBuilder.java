package builders;

import entities.request.Category;

public class CategoryBuilder {

    private Category category = new Category();


    public CategoryBuilder withID(int id){

        category.setId(id);
        return this;
    }

    public CategoryBuilder withName(String name){

        category.setName(name);
        return this;
    }

    public Category build(){

        return category;
    }

}

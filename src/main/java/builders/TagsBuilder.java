package builders;

import entities.request.Tags;

public class TagsBuilder {

     private Tags tag = new Tags();

     public TagsBuilder withID(int id){
         tag.setId(id);
         return this;
     }

     public TagsBuilder withName(String name){
         tag.setName(name);
         return this;
     }

     public Tags build(){
         return tag;
     }
}

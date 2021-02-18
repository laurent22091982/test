package be.atc.utils;

import java.util.ArrayList;
import java.util.List;

public class MenuUtils {

    public List<String> findListCategoryForLink(){

        List<String> categoryList = new ArrayList<>();

        categoryList.add("decoration");
        categoryList.add("fountain");
        categoryList.add("gardenFurniture");
        categoryList.add("tools");
        categoryList.add("swimmingPool");
        categoryList.add("lawnmower");

        return categoryList;
    }
}

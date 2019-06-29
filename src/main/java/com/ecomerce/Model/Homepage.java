package com.ecomerce.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homepage
{
    List<String> Categorieslist;

    public List<String> getCategorieslist() {
        return Categorieslist;
    }

    public void setCategorieslist(List<String> categorieslist) {
        Categorieslist = categorieslist;
    }

    public Homepage() {
        Categorieslist= Arrays.asList("Apple","Oneplus");
    }
}

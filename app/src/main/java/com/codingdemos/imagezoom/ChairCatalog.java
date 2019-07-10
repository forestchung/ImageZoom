package com.codingdemos.imagezoom;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

public class ChairCatalog extends ExpandableGroup<Chair> {

    public ChairCatalog(String title,  List<Chair> items) {
        super(title, items);
    }
}
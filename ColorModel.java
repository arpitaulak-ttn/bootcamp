package com.ttn.core.models;


import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;

@Model(adaptables = Resource.class)
public class ColorModel {
    @Inject
    private String color;

    @Inject
    private String text;

    public String getColor() {
        return color;
    }

    public String getText() {
        return text;
    }
}

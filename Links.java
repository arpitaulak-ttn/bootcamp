package com.ttn.core.models;

import com.adobe.cq.sightly.WCMUsePojo;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ValueMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Links extends WCMUsePojo {

    private List<HashMap<String,Object>> list=new ArrayList<>();




    @Override
    public void activate() throws Exception
    {
        Resource currentResource = getResource();
        Resource childResource = currentResource.getChild("links");
        ResourceResolver resourceResolver = getResourceResolver();
        Iterable<Resource> child=childResource.getChildren();
        for (Resource children : child)
        {


            ValueMap childMap = children.getValueMap();
            HashMap<String, Object> map = new HashMap<>(childMap);
            String link = (String) childMap.get("link");


            Resource resource=resourceResolver.getResource(link);
            if (resource !=null)
            {
                map.put("link",link + ".html");

            }

            list.add(map);

        }

    }




    public List<HashMap<String, Object>> getList() {
        return list;
    }
}
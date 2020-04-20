package com.ttn.core.models;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;
import com.day.cq.wcm.foundation.Image;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Model(adaptables = SlingHttpServletRequest.class)
public class AssetModel {
    private String path;
    @SlingObject
    private SlingHttpServletRequest request;
    @Inject @Via("resource")
    private String assetPath;

    @Inject @Via("resource")
    private String assetResolution;


    @PostConstruct
    public void init() throws Exception {
        ResourceResolver resourceResolver = request.getResourceResolver();
        Resource assetResource = resourceResolver.getResource(assetPath);
        if(assetResource!=null){
            Asset imgAsset = assetResource.adaptTo(Asset.class);
            String[] dimension = assetResolution.split(":");
            if(imgAsset!=null){
                path = imgAsset.getOriginal().getPath();
                String tempStr = (dimension[0]+"."+dimension[1]+".png");
                for (Rendition rendition : imgAsset.getRenditions()) {
                    if(rendition.getName().endsWith(tempStr)){
                        path = rendition.getPath();
                    }
                }
            }

        }

    }

    public String getPath() {
        return path;
    }
}

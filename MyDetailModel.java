package com.aem.training.core.models;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Calendar;
import java.util.Date;

@Model(adaptables = Resource.class, defaultInjectionStrategy= DefaultInjectionStrategy.OPTIONAL)
public class MyDetailModel {
    @Inject
    private String firstname;

    @Inject
    private String lastname;

    @Inject
    private Date date;

    @Inject
    private String marital;

    @Inject
    private String gender;

    private String fullname;
    private int age;
    private String honorific;

    @PostConstruct
    protected void init(){
        fullname = firstname+" "+lastname;
        if(gender.equals("male")){
            honorific="Mr";
        }
        if (gender.equals("female") && marital.equals("single")){
            honorific="Ms";
        }
        if (gender.equals("female") && marital.equals("married")){
            honorific="Mrs";
        }
        age = ageGet();
    }

    public String getFullname() {

        return fullname;
    }

    public int getAge() {
        return age;
    }
    public String getHonorific() {
        return honorific;
    }

    private int ageGet(){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DATE);
        LocalDate l1 = LocalDate.of(year, month, date);
        LocalDate now = LocalDate.now();
        Period diff = Period.between(l1, now);
        return diff.getYears();
    }

}

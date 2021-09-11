package com.example.covid_19tracker;

public class Model {
    String state,districtData,active,confirmed,deceased,recovered,dconfirmed,ddeceased,drecovered;
    public Model(String state, String districtData, String active, String confirmed, String deceased, String recovered, String dconfirmed, String ddeceased, String drecovered)
    {
        this.state=state;
        this.districtData=districtData;
        this.active=active;
        this.confirmed=confirmed;
        this.deceased=deceased;
        this.recovered=recovered;
        this.dconfirmed=dconfirmed;
        this.ddeceased=ddeceased;
        this.drecovered=drecovered;
    }

    public String getState()
    {
        return  state;
    }
    public String getDistrictData()
    {
        return  districtData;
    }
    public String getActive()
    {
        return  active;
    }
    public String getConfirmed()
    {
        return  confirmed;
    }
    public String getRecovered() {return recovered;}
    public String getDeceased() {return deceased;}
    public String getDconfirmed(){return  dconfirmed;}
    public String getDdeceased() {return ddeceased;}
    public String getDrecovered() {return drecovered;}


}

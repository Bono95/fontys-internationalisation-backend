package model.internshipRoute;

import model.school.Institution;

public class InternshipRouteBuilder {

    private String name;
    private Institution institution;
    private boolean isActive = false;

    public InternshipRouteBuilder name(String name){
        this.name = name;
        return this;
    }

    public InternshipRouteBuilder institution(Institution institution){
        this.institution = institution;
        return this;
    }

    public InternshipRouteBuilder isActive(boolean isActive){
        this.isActive = isActive;
        return this;
    }

    public InternshipRoute build(){
        return new InternshipRoute(name, institution, isActive);
    }


}

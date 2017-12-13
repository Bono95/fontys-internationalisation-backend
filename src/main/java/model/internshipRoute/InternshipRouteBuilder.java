package model.internshipRoute;

import model.internship.Internship;
import model.school.Institution;

public class InternshipRouteBuilder {

    private String name;
    private Institution institution;

    public InternshipRouteBuilder name(String name){
        this.name = name;
        return this;
    }

    public InternshipRouteBuilder institution(Institution institution){
        this.institution = institution;
        return this;
    }

    public InternshipRoute build(){
        return new InternshipRoute(name, institution);
    }


}

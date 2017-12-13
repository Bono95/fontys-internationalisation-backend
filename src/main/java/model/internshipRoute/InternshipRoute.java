package model.internshipRoute;

import model.Crudable;
import model.school.Institution;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

@Entity
public class InternshipRoute implements Crudable {

    @Id
    private int id;

    private String name;

    @OneToOne(targetEntity = Institution.class, fetch = FetchType.EAGER)
    private Institution institution;

    public InternshipRoute() {
    }

    InternshipRoute(String name, Institution institution) {
        this.name = name;
        this.institution = institution;
    }


    public boolean isIncomplete() {
        return  name == "";
    }

    public List<String> getIncompleteProperties() {
        List<String> list = new ArrayList<String>();

        if (name == "") list.add("name");


        return list;
    }

    //region Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    //endregion

}

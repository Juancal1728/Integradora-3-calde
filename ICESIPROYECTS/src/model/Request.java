package model;
import java.util.Calendar;

public class Request {
    private Calendar registerDate;
    private String affair;
    private String description;
    private State stateRequest;
    private Collaborator nameCollaborator;
    private Calendar endDate;
    private ImprovementArea area;
    private Project project;


    public Request(Calendar registerDate, String affair, String description, State stateRequest,
            Collaborator nameCollaborator, ImprovementArea area) {
        this.registerDate = Calendar.getInstance();
        this.affair = affair;
        this.description = description;
        this.stateRequest = stateRequest;
        this.nameCollaborator = nameCollaborator;
        this.endDate = Calendar.getInstance();
        this.area = area;
    }

    @Override
    public String toString() {
        return "Request [registerDate=" + registerDate + ", affair=" + affair + ", description=" + description
                + ", stateRequest=" + stateRequest + ", nameCollaborator=" + nameCollaborator + ", endDate=" + endDate
                + ", area=" + area + "]";
    }

    public Calendar getRegisterDate() {
        return registerDate;
    }

    public String getAffair() {
        return affair;
    }

    public String getDescription() {
        return description;
    }

    public State getStateRequest() {
        return stateRequest;
    }

    public Collaborator getNameCollaborator() {
        return nameCollaborator;
    }

    public Calendar getEndDate() {
        return endDate;
    }

    public ImprovementArea getArea() {
        return area;
    }

    public void setAffair(String affair) {
        this.affair = affair;
    }

    public void setStateRequest(State stateRequest) {
        this.stateRequest = stateRequest;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    
    

    





    
}

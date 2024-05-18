package model;

import java.util.Calendar;

public abstract class Project {
    private String idProject;
    private String projectName;
    private State state;
    private Priority priority;

    private Collaborator proyectLeader;

    public Project(String idProject, String projectName, State state, Priority priority, Collaborator proyectLeader) {
        this.idProject = idProject;
        this.projectName = projectName;
        this.state = state;
        this.priority = priority;
        this.proyectLeader = proyectLeader;
    }

    
    @Override
    public String toString() {
        return "Proyect [idProject=" + idProject +
         ", projectName=" + projectName
         + " Priority = " + priority
          + ", state=" + state
                + ", proyectLeader=" + proyectLeader + "]";
    }


    public String getIdProject() {
        return idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Collaborator getProyectLeader() {
        return proyectLeader;
    }

    public void setProyectLeader(Collaborator proyectLeader) {
        this.proyectLeader = proyectLeader;
    }

    public Priority getPriority() {
        return priority;
    }

    

    
}

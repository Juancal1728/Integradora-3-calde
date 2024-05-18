package model;

import java.util.Calendar;

public class Transformation extends Project {
    private String processCode;
    private Calendar estimatedEndingDate;


    public Transformation(String idProject, String projectName, State state, Priority priority,  Collaborator proyectLeader, String processCode, String estimatedEndingDate2) {
        super(idProject, projectName, state, priority, proyectLeader);
        this.processCode = processCode;
        this.estimatedEndingDate = Calendar.getInstance();
    }

    @Override
    public String toString() {
        return "Transformation [processCode=" + processCode + ", estimatedEndingDate=" + estimatedEndingDate + "]";
    }

    public String getProcessCode() {
        return processCode;
    }

    public Calendar getEstimatedEndingDate() {
        return estimatedEndingDate;
    }
    
}

package model;

public class KnowledgeManager extends Project {
    private String processName;
    private ImpactCommunity impactCommunity;
    private TypeManage typeManage;

    public KnowledgeManager(String idProject, String projectName, State state,Priority priority, Collaborator proyectLeader,String processName, ImpactCommunity impactCommunity, TypeManage typeManage) {
        super(idProject, projectName, state, priority, proyectLeader);
        this.processName = processName;
        this.impactCommunity = impactCommunity;
        this.typeManage = typeManage;
    }

    @Override
    public String toString() {
        return "KnowledgeManagement{" +
                "idProject='" + getIdProject() + '\'' +
                ", projectName='" + getProjectName() + '\'' +
                ", state=" + getState() +
                ", priority=" + getPriority() +
                ", projectLeader='" + getProyectLeader() + '\'' +
                ", processName='" + processName + '\'' +
                ", impactCommunity=" + impactCommunity +
                ", typeManage=" + typeManage +
                '}';
    }
    
    

    

    public String getProcessName() {
        return processName;
    }

    public ImpactCommunity getImpactCommunity() {
        return impactCommunity;
    }

    public TypeManage getTypeManage() {
        return typeManage;
    }

    



    
}

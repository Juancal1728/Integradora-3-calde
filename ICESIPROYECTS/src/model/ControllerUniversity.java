package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

public class ControllerUniversity {
    private ArrayList<Project> projects;
    private ArrayList<Collaborator> collaborators;
    private ArrayList <ImprovementArea> areas;
    private ArrayList <Request> requests;
       
    public ControllerUniversity() {
            projects = new ArrayList<Project>();
            collaborators = new ArrayList <Collaborator>();
            areas = new ArrayList <ImprovementArea>();
            requests = new ArrayList<Request>();


            testCases();
        }

     public void testCases() {
        collaborators.add(new Collaborator("0001", "Freddy Cortez", "freddy23@u.icesi.edu.co", "AA1039104104"));
        collaborators.add(new Collaborator("0002", " Juanita Montes", "juanim26@u.icesi.edu.co","AA2092340913"));
        collaborators.add(new Collaborator("0003", " Juan David Calderon", "juancal1728@u.icesi.edu.co", "AA1105365502"));
        collaborators.add(new Collaborator("0004", " Warren Buffett", "warbuff2024@u.icesi.edu.co", "AA1000001111"));

        }
        
     /* -----------------------------------------------------------------------------------
	 * ----------------------------- Register Collaborators -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */


    public boolean addCollaborator(String fullName, String email, String extensionNumber) {
        String idCollaborator = generateCollaboratorId(); 
        if (isCollaboratorRegistered(idCollaborator)) {
            return false;
        }
        return collaborators.add(new Collaborator(idCollaborator, fullName, email, extensionNumber));   
    }

    public String generateCollaboratorId() {
        String uuid = UUID.randomUUID().toString().toUpperCase();
        String numbers = uuid.replaceAll("[^0-9]", ""); 
        String customId = "A00" + numbers.substring(0, 6); 
        return customId;
    }

    

    public boolean isCollaboratorRegistered(String idCollaborator) {
        for (int x = 0; x < collaborators.size(); x++) {
            if (collaborators.get(x).getIdCollaborator().equals(idCollaborator)) {
                return true;
            }
        }
        return false; 
    }

    public String getCollaboratorList() {
        String collaboratorList = "";
        for (int x = 0; x < collaborators.size(); x++) {
            Collaborator collaborator = collaborators.get(x);
            collaboratorList += "Name: " + collaborator.getFullName() + " - ID: " + collaborator.getIdCollaborator() + "\n";
        }
        return collaboratorList;
    }
    

    /* -----------------------------------------------------------------------------------
	 * ----------------------------- Register Area of Transformation -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */

     public boolean addImprovementArea(String areaCode, String nameArea, String direction){
        if(isAreaRegistered(areaCode)){
            return false;
        }
        return areas.add(new ImprovementArea(areaCode, nameArea, direction));

     }

     public String getAreaList() {
        String areaList = "";
        for (int x = 0; x < areas.size(); x++) {
            ImprovementArea area = areas.get(x);
            areaList += "Area Code: " + area.getAreaCode() + " - Name: " + area.getNameArea() + "\n";
        }
        return areaList;
    }
    



     public boolean isAreaRegistered(String areaCode) {
        for (int x = 0; x < areas.size(); x++) {
            if (areas.get(x).getAreaCode().equals(areaCode)) {
                return true;
            }
        }
        return false; 
    }


    public boolean changeRequestState(Request request, State newState) {
        if (requests.contains(request)) {
            request.setStateRequest(newState);
            if (newState == State.ACEPTED) {
                projects.add(request.getProject());
            }
            return true;
        }
        return false;
    }

    public ArrayList<String> getAcceptedRequestsAndProjects() {
        ArrayList<String> result = new ArrayList<>();
        for (int x = 0; x < requests.size(); x++) {
            Request request = requests.get(x);
            if (request.getStateRequest() == State.ACEPTED && request.getProject() != null) {
                result.add("Request: " + request.getAffair() + " - Project: " + request.getProject().getIdProject());
            }
        }
        return result;
    }
    


       /* -----------------------------------------------------------------------------------
	 * ----------------------------- Register Request -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */

    public boolean registerRequest(String registerDate, String affair, String description, int stateIndex, int collaboratorIndex, int areaIndex) {
        State state = showState(stateIndex);
        if (state == null) {
            return false; 
        }
    
        Collaborator collaborator = getCollaboratorByIndex(collaboratorIndex);
        if (collaborator == null) {
            return false; 
        }
    
        ImprovementArea area = getAreaByIndex(areaIndex);
        if (area == null) {
            return false; 
        }
    
        return addRequest(registerDate, affair, description, state, collaborator, area);
    }


    public Collaborator getCollaboratorByIndex(int index) {
        if (index < 1 || index > collaborators.size()) {
            return null;
        }
        return collaborators.get(index - 1);
    }

    /**
     * @param index
     * @return
     */
   
    public ImprovementArea getAreaByIndex(int index) {
        if (index < 1 || index > areas.size()) {
            return null;
        }
        return areas.get(index - 1);
    }

    public boolean addRequest(String registerDate, String affair, String description, State stateRequest,
                              Collaborator nameCollaborator, ImprovementArea area) {
        if (isRequested(area)) {
            return false;
        }

        Calendar newRegister = parseDate(registerDate);
        return requests.add(new Request(newRegister, affair, description, stateRequest, nameCollaborator, area));
    }

    public boolean isRequested(ImprovementArea area) {
        for (Request request : requests) {
            if (request.getArea().equals(area)) {
                return true;
            }
        }
        return false; 
    }

    public Calendar parseDate(String dateString) {
        String[] arrayRegister = dateString.split("-");
        int day = Integer.parseInt(arrayRegister[0]);
        int month = Integer.parseInt(arrayRegister[1]) - 1;
        int year = Integer.parseInt(arrayRegister[2]);

        Calendar newRegister = Calendar.getInstance();
        newRegister.set(year, month, day);
        return newRegister;
    }



    /* -----------------------------------------------------------------------------------
	 * ----------------------------- Register Projects -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */

    public boolean addProjectTransformation(String projectName, State state, Priority priority, int  collaboratorIndex, String processCode, String estimatedEndingDate) {
        String idProject =  generateProjectId();
        if (isCodeRegistered(idProject)) {
            return false; 
        }

        Collaborator projectLeader = getCollaboratorByIndex(collaboratorIndex);
        if (projectLeader == null) {
            return false; 
        }
    
        
        return projects.add(new Transformation(idProject, projectName, state, priority, projectLeader, processCode, estimatedEndingDate));
    }
    
    public boolean addProjectKnowledgeManagement(String projectName, State state, Priority priority, int collaboratorIndex, String processName, ImpactCommunity impactCommunity, TypeManage typeManage) {
        String idProject =  generateProjectId();
        if (isCodeRegistered(idProject)) {
            return false; 
        }
        Collaborator projectLeader = getCollaboratorByIndex(collaboratorIndex);
        if (projectLeader == null) {
            return false; 
        }
    
        return projects.add(new KnowledgeManager(idProject, projectName, state, priority, projectLeader , processName, impactCommunity, typeManage));
    }

    public String generateProjectId() {
        return UUID.randomUUID().toString().toUpperCase().substring(0, 4);
    }
    

    public boolean isCodeRegistered(String idProject) {
        for (int x = 0; x < projects.size(); x++) {
            if (projects.get(x).getIdProject().equals(idProject)) {
                return true; 
            }
        }
        return false; 
    }

    public Calendar parseDateAcceptance(String dateString) {
        String[] arrayAcceptance = dateString.split("-");
        int day = Integer.parseInt(arrayAcceptance[0]);
        int month = Integer.parseInt(arrayAcceptance[1]) - 1;
        int year = Integer.parseInt(arrayAcceptance[2]);

        Calendar newAcceptance = Calendar.getInstance();
        newAcceptance.set(year, month, day);
        return newAcceptance;
    }


    public boolean closeProject(String projectId) {
        for (int i = 0; i < projects.size(); i++) {
            if (projects.get(i).getIdProject().equals(projectId)) {
                projects.remove(i);
                return true; 
            }
        }
        return false; 
    }


    /* -----------------------------------------------------------------------------------
	 * ----------------------------- Consuting methods -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */

    public String showDetailInfoProject() {
       
        String msg = "";
    
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            msg += "\n" + (i + 1) + ". " + project.getIdProject() + " - " + project.getProjectName();
        }
    
        return msg;
    }

    public String showDetailInfoProject(String id) {
        Project project = findProjectById(id);
        if (project != null) {
            return project.toString();
        } else {
            return "Project not found";
        }
    }

    public Project findProjectById(String id) {
        for (int x = 0; x < projects.size(); x++) {
            Project project = projects.get(x);
            if (project.getIdProject().equals(id)) {
                return project;
            }
        }
        return null;
    }

    public String getProjectList() {
        String projectList = "";
    
        for (int i = 0; i < projects.size(); i++) {
            Project project = projects.get(i);
            projectList += "\n" + (i + 1) + ". " + project.getIdProject() + " - " + project.getProjectName();
        }
    
        return projectList;
    }

    public String getProjectInfo(int option) {
        String projectInfo = "";
    
        if (option >= 1 && option <= projects.size()) {
            Project project = projects.get(option - 1);
            if (project != null) {
                projectInfo = project.toString();
            } else {
                projectInfo = "Project not found";
            }
        } else {
            projectInfo = "Invalid option";
        }
    
        return projectInfo;
    }
    
    /* -----------------------------------------------------------------------------------
	 * ----------------------------- Show Enums -------------------------------------- 
	 * -----------------------------------------------------------------------------------
	 */


    public State showState(int election) {
        State state = null;
        switch (election) {
            case 1:
                state = State.ACEPTED;
                break;
            case 2:
                state = State.DELAY;
                 break;
            case 3:
                state = State.REYECTED;
                break;
            case 4:
                state = State.ONPROCESS;
                break;
            default:
                System.out.println("Invalid election, this information couldn't register");
                return null;
        }
        return state;
    }

	public TypeManage showTypeManage(int election) {
        TypeManage typeManage = null;
        switch (election) {
            case 1:
                typeManage = TypeManage.STANDARIZATON;
                break;
            case 2:
                typeManage = TypeManage.DOCUMENTATION;
                break;
            case 3:
                typeManage = TypeManage.OPTIMIZATION;
                break;
            default:
                System.out.println("Invalid election, this information couldn't register");
                return null;
        }
        return typeManage;
    }


    public Priority showPriority(int election){
        Priority priority = null;
        switch(election){
            case 1:
            priority = Priority.URGENT;
            break;
            case 2:
            priority = Priority.HIGH;
            break;
            case 3:
            priority = Priority.MID;
            break;
            case 4:
            priority = Priority.LOW;
            break;
            default:
            System.out.println("Invalid election, this information couldn´t register");
            return null;
        }
        return priority;
    }

    
    public ImpactCommunity showiImpactCommunity(int election){
        ImpactCommunity impactCommunity = null;
        switch(election){
            case 1:
            impactCommunity = ImpactCommunity.STUDENTS;
            break;
            case 2:
            impactCommunity = ImpactCommunity.PROFESORS;
            break;
            case 3:
            impactCommunity = ImpactCommunity.ADMISTRATIVES;
            break;
            default:
            System.out.println("Invalid election, this information couldn´t register");
            return null;
        }
        return impactCommunity;
    }


    }
    
    




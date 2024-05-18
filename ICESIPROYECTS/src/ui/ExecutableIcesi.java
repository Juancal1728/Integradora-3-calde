package ui;
import java.util.Scanner;
import model.ControllerUniversity;

public class ExecutableIcesi {
    
    private Scanner reader;
    private ControllerUniversity control;

    public ExecutableIcesi(){
        reader = new Scanner(System.in);
        control = new ControllerUniversity();
    }

    public static void main(String[] args){
        ExecutableIcesi executable = new ExecutableIcesi();
        executable.menu();
    }

    private void menu() {

        System.out.println("----------------------------------------------------------------------");
        System.out.println("Welcome to Icesi Proyects ");
        System.out.println("----------------------------------------------------------------------");
        boolean flag = false;

        while (!flag) {
            System.out.println("\nPRINCIPAL Menu");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("[1]. Administration Menu: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("[2] Consultant Menu: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("[3] Exit");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Select an option: [1-3] ");
            int option = reader.nextInt();

            switch (option) {
                case 1:
                    clearScreen();
                    registerMenu();
                    break;
                case 2:
                    clearScreen();
                    consultantMenu();
                    break;
                case 3:
                    flag = true;
                    break;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private void registerMenu() {

        reader.nextLine();
        boolean exit = false;
        while(!exit){
            clearScreen();
        System.out.println(" [1] Register Area Transformation: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [2] Register Collaborator: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [3] Register Request : ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [4] Change state of request: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [5] Register an Specific Proyect: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [6] Close a Proyect: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [7] return to principal menu: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.print("Select an option: [1-6] ");
        int option = reader.nextInt();
        reader.nextLine();
        switch (option) {
            case 1:
                registerAreaTransformation();
                break;
            case 2:
                registerCollaborator();
                break;
            case 3:
                registerRequest();
                break;
            case 4:
                changeStateRequest();
                break;
            case 5:
                registerProject();
                
                break;
            case 6:
                closeProyect();
                break;
            case 7:
                exit = true;
                System.out.println("Exiting to principal menu...");
                break;

            default:
                System.out.println("Invalid option. Please select again");
                break;
        }
    }
 }


    private void consultantMenu() {
        reader.nextLine();
        boolean exit = false;
        while(!exit){
        clearScreen();
        System.out.println(" Type a choise for an specific consult:  ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [1] Visualize information for proyects on matrix : ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [2] Show detail information for a proyect: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [3] Consult Efficiency : ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [4] Consult Global index job of transformation and development area: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println(" [5] return to main menu: ");
        System.out.print("Select an option: [1-5] ");
        int option = reader.nextInt();
        reader.nextLine();
        switch (option) {
            case 1:
                showMatrixInformationProyect();
                break;
            case 2:
                showDetailInfoProject();
               
                break;
            case 3:
                consultEfficiency();
                break;
            case 4:
                break;
            case 5:
                exit = true;
                System.out.println("Exiting to principal menu...");

                break;
            default:
                System.out.println("Invalid option. Please try again");
                break;
        }
    }
}

    private void showDetailInfoProyect() {
    }

    private void showMatrixInformationProyect() {
    }

    private void registerAreaTransformation(){



    }

    private void registerCollaborator(){
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("The code generated for the Collaborator ID is:");
        System.out.println("----------------------------------------------------------------------");
        String idCollaborator = control.generateCollaboratorId();
        System.out.println(idCollaborator); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the Collaborator full name:");
        String fullName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the email of the Collaborator: ");
        String email = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the extension number:");
        String processName = reader.nextLine();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        boolean success = control.addCollaborator(fullName, email, processName);

        if (success) {
            System.out.println("The collaborator is registered successfully");
            System.out.println("Generated ID: " + idCollaborator);
            System.out.println("----------------------------------------------------------------------");
        } else {
            System.out.println("There is an error on the registration of the collaborator");
        }
    }

    

    private void registerRequest(){
        reader.nextLine();

        
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Register the date of request (format: DD-MM-YYYY)");
            System.out.println("----------------------------------------------------------------------");
            String registerDate = reader.nextLine();
        
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Enter the affair for request:");
            System.out.println("----------------------------------------------------------------------");
            String affair = reader.nextLine();
        
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Enter the Description for request:");
            System.out.println("----------------------------------------------------------------------");
            String description = reader.nextLine();
        
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Enter the State of the request:");
            System.out.println("----------------------------------------------------------------------");
            System.out.println("1. Accepted");
            System.out.println("2. Delay");
            System.out.println("3. Rejected");
            System.out.println("4. On process");
            System.out.println("----------------------------------------------------------------------");
            int stateIndex = reader.nextInt();
            reader.nextLine(); 
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Select the name of the collaborator: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(control.getCollaboratorList());
            int collaboratorIndex = reader.nextInt();
            reader.nextLine(); 
        
            System.out.println("----------------------------------------------------------------------");
            System.out.println("Select the area of transformation:");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(control.getAreaList());
            int areaIndex = reader.nextInt();
            reader.nextLine(); 
            System.out.println("----------------------------------------------------------------------");
        
            boolean success = control.registerRequest(registerDate, affair, description, stateIndex, collaboratorIndex, areaIndex);
        
            if (success) {
                System.out.println("The project is registered successfully");
            } else {
                System.out.println("There is an error on the registration of the project");
            }

        }
        
        
        
        
        
    

    private void changeStateRequest(){

    }

    private void registerProject() {
        reader.nextLine();
        boolean exit = false;
        while(!exit){       
            System.out.println(" Type a choice for the type of project:  ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [1] Register area of Knowledge Management : ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [2] Register area of Transformation and Development: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [3] Return to administration menu: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Select an option: [1-3] ");
            int option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    registerKnowledgeManagement();
                    break;
                case 2:
                    registerTransformation();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting to administration menu");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        }
    }

    private void registerKnowledgeManagement() {
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("The code generated for the project is:");
        System.out.println("----------------------------------------------------------------------");
        String idProject = control.generateProjectId();
        System.out.println(idProject); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the Project name:");
        String projectName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the State of the Project:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Accepted");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. Delay");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Rejected");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("4. On process");
        System.out.println("----------------------------------------------------------------------");
        int state = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the Priority of the Project:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Urgent (5 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. High ( 10 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Medium  ( 30 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("4. Low (60 days response)");
        System.out.println("----------------------------------------------------------------------");
        int priority = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Select the name of project leader:");
        System.out.println(control.getCollaboratorList());
        int collaboratorIndex = reader.nextInt();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the process name:");
        String processName = reader.nextLine();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the impacted community:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Students");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. Professors");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Administratives");
        System.out.println("----------------------------------------------------------------------");
        int impactCommunity = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the type of manage:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Standardization");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. Documentation");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Optimization");
        System.out.println("----------------------------------------------------------------------");
        int typeManage = reader.nextInt();
        reader.nextLine();


        boolean success = control.addProjectKnowledgeManagement(projectName, control.showState(state), control.showPriority(priority), collaboratorIndex , processName, control.showiImpactCommunity(impactCommunity), control.showTypeManage(typeManage));

        if (success) {
            System.out.println("The project is registered successfully");
            System.out.println("Generated ID: " + idProject);
        } else {
            System.out.println("There is an error on the registration of the project");
        }
    }

    private void registerTransformation() {
        reader.nextLine();

        System.out.println("----------------------------------------------------------------------");
        System.out.println("The code generated for the project is:");
        System.out.println("----------------------------------------------------------------------");
        String idProject = control.generateProjectId();
        System.out.println(idProject); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the Project name:");
        String projectName = reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the State of the Project:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Accepted");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. Delay");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Rejected");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("4. On process");
        System.out.println("----------------------------------------------------------------------");
        int state = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the Priority of the Project:");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("1. Urgent (5 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("2. High ( 10 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("3. Medium  ( 30 days response)");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("4. Low (60 days response)");
        System.out.println("----------------------------------------------------------------------");
        int priority = reader.nextInt();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Select the name of project leader:");
        System.out.println(control.getCollaboratorList());
        int collaboratorIndex = reader.nextInt();
        reader.nextLine(); 
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the process code:");
        String processName = reader.nextLine();
        reader.nextLine();
        System.out.println("----------------------------------------------------------------------");
        System.out.println("Enter the estimated end date  (dd-mm-yyyy):");
        String estimatedEndDate = reader.nextLine();
        reader.nextLine();


        boolean success = control.addProjectTransformation(projectName, control.showState(state), control.showPriority(priority), collaboratorIndex, processName, estimatedEndDate);
        if (success) {
            System.out.println("The project is registered successfully");
            System.out.println("Generated ID: " + idProject);
        } else {
            System.out.println("There is an error on the registration of the project");
        }
    }


   

        private void closeProyect(){

        }

        private void consultEfficiency(){
            reader.nextLine();
            boolean exit = false;
            while(!exit){
            System.out.println(" Type a choise for the type of effiency that you want to consult:  ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [1] Consult Efficiency of a Collaborator in Transformation Area : ");
            System.out.println("----------------------------------------------------------------------");;
            System.out.println(" [2] Consult Efficiency of a determined Request: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [3] Consult Efficiency of a determined Proyect: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(" [4] return to consult menu: ");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("Select an option: [1-4] ");
            int option = reader.nextInt();
            reader.nextLine();
            switch (option) {
                case 1:
                    registerKnowledgeManagement();
                    break;
                case 2:
                    registerTransformation();
                    break;
                case 3:
                    closeProyect();
                    break;
                    case 4:
                    exit = true;
                    System.out.println("Exiting to the consult menu...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again");
                    break;
            }
        }
    }


    private void showDetailInfoProject() {

        String query = control.getProjectList();

        if (query.equals("")) {
            System.out.println("There are no registered Proyects:");
        } else {
            System.out.println("\nThis is the list of registered Proyects in the system");
            System.out.println("----------------------------------------------------------------------");
            System.out.println(query);
            System.out.println("----------------------------------------------------------------------");
            System.out.println("\nSelect the Proyect to consult");
            int option = reader.nextInt();
            reader.nextLine();
            System.out.println("----------------------------------------------------------------------");
            String proyectInfo = control.getProjectInfo(option);
            if (proyectInfo.equals("User not found")) {
                System.out.println("The user was not found");
            } else {
                System.out.println(proyectInfo);
            }
        }
    }
    
    public void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    
    }




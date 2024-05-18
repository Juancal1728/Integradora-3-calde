package model;

public class Collaborator {

    private String idCollaborator;
    private String fullName;
    private String email;
    private String extensionNumber;

    public Collaborator(String idCollaborator, String fullName, String email, String extensionNumber) {
        this.idCollaborator = idCollaborator;
        this.fullName = fullName;
        this.email = email;
        this.extensionNumber = extensionNumber;
    }

    @Override
    public String toString() {
        return "Collaborator [idCollaborator=" + idCollaborator + ", fullName=" + fullName + ", email=" + email
                + ", extensionNumber=" + extensionNumber + "]";
    }

    public String getIdCollaborator() {
        return idCollaborator;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getExtensionNumber() {
        return extensionNumber;
    }

    

    


    
}

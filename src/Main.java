import controller.ProjectController;
import model.Project;

public class Main {
    public static void main(String[] args) {

        ProjectController projectController = new ProjectController();

        Project project = new Project();
        project.setProjectName("Projeto Teste");
        project.setProjectDesc("Esse projeto é um teste");
        projectController.save(project);

    }
}
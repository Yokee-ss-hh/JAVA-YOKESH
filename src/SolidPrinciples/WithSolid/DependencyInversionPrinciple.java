package SolidPrinciples.WithSolid;

import java.util.List;

interface Developer {
    String develop();
}
class BackEndDeveloper implements Developer {
    @Override
    public String develop() {
        return writeJava();
    }
    private String writeJava() {
        return "some java code";
    }
}
class FrontEndDeveloper implements Developer {
    @Override
    public String develop() {
        return writeJavaScript();
    }
    private String writeJavaScript() {
        return "some javascript code";
    }
}
class Project {
    private List<Developer> developers;
    public Project(List<Developer> developers) {
        this.developers = developers;
    }
    public void implement() {
        developers.forEach(d-> System.out.println(d.develop()));
    }
}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Developer frontEndDeveloper = new FrontEndDeveloper();
        Developer backEndDeveloper = new BackEndDeveloper();
        Project project = new Project(List.of(frontEndDeveloper,backEndDeveloper));
        project.implement();
        // Now both Point 1 and 2 are not violated
        // Point 1: igh-level modules should not depend on low-level modules. Both should depend on abstractions
        // Project is not dependent on FrontEndDeveloper / BackEndDeveloper. All Project, FED and BED
        // depending on abstraction i.e, Developer
        // Point 2: Abstractions should not depend on details. Details should depend on abstractions.
        // The details i.e, methods writeJava and writeJavaScript are depending on abstraction interface method
        // develop()
    }
}

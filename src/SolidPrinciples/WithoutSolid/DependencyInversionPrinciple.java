package SolidPrinciples.WithoutSolid;
// 1) High-level modules should not depend on low-level modules. Both should depend on abstractions
// 2) In turn abstractions should not depend on details. Details should depend on abstractions.
// Point 2 means that if the details change they should not affect the abstraction.
// The abstraction is the way clients view an object
// Example for point 2:
// Lets take a car for example, the pedals and steering wheel and gear lever are abstractions
// of what happens inside the engine. They do not depend on the details though because if someone changes
// my old engine for a new one I should still be able to drive the car without knowing that the engine
// changed.
class BackEndDeveloper {
    public String writeJava() {
        return "some java code";
    }
}
class FrontEndDeveloper {
    public String writeJavascript() {
        return "some javascript code";
    }
}
class Project {
    private final BackEndDeveloper backEndDeveloper = new BackEndDeveloper();
    private final FrontEndDeveloper frontEndDeveloper = new FrontEndDeveloper();
    public String integrateBackendAndFrontend() {
        return backEndDeveloper.writeJava() +" integrated with "+frontEndDeveloper.writeJavascript();
    }
}
public class DependencyInversionPrinciple {
    public static void main(String[] args) {
        Project project = new Project();
        System.out.println(project.integrateBackendAndFrontend());
        // Project is a high level module, and it depends on BackEndDeveloper and FrontEndDeveloper modules
        // for calling their respective methods. This violates Point 1 of DIP
        // Also, by inspecting the integrateBackendAndFrontend method of Project class, we realize that
        // the methods writeJava and writeJavascript are methods bound to the corresponding classes.
        // Regarding the project scope, those are details since, in both cases,
        // they are forms of development.
        // Thus, the Point 2 of DIP is violated.
    }
}

package DesignPatterns.BehavioralDP;

// Memento Pattern is a behavioral design pattern used to capture and restore an object’s internal state without violating encapsulation.
// Originator: The objects state we want to save
// Memento: Snapshot of the originator object -> useful methods like save() & restore()
// Caretaker: The core logic where we store states

import java.util.Stack;

class Text{
    private String content;
    Text(String content){
        this.content=content;
    }
    public String getSavedContent(){
        return this.content;
    }
}

class TextEditor{
    private String content;
    public void write(String content){
        this.content=content;
    }
    public String getContent(){
        return this.content;
    }
    public Text save(){
        return new Text(this.content);
    }
    public void restore(Text editorMemento){
        this.content = editorMemento.getSavedContent();
    }
}

class History{
    private Stack<Text> historyStack = new Stack<>();
    public void save(Text editorMemento){
        historyStack.push(editorMemento);
    }
    public Text undo(){
        if(!historyStack.isEmpty()){
            return historyStack.pop();
        }
        return null;
    }
}

public class MementoDesignPattern {
    public static void main(String[] args) {
        History history = new History();
        TextEditor textEditor = new TextEditor();
        textEditor.write("abc");
        history.save(textEditor.save());
        System.out.println(textEditor.getContent());
        textEditor.write("xyz");
        history.save(textEditor.save());
        System.out.println(textEditor.getContent());
        textEditor.restore(history.undo());
        System.out.println(textEditor.getContent());
    }
}

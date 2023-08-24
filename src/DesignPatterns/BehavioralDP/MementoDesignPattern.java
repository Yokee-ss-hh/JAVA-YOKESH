package DesignPatterns.BehavioralDP;
// Memento pattern is used to restore state of an object to a previous state.
// It is also known as snapshot pattern.
// There are 3 parts in memento
// 1) Originator: the object for which the state is to be saved.
// It creates the memento and uses it in future to undo.
// 2) memento: the object that is going to maintain the state of originator. It's just a POJO.
// memento class should be immutable so that no one can change its state once it is created
// The number of variables in Originator class should match the number of variables in
// memento class
// 3) caretaker: the object that keeps track of multiple memento. Like maintaining save points.
class Article{
    private String author;
    private String topic;
    private Integer articleId;
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public String getTopic() {
        return topic;
    }
    public void setTopic(String topic) {
        this.topic = topic;
    }
    public Integer getArticleId() {
        return articleId;
    }
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }
    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", topic='" + topic + '\'' +
                ", articleId=" + articleId +
                '}';
    }
    Article(String authorName, String topicName, Integer articleId){
        author = authorName;
        topic = topicName;
        this.articleId = articleId;
    }
    public ArticleMemento createMemento(){
        ArticleMemento articleMemento = new ArticleMemento(author, topic, articleId);
        return articleMemento;
    }
    public void restoreMemento(ArticleMemento articleMemento){
        this.author = articleMemento.getAuthor();
        this.topic = articleMemento.getTopic();
        this.articleId = articleMemento.getArticleId();
    }
}
class ArticleMemento{
    private String author;
    private String topic;
    private Integer articleId;
    public ArticleMemento(String author, String topic, Integer articleId) {
        this.author = author;
        this.topic = topic;
        this.articleId = articleId;
    }
    public String getAuthor() {
        return author;
    }
    public String getTopic() {
        return topic;
    }
    public Integer getArticleId() {
        return articleId;
    }
}
public class MementoDesignPattern {
    public static void main(String[] args) {
        Article article = new Article("yokesh","java",12);
        System.out.println(article);
        ArticleMemento articleMemento1 = article.createMemento();
        article.setAuthor("yokesh chowdary");
        System.out.println(article);
        article.restoreMemento(articleMemento1);
        System.out.println(article);
        ArticleMemento articleMemento2 = article.createMemento();
        article.setAuthor("yoki yokee");
        article.setTopic("python");
        System.out.println(article);
        article.restoreMemento(articleMemento2);
        System.out.println(article);
    }
}

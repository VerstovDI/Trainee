package ru.greenatom.edu.domain;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String text;

    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) // одному пользователю несколько сообщений
    //fetchType.eager - чтобы с сообщением сразу инфу об авторе получали!
    @JoinColumn(name = "user_id")
    private User author;

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    /* Это закидоны из groovy.
    Всё методы getSomething могут быть заменены на
    обращение к полю (даже если оно не существует) с именем something */
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}

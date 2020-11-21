package ru.greenatom.edu.domain;

import org.hibernate.validator.constraints.Length;
import ru.greenatom.edu.domain.util.MessageHelper;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity // This tells Hibernate to make a table out of this class
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please, fill the message")
    @Length(max = 2048, message = "Message too long (more than 2Kb")
    private String text;

    @NotBlank(message = "Please, fill the tag")
    @Length(max = 255, message = "Message too long (more than 2Kb")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER) // одному пользователю несколько сообщений
    //fetchType.eager - чтобы с сообщением сразу инфу об авторе получали!
    @JoinColumn(name = "user_id")
    private User author;
    private String fileName;

    @ManyToMany
    @JoinTable(
            name = "message_likes",
            joinColumns = { @JoinColumn(name = "message_id") },
            inverseJoinColumns = { @JoinColumn(name = "user_id") }
    )
    private Set<User> likes = new HashSet<>();

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }

    public Message() {
    }

    public Message(String text, String tag, User user) {
        this.text = text;
        this.tag = tag;
        this.author = user;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public void setId(Long id) {
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

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /* Это закидоны из groovy.
        Всё методы getSomething могут быть заменены на
        обращение к полю (даже если оно не существует) с именем something */
    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }
}

package ru.greenatom.edu.domain.dto;

import ru.greenatom.edu.domain.Message;
import ru.greenatom.edu.domain.User;
import ru.greenatom.edu.domain.util.MessageHelper;

public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String fileName;
    private Long likes;
    private Boolean meLike;

    public MessageDto(Message messsage, Long likes, Boolean meLike) {
        this.id = messsage.getId();
        this.text = messsage.getText();
        this.tag = messsage.getTag();
        this.author = messsage.getAuthor();
        this.fileName = messsage.getFileName();
        this.likes = likes;
        this.meLike = meLike;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
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

    public User getAuthor() {
        return author;
    }

    public String getFileName() {
        return fileName;
    }

    public Long getLikes() {
        return likes;
    }

    public Boolean getMeLike() {
        return meLike;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", text='" + text + '\'' +
                ", tag='" + tag + '\'' +
                ", author=" + author +
                ", fileName='" + fileName + '\'' +
                ", likes=" + likes +
                ", meLike=" + meLike +
                '}';
    }
}

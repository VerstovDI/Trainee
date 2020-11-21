package ru.greenatom.edu.domain.util;

import ru.greenatom.edu.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}

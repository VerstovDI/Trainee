package ru.greenatom.edu.repository;

import org.springframework.data.repository.CrudRepository;
import ru.greenatom.edu.domain.Message;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    List<Message> findByTag(String tag);
}

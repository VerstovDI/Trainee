package ru.greenatom.edu;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import ru.greenatom.edu.controller.MainController;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class) // указываем окружение, стартующее тесты
@SpringBootTest // "комбо-аннотация" указывает, что запускает тесты в SpringBoot приложении
// восстановит контекст и т д
@AutoConfigureMockMvc // Спринг создает структуру классов, которая подменяет слой MVC
@TestPropertySource(value = "/application-test.properties")
public class LoginTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private MainController controller;

    @Test // только с этой аннотацией метод является тестовым
    // тесты лучше в режиме дебага запускать
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
        this.mockMvc.perform(get("/"))
                .andDo(print()) // результат в консольку
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello, guest!")));
    }

    @Test
    public void mainRedirection() throws Exception {
        this.mockMvc.perform(get("/main"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @Sql(value = "/create-user-before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "/create-user-after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    public void correctLoginTest() throws Exception {
        this.mockMvc.perform(formLogin().user("admin").password("123"))
                .andDo(print())
                .andExpect(redirectedUrl("/main"));
    }

    @Test
    public void badCredentials() throws Exception {
        this.mockMvc.perform(post("/login").param("user","Shmuni"))
                .andDo(print())
                .andExpect(status().isForbidden());
    }
}

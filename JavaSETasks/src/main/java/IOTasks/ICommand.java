package IOTasks;

import java.io.IOException;

public interface ICommand {
    void execute(String command) throws IOException;
}

package IOTasks;

import java.io.File;
import java.io.IOException;

public class CreationCommand implements ICommand {
    @Override
    public void execute(String command) throws IOException {
        File file = new File(command);
        file.getParentFile().mkdirs();
        file.createNewFile();
    }
}

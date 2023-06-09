package commandLine;

import commandLineInterfaceSocket.ClientCLI;
import structures.*;

import java.io.File;

public class ClientStart {

    public static void main(String[] args) {
        Setting<Integer> headerSetting = new Setting<>(SettingTypes.HEADER_SETTING, 3);

        new File("./Logs").mkdirs();
        File logFile = new File("./Logs/CLIENT_logFile.txt");
        Logger logger = new Logger(Logger.Type.CONSOLE, logFile);

        Setting<Logger> loggerSetting = new Setting<>(SettingTypes.LOGGER_SETTING, logger);

        Settings settings = new Settings(loggerSetting);
        MessageSettings messageSettings = new MessageSettings(headerSetting);

        SettingsCollector settingsCollector = new SettingsCollector();
        settingsCollector.add(settings);
        settingsCollector.add(messageSettings);

        ClientCLI client = new ClientCLI(settingsCollector);
        client.run();
    }

}

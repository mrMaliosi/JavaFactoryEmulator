import ru.nsu.ccfit.malinovskii.factory.Emulator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Парсинг аргументов командной строки
        String configName;
        if (args.length < 1) {
            configName = "FactoryConfig.txt";
        } else if (args.length == 1) {
            configName = args[0];
        } else {
            //logger.error("Too much arguments");
            return;
        }


        // Создание фабрики и подготовка её к работе
        Emulator emulator = new Emulator();
        try {
            emulator.loadConfiguration(configName);
        } catch (Exception e) {
            //logger.error("Exception: ", e);
        }
    }
}
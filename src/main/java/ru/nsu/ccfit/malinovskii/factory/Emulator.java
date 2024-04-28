package ru.nsu.ccfit.malinovskii.factory;

import ru.nsu.ccfit.malinovskii.factory.assemblers.MachineAssembler;
import ru.nsu.ccfit.malinovskii.factory.dealerships.CarDealership;
import ru.nsu.ccfit.malinovskii.factory.providers.AccesoriesProvider;
import ru.nsu.ccfit.malinovskii.factory.providers.BodyProvider;
import ru.nsu.ccfit.malinovskii.factory.providers.EngineProvider;
import ru.nsu.ccfit.malinovskii.factory.storages.AccessoriesStorage;
import ru.nsu.ccfit.malinovskii.factory.storages.BodyStorage;
import ru.nsu.ccfit.malinovskii.factory.storages.CarStorage;
import ru.nsu.ccfit.malinovskii.factory.storages.EngineStorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Emulator {
    AccessoriesStorage accessoriesStorage;
    BodyStorage bodyStorage;
    CarStorage carStorage;
    EngineStorage engineStorage;

    AccesoriesProvider accesoriesProvider;
    BodyProvider bodyProvider;
    EngineProvider engineProvider;

    CarDealership carDealership;

    MachineAssembler machineAssembler;

    ExecutorService providersExecutor;
    ExecutorService assemblersExecutor;
    ExecutorService dealershipsExecutor;


    public void loadConfiguration(String configFile) throws IOException {
        Properties properties = new Properties();
        InputStream inputStream = Emulator.class.getResourceAsStream(configFile);
        properties.load(inputStream);

        int accessoryStorageSize = Integer.parseInt(properties.getProperty("accessoryStorageSize"));
        int bodyStorageSize = Integer.parseInt(properties.getProperty("bodyStorageSize"));
        int carStorageSize = Integer.parseInt(properties.getProperty("carStorageSize"));
        int engineStorageSize = Integer.parseInt(properties.getProperty("engineStorageSize"));
        int accessorySuppliersCount = Integer.parseInt(properties.getProperty("accessorySuppliers"));
        int workersCount = Integer.parseInt(properties.getProperty("workers"));
        int dealersCount = Integer.parseInt(properties.getProperty("dealers"));
        Boolean logSaleCount = Boolean.getBoolean(properties.getProperty("logSale"));

        accessoriesStorage.initialize(accessoryStorageSize);
        bodyStorage.initialize(bodyStorageSize);
        carStorage.initialize(carStorageSize);
        engineStorage.initialize(engineStorageSize);
        accesoriesProvider.initialize(accessorySuppliersCount);
        bodyProvider.initialize(1);
        engineProvider.initialize(1);
        machineAssembler.initialize(workersCount);
        carDealership.initialize(dealersCount);

        providersExecutor = Executors.newScheduledThreadPool(accessorySuppliersCount + 2);
        assemblersExecutor = Executors.newScheduledThreadPool(workersCount);
        dealershipsExecutor = Executors.newScheduledThreadPool(dealersCount);
    }

}

package com.uddernetworks.mineplex.main;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class Main {

    static boolean running = false;
    static String name = "";
    static long lastTime = 0;
    static Thread t;

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\lib\\chromedriver.exe");

        Form form = new Form();
        form.main();

        t = new Thread(() -> {
            try {
                while (true) {
                    if (running) {
                        if (lastTime == 0) {
                            form.addWatch();

                            System.out.println("Opening minecraft client instance...");

                            ProcessBuilder p = new ProcessBuilder();

                            File file = new File(System.getProperty("user.dir") + "\\lib\\Minecraft Client");
                            p.command("cmd", "/c", "start", "MinecraftClient.exe");
                            p.directory(file);
                            p.start();

                            Thread.sleep(5000);
                            WebDriver driver = new ChromeDriver();
                            driver.get("http://ads.mineplex.com/?server_id=1&player_uuid=" + UUIDFetcher.getUUIDOf(name));

                            Thread.sleep(40000);
                            driver.quit();
                            Thread.sleep(1000);

                            Runtime.getRuntime().exec("taskkill /F /IM MinecraftClient.exe");

                            lastTime = System.currentTimeMillis() + 3600000;
                        } else if (lastTime <= System.currentTimeMillis()) {
                            form.addWatch();

                            System.out.println("Opening minecraft client instance...");

                            ProcessBuilder p = new ProcessBuilder();

                            File file = new File(System.getProperty("user.dir") + "\\lib\\Minecraft Client");
                            p.command("cmd", "/c", "start", "MinecraftClient.exe");
                            p.directory(file);
                            p.start();

                            Thread.sleep(5000);
                            WebDriver driver = new ChromeDriver();
                            driver.get("http://ads.mineplex.com/?server_id=1&player_uuid=" + UUIDFetcher.getUUIDOf(name));

                            Thread.sleep(40000);
                            driver.quit();
                            Thread.sleep(1000);

                            Runtime.getRuntime().exec("taskkill /F /IM MinecraftClient.exe");

                            lastTime = System.currentTimeMillis() + 3600000;
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

    }
}
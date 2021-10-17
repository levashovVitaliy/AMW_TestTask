package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Terminal {

    private final String[] WINDOWS_CMD = { "cmd.exe", "/C" };
    private final String[] LINUX_CMD = { "/bin/bash", "-l", "-c" };
    private String[] command;


    public Terminal() {
        String osName = SystemProperty.osName();
        if (osName.contains("Linux"))   command = LINUX_CMD;
        if (osName.contains("Windows")) command = WINDOWS_CMD;
        if (command == null)
            throw new RuntimeException("Terminal class:\nin constructor, add new condition for OS name to run command line app");
    }


    public ArrayList<String> run(String... command) {
        ProcessBuilder pb = new ProcessBuilder(concat(this.command, command));
        pb.redirectErrorStream(true);
        try {
            Process process = pb.start();
            process.waitFor();
            ArrayList<String> result = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String outputString;
            while(((outputString = reader.readLine()) != null)) {
                result.add(outputString);
            }
            return result;
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return null;
        }
    }


    private  <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}

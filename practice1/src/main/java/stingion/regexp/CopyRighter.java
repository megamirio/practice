package stingion.regexp;

import com.google.common.io.Files;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by imalysh on 12/25/2014.
 */
public class CopyRighter {

    private static final String cap = "/*\n" +
            " * Copyright (C)SERENA Software,Inc. 2015. All Rights Reserved.\n" +
            " *\n" +
            " */\n";

    private static final String FOLDER_LOCATION = "c:\\Joe\\Dump\\Regex\\common_util\\src\\main\\java\\com\\serena\\core\\constants\\";

    enum FileType {
        EmptyCap;
    }

    public void listFilesForFolder(final File folder) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else if (Files.getFileExtension(fileEntry.getName()).equals("java")) {
                BufferedReader br = new BufferedReader(new FileReader(fileEntry));
                byte[] fileToBytes = Files.toByteArray(fileEntry);
                String fileToString = new String(fileToBytes);
                String newFile = null;

                FileType fileType = getType(fileToString);
                if (fileType == FileType.EmptyCap) {
                    newFile = cap + fileToString;
                }

                FileOutputStream fooStream = new FileOutputStream(fileEntry, false); // true to append
                // false to overwrite.
                byte[] myBytes = newFile.getBytes();
                fooStream.write(myBytes);
                fooStream.close();

                System.exit(0);
            }
        }
    }

    public FileType getType(String fileToString) {
        String patternStr = "package[\\s]+[\\w.]+;[\\s]+(public|class|enume|interface)";
        Pattern pattern = Pattern.compile(patternStr);

        Matcher m = pattern.matcher(fileToString);

        if (m.find()) return FileType.EmptyCap;

        return null;
    }


    public void setToEmptyCap(File file) {
    }

    public static void main(String[] args) throws IOException {
        CopyRighter changer = new CopyRighter();
        changer.listFilesForFolder(new File(args[0]));
    }
}

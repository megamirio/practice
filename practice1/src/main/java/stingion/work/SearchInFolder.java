package stingion.work;

import java.io.*;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by imalysh on 12/17/2014.
 */
public class SearchInFolder {
    private static final String FOLDER_LOCATION = "c:\\Joe\\Dump\\log files 2014-12-03\\";
    private static final String STRING_PATTERN = "03-12-2014";

    public void listFilesForFolder(final File folder) throws IOException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
//            } else if (fileEntry.length() < 100_000_000_000L && fileEntry.getName().contains(".ns")) {
//            } else if (fileEntry.getName().contains(".ns")) {
            } else {
//                System.out.println(fileEntry.getName() + " "
//                        + NumberFormat.getNumberInstance(Locale.US).format(fileEntry.length()));
                BufferedReader br = new BufferedReader(new FileReader(fileEntry));
                String line;
//                boolean isFileNameShown = false;
                while ((line = br.readLine()) != null) {
                    if (line.contains(STRING_PATTERN)) {
//                        if (!isFileNameShown) {
//                            System.out.println(fileEntry.getName() + " "
//                                    + NumberFormat.getNumberInstance(Locale.US).format(fileEntry.length()));
//                            isFileNameShown = true;
//                        }
                        System.out.println(fileEntry.getName() + " "
                                + NumberFormat.getNumberInstance(Locale.US).format(fileEntry.length()));
                        break;
//                        System.out.println(line);
                    }
                }
                br.close();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        SearchInFolder search = new SearchInFolder();
        search.listFilesForFolder(new File(FOLDER_LOCATION));
    }
}

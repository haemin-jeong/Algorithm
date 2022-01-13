package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 파일명_정렬 {
    static class File implements Comparable<File> {
        private String head;
        private String number;
        private String tail;

        private File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        public static File stringToFile(String fileName) {
            String head = null;
            String number = null;
            String tail = null;

            int i;
            for(i = 0; i < fileName.length(); i++) {
                if(Character.isDigit(fileName.charAt(i))) {
                    head = fileName.substring(0, i);
                    break;
                }
            }

            int j;
            for(j = i; j < fileName.length(); j++) {
                if(!Character.isDigit(fileName.charAt(j))) {
                    number = fileName.substring(i, j);
                    break;
                }
            }

            if(number == null) {
                number = fileName.substring(i);
                tail = "";
            } else {
                tail = fileName.substring(j);
            }

            return new File(head, number, tail);
        }

        @Override
        public int compareTo(File o) {
            int result = this.head.compareToIgnoreCase(o.head);
            return result == 0 ? Integer.parseInt(this.number) - Integer.parseInt(o.number) : result;
        }
    }

    public String[] solution(String[] files) {
        Map<String, File> fileMap = new HashMap<>();

        for(String fileName : files) {
            fileMap.put(fileName, File.stringToFile(fileName));
        }

        Arrays.sort(files, (f1, f2) -> {
            File file1 = fileMap.get(f1);
            File file2 = fileMap.get(f2);
            return file1.compareTo(file2);
        });

        return files;
    }
}

package ioutil;

import java.io.*;

public class IOUtil {

    public static void editFile(String filename, int start, int end , String text) {
        // start ~ end line의 내용 수정
        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);
            StringBuilder stringBuilder = new StringBuilder();

            // 수정할 글 이전 저장
            for (int i = 0 ; i < start ; i++) {
                String line = br.readLine();
                stringBuilder.append(line).append("\n");
            }
            stringBuilder.append(text);


            if (end != -1) {
                // 수정되어지는 부분
                for (int i = 0 ; i < end - start ; i++) {
                    br.readLine();
                }

                // 수정할 글 이후 저장
                String line;
                while ((line = br.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
            }

            fw = new FileWriter(filename);
            bw = new BufferedWriter(fw);

            bw.write(stringBuilder.toString());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
                if (fr != null) fr.close();
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void appendFile(String filename, String text) {
        FileWriter fw = null;

        try {
            fw = new FileWriter(filename, true);
            fw.append(text);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null) fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static String readFile(String filename, int start, int end) {
        // start ~ end line까지 읽음
        FileReader fr = null;
        BufferedReader br = null;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            fr = new FileReader(filename);
            br = new BufferedReader(fr);

            String line;
            int lineNum = 0;
            while ((line = br.readLine()) != null) {
                if (lineNum >= start) {
                    stringBuilder.append(line).append("\n");
                }
                lineNum += 1;
                if (lineNum == end) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (fr != null) fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();

    }

    public static void updateIndexFile(String indexFile, String boardFile) {
        FileReader boardRead = null;
        BufferedReader boardReadBuff = null;
        FileWriter indexWrite = null;
        BufferedWriter indexWriteBuff = null;

        try {
            boardRead = new FileReader(boardFile);
            boardReadBuff = new BufferedReader(boardRead);
            indexWrite = new FileWriter(indexFile);
            indexWriteBuff = new BufferedWriter(indexWrite);

            StringBuilder stringBuilder = new StringBuilder();
            String line;
            int lineNum = 0;

            while ((line = boardReadBuff.readLine()) != null) {
                String[] index = line.split("\\|");
                stringBuilder.append(index[0]).append("|").append(lineNum).append("\n");
                lineNum += 1;

                while (!"end".equals(line) && line != null) {
                    line = boardReadBuff.readLine();
                    lineNum += 1;
                }
            }

            indexWriteBuff.write(stringBuilder.toString());
            indexWriteBuff.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (indexWriteBuff != null) indexWriteBuff.close();
                if (boardReadBuff != null) boardReadBuff.close();
                if (indexWrite != null) indexWrite.close();
                if (boardRead != null) boardRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}

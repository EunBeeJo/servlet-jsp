package db;

import ioutil.IOUtil;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DB {

    private final String boardFile = "board.txt";
    private final String indexFile = "index.txt";

    public DB() {
        File file = new File(boardFile);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        file = new File(indexFile);

        if(!file.exists()) {
            try{
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void save(Map<String, String> board) {
        board.put("index", Integer.toString(getTextCount()+1));
        board.put("content", board.get("content")+"\nend\n");
        String text = board.get("index") + "|" + board.get("title") + "|" + board.get("writer") + "|"
                + board.get("hits") + "\n" + board.get("content");

        IOUtil.appendFile(boardFile, text);
        updateIndex();
    }

    public void save(String textNum, Map<String, String> board, boolean isEdit) {
        if (isEdit) {
            board.put("content", board.get("content") + "\nend\n");
        }
        String text = board.get("index") + "|" + board.get("title") + "|" + board.get("writer") + "|"
                + board.get("hits") + "\n" + board.get("content");

        int nextIndex = getNextIndex(Integer.parseInt(textNum));
        IOUtil.editFile(boardFile, hasTextNum(textNum), nextIndex, text);
        updateIndex();
    }

    public Map<String, String> getBoard(String textNum) {
        Map<String, String> board = new HashMap<String, String>();

        int nextIndex = getNextIndex(Integer.parseInt(textNum));
        String []text = IOUtil.readFile(boardFile, hasTextNum(textNum), nextIndex).split("\n");
        String []header = text[0].split("\\|");
        StringBuilder content = new StringBuilder();

        board.put("index", header[0]);
        board.put("title", header[1]);
        board.put("writer", header[2]);
        board.put("hits", header[3]);

        for (int i = 1 ; i < text.length ; i++) {
            content.append(text[i]).append("\n");
        }
        board.put("content", content.toString());

        return board;
    }

    public void delete(String textNum) {
        int nextIndex = getNextIndex(Integer.parseInt(textNum));
        IOUtil.editFile(boardFile, hasTextNum(textNum), nextIndex, "");
        updateIndex();
    }

    public int getTextCount() {

        String lines = IOUtil.readFile(indexFile, 0, -1);
        if ("".equals(lines)) {
            return -1;
        }

        String[] index = lines.split("\n");
        String[] textCount = index[index.length-1].split("\\|");

        return Integer.parseInt(textCount[0]);
    }

    public int hasTextNum(String textNum) {
        String[] line = IOUtil.readFile(indexFile, 0, -1).split("\n");

        for (int i = 0 ; i < line.length ; i++) {
            String[] index = line[i].split("\\|");
            if (textNum.equals(index[0])) {
                return Integer.parseInt(index[1]);
            }
        }

        return -1;
    }

    public void updateIndex() {
        IOUtil.updateIndexFile(indexFile, boardFile);
    }

    public int getNextIndex(int textNum) {
        int nextIndex = -1;
        int textCount = getTextCount();

        for (int i = textNum+1 ; i < textCount+1 ; i++) {
            nextIndex = hasTextNum(Integer.toString(i));
            if (nextIndex > -1) {
                break;
            }
        }

        return nextIndex;
    }
}
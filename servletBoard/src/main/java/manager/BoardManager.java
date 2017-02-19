package manager;

import java.util.HashMap;
import java.util.Map;

import db.DB;

public class BoardManager {

    private DB db = new DB();


    public Map<String, Map<String, String>> boardList() {
        int textCount = db.getTextCount();
        int listNum = 0;
        Map<String, Map<String, String>> list = new HashMap<String, Map<String, String>>();
        if (textCount > -1) {
            for (int i = 0 ; i < textCount+1 ; i++) {
                if (db.hasTextNum(Integer.toString(i)) > -1) {
                    Map<String, String> board = db.getBoard(Integer.toString(i));
                    list.put(Integer.toString(listNum), board);
                    listNum += 1;
                }
            }
        } else {
            System.out.println("게시글이 없습니다.");
        }

        return list;
    }

    public void addBoard(Map<String, String> board) {
        // 저장
        board.put("hits", "0");
        db.save(board);
    }


    public Map<String, String> readBoard(String textNum) {
        // 글 내용 출력
        Map<String, String> board = null;
        if (db.hasTextNum(textNum) > -1) {
            board = db.getBoard(textNum);

            // 조회수 증가
            int hits = Integer.parseInt(board.get("hits"));
            hits += 1;
            board.put("hits", Integer.toString(hits));
            db.save(textNum,board,false);

        } else {
            System.out.println("게시글이 없습니다.");
        }

        return board;
    }

    public void editBoard(Map<String, String> board) {
        db.save(board.get("index"),board,true);
    }

    public void deleteBoard(String textNum) {
        if (db.hasTextNum(textNum) > -1) {
            // 삭제
            db.delete(textNum);
        } else {
            System.out.println("게시글이 없습니다.");
        }
    }

    public Map<String, String> getBoard(String textNum) {
        return db.getBoard(textNum);
    }
}

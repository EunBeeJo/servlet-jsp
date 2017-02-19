package servlet;

import manager.BoardManager;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BoardListServlet extends HttpServlet {
    private BoardManager boardManager = null;
    private Map<String, Map<String, String>> returnBoardList;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.boardManager = (BoardManager) config.getServletContext().getAttribute("boardManager");
        returnBoardList = new HashMap<String, Map<String, String>>();
    }

    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        // 1. 데이터 추출
        returnBoardList = boardManager.boardList();

        // 2. 유효성 검사
        if (returnBoardList == null) {

        }

        // 3. 처리
        // 4. 결과 출력
        req.setAttribute("returnBoardList", returnBoardList);

        req.getRequestDispatcher("/board/list.jsp").forward(req, res);
    }
}

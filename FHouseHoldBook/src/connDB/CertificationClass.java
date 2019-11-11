package connDB;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CertificationClass
 */
@WebServlet("/Certification")
public class CertificationClass extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//IDとパスワードは以下に記載
	final static String[] Username = { "user", "admin" };
	final static String[] Password = { "pass", "admin" };
	int Cert = 0;
	/**
	 * ログイン状態 
	 * ０：未ログイン
	 * １：ログイン
	 */
	private int CertStatus = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CertificationClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 入力パラメータの取得
		String getId = request.getParameter("id");
		String getPw = request.getParameter("pw");

		Cert = CertificationUser(getId , getPw);
		System.out.println(Cert);
		if (Cert != 1){
			//NGメッセージの表示
			BackToNgMsg(request, response, Cert);
			return;
		}
		doGet(request, response);
	}

	/**
	 * NGメッセージの表示
	 * @param request
	 * @param response
	 * @param Cert
	 * @throws ServletException
	 * @throws IOException
	 */
	private void BackToNgMsg(HttpServletRequest request, HttpServletResponse response, int Cert)throws ServletException, IOException{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	 	out.println("<!DOCTYPE html>");
		out.println("<html>");
	 	out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
	    out.println("<head>");
	    out.println("<title>Webタイトル</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>ログイン結果</h1>");
	    out.println("ログインできませんでした。");
	    out.println("<h5>StatusCode = " + Cert + "</h5>" );
	    out.println("</body>");
	    out.println("</html>");

	}


/**
 * 隱崎ｨｼmethod縲�return縺�1莉･螟悶�ｯNG
 * @param id�ｼ啗eb繝壹�ｼ繧ｸ縺九ｉ蜈･蜉帙＆繧後◆ID
 * @param pw�ｼ壹ヱ繧ｹ繝ｯ繝ｼ繝�
 * @return 1�ｼ夊ｪ崎ｨｼOK
 * @return 0�ｼ壹◎縺ｮ莉悶�ｮ繧ｨ繝ｩ繝ｼ
 * @return -1�ｼ壹ヱ繧ｹ繝ｯ繝ｼ繝芽ｪ崎ｨｼNG
 * @return -2�ｼ唔D隱崎ｨｼNG
 * @return -3�ｼ唔D縺輝W縺梧悴蜈･蜉幢ｼ�NULL�ｼ�
 */
	private int CertificationUser(String id , String pw){

		/* NULLチェック */
		if (id.isEmpty()||pw.isEmpty()){
			System.out.println("ID or PW is NULL");
			return (-3);
		}

		System.out.println(id + pw);

		/** 認証チェック */
		for(int i = 0; i < Username.length; i++){
			if(Username[i].equals(id)){
				if (CertificationSetPw( pw , i )){
					//認証OKとログイン状態のセット
					CertStatus = 1;
					return (1);
				}
				else {
					//PW認証NG
					return (-1);
				}
			}
		}
		//ID認証NG
		return (-2);
	}

	/**
	 * 繝代せ繝ｯ繝ｼ繝芽ｪ崎ｨｼ
	 * @param pw
	 * @param idxId�ｼ唔D縺ｮ繧､繝ｳ繝�繝�繧ｯ繧ｹ
	 * @return 1�ｼ啀W隱崎ｨｼOK
	 */
	private boolean CertificationSetPw( String pw , int idxId ){

		if (Password[idxId].equals(pw)){
			return (true);
		}
		return (false);
	}


}

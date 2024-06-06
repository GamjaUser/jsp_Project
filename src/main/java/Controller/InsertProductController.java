package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import DAO.ProductDAO;
import DTO.MemberDTO;
import DTO.ProductDTO;


@WebServlet("/insertProduct.do")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
maxFileSize = 1024 * 1024 * 10,      // 10 MB
maxRequestSize = 1024 * 1024 * 15)   // 15 MB
public class InsertProductController extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("insertProduct!!");
		
		HttpSession session = req.getSession();
		MemberDTO mdto = (MemberDTO) session.getAttribute("member");
		
		if(mdto.getLevel() != 0) {
			resp.sendRedirect("/login&profile/login.jsp");
        	return;
		}
		ProductDAO dao = new ProductDAO();
		ProductDTO dto = new ProductDTO();

        String name = req.getParameter("productName");
        String comment = req.getParameter("productComment");
        String price = req.getParameter("productPrice");
        String productKind = req.getParameter("productKind");
        
        Part filePart = req.getPart("productImg"); // Retrieves <input type="file" name="productImg">
        String fileName = getFileName(filePart);
		
     // Define the path to save the file
        String uploadPath = "C:\\Users\\whwog\\OneDrive\\바탕 화면\\js\\jsp_Project\\img\\product";
//        String uploadPath = "C:\\img\\product";
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        // Save the file on the server
        filePart.write(uploadPath + File.separator + fileName);
        String filePath = uploadPath + File.separator + fileName; // Path to save in the database
        
        System.out.println("======================================");
        System.out.println(name);
        System.out.println(filePath);
        System.out.println(comment);
        System.out.println(price);
        System.out.println(productKind);
        
        dto.setName(name);
        dto.setImg(filePath);
        dto.setComment(comment);
        dto.setPrice(Integer.parseInt(price));
        dto.setProductKind(productKind);
		
		int result = dao.insertPrdouct(dto);
		
	}

    // Utility method to get file name from the part header
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 2, token.length() - 1);
            }
        }
        return "";
    }
}

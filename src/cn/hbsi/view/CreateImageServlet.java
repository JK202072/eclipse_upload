package cn.hbsi.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CreateImageServlet")
public class CreateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public CreateImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    Color getRandColor(int fc,int bc) {
    	Random random=new Random();
    	if (fc>255) {
			fc=255;
		}
    	if (bc>255) {
			bc=255;
		}
    	int r=fc+random.nextInt(bc-fc);
    	int g=fc+random.nextInt(bc-fc);
    	int b=fc+random.nextInt(bc-fc);
    	return new Color(r,g,b);

    }

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("image/jpeg");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("cache-control", "no-cache");
		response.addDateHeader("expires", 0);
		
		int width=60;
		int height=20;
		
		BufferedImage image=new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Graphics g=image.getGraphics();
		g.setColor(getRandColor(200, 250));
		g.fillRect(0, 0, width, height);
		g.setColor(getRandColor(160, 200));
		Random random=new Random();
		for (int i = 0; i < 100; i++) {
			int x=random.nextInt(width);
			int y=random.nextInt(height);
			int x1=random.nextInt(12);
			int y1=random.nextInt(12);
			g.drawLine(x, y, x+x1, y+y1);
		}
		String codestr="";
		String [] str= {"Q","W","E","R","T","Y","U","I","P","A","S","D","F","G","H","J","K","L","Z","X","C","V","B","N","M",
				        "q","w","e","r","t","y","u","i","p","a","s","d","f","g","h","j","k","l","z","x","c","v","b","n","m"};
		for(int i=0;i<4;i++) {
			String rand="";
			if (random.nextBoolean()) {
				rand=String.valueOf(random.nextInt(10));
			}else {
				int index=random.nextInt(49);
				rand=str[index];
			}
			g.setColor(getRandColor(20, 130));
			g.setFont(new Font("Times New Roman", Font.PLAIN, 18));
			g.drawString(rand, 13*i+6, 16);
			codestr+=rand;
		}
		HttpSession session=request.getSession();
		session.setAttribute("code", codestr);
		ImageIO.write(image, "JPEG", response.getOutputStream());
		response.getOutputStream();
		response.getOutputStream();
		response.flushBuffer();
		}
	}



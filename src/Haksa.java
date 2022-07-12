import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Haksa extends JFrame{
    
 JPanel panel;  // 메뉴별 화면이 출력되는 패널

 
Haksa(){
  setTitle("학사관리시스템"); 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 누르면 프로그램 종료
  Container c = this.getContentPane();
  c.setLayout(new FlowLayout());
  ImageIcon icon = new ImageIcon("images/img1.jpg");
  JLabel label = new JLabel(icon);
  c.add(label);
  
  this.pack();
  this.setVisible(true);

  JMenuBar bar=new JMenuBar();
  
  JMenu m_home=new JMenu("HOME");//HOME메뉴
  bar.add(m_home);
  
  JMenuItem mi_main = new JMenuItem("메인으로 돌아가기");
  m_home.add(mi_main);
  mi_main.addActionListener(new ActionListener(){

	@Override
	public void actionPerformed(ActionEvent e) {		
		c.removeAll();
		c.revalidate();
		c.repaint();
		c.setLayout(new FlowLayout());
		ImageIcon icon = new ImageIcon("images/img1.jpg");
		JLabel label = new JLabel(icon);
		c.add(label);
		setVisible(true);
	}});
  
  JMenu m_student=new JMenu("학생관리");//File메뉴
  bar.add(m_student);
  
  JMenu m_book=new JMenu("도서관리");//Edit메뉴
  bar.add(m_book);
  
  JMenuItem mi_list=new JMenuItem("학생정보");
  m_student.add(mi_list);
  
  mi_list.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
	c.removeAll(); //모든 컴포넌트 삭제
	c.revalidate();  //다시 활성화
	c.repaint();  //다시 그리기
	c.add(new Student()); //화면 생성.
	c.setLayout(null); //레이아웃적용안함
   }});
   
  JMenuItem mi_bookRent=new JMenuItem("대출목록");
  m_book.add(mi_bookRent);
  
  mi_bookRent.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
	c.removeAll();
	c.revalidate();
	c.repaint();
	c.add(new BookRent()); //화면 생성.
	c.setLayout(null);

   }});
  
  JMenuItem mi_bookRentNow=new JMenuItem("대출현황");
  m_book.add(mi_bookRentNow);
  
  mi_bookRentNow.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    add(new BookRentNow()); //화면 생성.
   }});
  
  panel=new JPanel();//panel생성
  add(panel);//프레임에 패널 추가
  
  setJMenuBar(bar);
  setSize(800,600);  
  setVisible(true);
  
 }
 
public static void main(String[] args) {
  
  new Haksa();
 }

}
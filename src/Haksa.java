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
    
 JPanel panel;  // �޴��� ȭ���� ��µǴ� �г�

 
Haksa(){
  setTitle("�л�����ý���"); 
  setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x��ư ������ ���α׷� ����
  Container c = this.getContentPane();
  c.setLayout(new FlowLayout());
  ImageIcon icon = new ImageIcon("images/img1.jpg");
  JLabel label = new JLabel(icon);
  c.add(label);
  
  this.pack();
  this.setVisible(true);

  JMenuBar bar=new JMenuBar();
  
  JMenu m_home=new JMenu("HOME");//HOME�޴�
  bar.add(m_home);
  
  JMenuItem mi_main = new JMenuItem("�������� ���ư���");
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
  
  JMenu m_student=new JMenu("�л�����");//File�޴�
  bar.add(m_student);
  
  JMenu m_book=new JMenu("��������");//Edit�޴�
  bar.add(m_book);
  
  JMenuItem mi_list=new JMenuItem("�л�����");
  m_student.add(mi_list);
  
  mi_list.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
	c.removeAll(); //��� ������Ʈ ����
	c.revalidate();  //�ٽ� Ȱ��ȭ
	c.repaint();  //�ٽ� �׸���
	c.add(new Student()); //ȭ�� ����.
	c.setLayout(null); //���̾ƿ��������
   }});
   
  JMenuItem mi_bookRent=new JMenuItem("������");
  m_book.add(mi_bookRent);
  
  mi_bookRent.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
	c.removeAll();
	c.revalidate();
	c.repaint();
	c.add(new BookRent()); //ȭ�� ����.
	c.setLayout(null);

   }});
  
  JMenuItem mi_bookRentNow=new JMenuItem("������Ȳ");
  m_book.add(mi_bookRentNow);
  
  mi_bookRentNow.addActionListener(new ActionListener(){

   @Override
   public void actionPerformed(ActionEvent e) {
    add(new BookRentNow()); //ȭ�� ����.
   }});
  
  panel=new JPanel();//panel����
  add(panel);//�����ӿ� �г� �߰�
  
  setJMenuBar(bar);
  setSize(800,600);  
  setVisible(true);
  
 }
 
public static void main(String[] args) {
  
  new Haksa();
 }

}
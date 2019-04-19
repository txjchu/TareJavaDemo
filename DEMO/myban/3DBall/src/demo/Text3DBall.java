package demo;
import java.awt.BorderLayout;//������
import java.awt.Button;
import java.awt.GraphicsConfiguration;
import java.awt.Panel;
import java.awt.event.*;
import javax.media.j3d.*;
import javax.swing.JFrame;
import javax.swing.Timer;
import javax.vecmath.*;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
public class Text3DBall extends JFrame implements ActionListener, KeyListener {//������ά�������
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button start = new Button("�� ��"); //������ʼ��ť
	private TransformGroup tranGroup;//������ά�任��
	private Transform3D trans = new Transform3D();//������ά�任����
	private float X = 0.0f;//��ĺ�����,����Ϊ�����˶�
	private float Y = 0.0f;//��Y���꣬0Ϊ��ʾ������,����Ϊ�����˶�
	private float symbol = 1.0f; //�������˶�����1Ϊ�����˶���-1������
	private Timer timeController; //��ʱ��,�������˶�
	public Text3DBall() {//���췽�����г�ʼ��
		this.getContentPane().setLayout(new BorderLayout());//���ò���
		/**
		 * GraphicsConfiguration ��������ͼ��Ŀ�꣨���ӡ�������������������������뵥һͼ���豸��ص� GraphicsConfiguration �������Ǳ�ʾ�˲�ͬ�Ļ�ͼģʽ���ܡ�
		 */
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//�õ��Ƽ������� (��ü򵥵��������� ��JAVA3D���棬���е����������һ��ͼ��Ľṹ��������˵ľ�����������)
		Canvas3D c = new Canvas3D(config);//�������ô���3D����
		this.getContentPane().add("Center", c);//���þ������
		c.addKeyListener(this);//������Ӽ��̼�����
		timeController = new Timer(100, this); //����һ��ʱ��
		Panel panel = new Panel();//����һ���
		panel.add(start);//�����ӿ�ʼ��ť
		this.getContentPane().add("South", panel);//�����ڴ��ڵ�����
		start.addActionListener(this);//��ť��Ӽ�����
		start.addKeyListener(this);//��ť���̼�����
		BranchGroup branch = createSceneGraph();//������������Ľṹ(����)
		SimpleUniverse universe = new SimpleUniverse(c);//����3D������������������
		universe.getViewingPlatform().setNominalViewingTransform(); //ע������
		universe.addBranchGraph(branch);//����������ӳ���
	}
	public  BranchGroup createSceneGraph() {//������ά��
		BranchGroup root = new BranchGroup(); // ����������Ľṹ
		Sphere sphere = new Sphere(0.25f);//����һ�����岢���뵽������
		tranGroup = new TransformGroup();//������ά�任��
		tranGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);//�������������߼���֮��̬����ӽ��
		Transform3D transform3D = new Transform3D();//������ά�任����
		transform3D.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));//����Transform�ƶ����嵽ָ��λ��
		tranGroup.setTransform(transform3D);//��ά�任�������ά�任����
		tranGroup.addChild(sphere);//����ӽڵ�
		root.addChild(tranGroup);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),1000.0);//ָ��һ�����ĵ����İ뾶������һ����������
		Color3f color=new Color3f(1.8f,0.1f,0.1f); //����һ�����ڵ�����100�׵ĺ�ɫ��Դ
		Vector3f direction = new Vector3f(4.0f, -7.0f, -12.0f);//Ϊ����ָ��λ��
		DirectionalLight light = new DirectionalLight(color,
				direction);//���������Դ
		light.setInfluencingBounds(bounds);
		root.addChild(light);
		Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);//���û�����
		AmbientLight ambientLightNode = new AmbientLight(ambientColor);
		ambientLightNode.setInfluencingBounds(bounds);
		root.addChild(ambientLightNode);
		return root;
	}
	public void keyPressed(KeyEvent e) {//���̰��µ��¼�
		if (e.getKeyChar() == 'd') {//����d��
			X = X + 0.1f;
		}
		if (e.getKeyChar() == 'a') {//����a��
			X = X - 0.1f;
		}
	}
	public void keyTyped(KeyEvent e) {//���ַ��������¼�
	}
	public void keyReleased(KeyEvent e) {//��������
	}
	public void actionPerformed(ActionEvent e) {//������ť�¼��Ͷ�ʱ��
		if (e.getSource() == start) {//���¿�ʼ��ť
			if (!timeController.isRunning()) {
				timeController.start();//������ʱ��
			}
		} else {
			Y += 0.1 * symbol;// ��ʱ���¼�
			if (Math.abs(Y * 2) >= 1) {//���˵㴦�任����
				symbol = -1.0f * symbol;
			}
			if (Y < -0.4f) {
				trans.setScale(new Vector3d(1.0, 0.8, 1.0));//�����ʵ���ȵĶ���
			} else {
				trans.setScale(new Vector3d(1.0, 1.0, 1.0));
			}
			trans.setTranslation(new Vector3f(X, Y, 0.0f));//�����ڱ任��ָ����λ��
			tranGroup.setTransform(trans);
		}
	}
	public static void main(String[] args) {//java��������ڴ�
		Text3DBall text = new Text3DBall();//ʵ��������
		text.addKeyListener(text);//��Ӽ��̼�����
		text.setSize(500, 400);//���ô��ڴ�С
		text.setTitle("��ά������Ϸ");//���ñ���
		text.setVisible(true);//����
		text.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���
		
		//�쳣��
		//Exception in thread "main" java.lang.UnsatisfiedLinkError: no j3dcore-d3d in java.library.path
	}
}

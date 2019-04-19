package demo;
import java.awt.BorderLayout;//引入类
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
public class Text3DBall extends JFrame implements ActionListener, KeyListener {//操作三维弹球的类
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Button start = new Button("运 动"); //创建开始按钮
	private TransformGroup tranGroup;//声明三维变换组
	private Transform3D trans = new Transform3D();//创建三维变换对象
	private float X = 0.0f;//球的横坐标,正数为向右运动
	private float Y = 0.0f;//球Y坐标，0为表示在中心,正数为向上运动
	private float symbol = 1.0f; //球上下运动方向，1为向上运动，-1表向下
	private Timer timeController; //定时器,球上下运动
	public Text3DBall() {//构造方法进行初始化
		this.getContentPane().setLayout(new BorderLayout());//设置布局
		/**
		 * GraphicsConfiguration 类描述了图形目标（如打印机或监视器）的特征。有许多与单一图形设备相关的 GraphicsConfiguration 对象，它们表示了不同的绘图模式或功能。
		 */
		GraphicsConfiguration config = SimpleUniverse.getPreferredConfiguration();//得到推荐的配置 (获得简单的宇宙配置 在JAVA3D里面，所有的组件构成了一个图表的结构，其中最顶端的就是虚拟宇宙)
		Canvas3D c = new Canvas3D(config);//根据配置创建3D画布
		this.getContentPane().add("Center", c);//设置居中面板
		c.addKeyListener(this);//窗口添加键盘监听器
		timeController = new Timer(100, this); //创建一定时器
		Panel panel = new Panel();//创建一面板
		panel.add(start);//面板添加开始按钮
		this.getContentPane().add("South", panel);//面板放在窗口的南面
		start.addActionListener(this);//按钮添加监听器
		start.addKeyListener(this);//按钮键盘监听器
		BranchGroup branch = createSceneGraph();//创建容纳物体的结构(场景)
		SimpleUniverse universe = new SimpleUniverse(c);//根据3D画布创建简单虚拟宇宙
		universe.getViewingPlatform().setNominalViewingTransform(); //注视球体
		universe.addBranchGraph(branch);//虚拟宇宙添加场景
	}
	public  BranchGroup createSceneGraph() {//创建三维球
		BranchGroup root = new BranchGroup(); // 创建容纳球的结构
		Sphere sphere = new Sphere(0.25f);//创建一个球体并加入到物体组
		tranGroup = new TransformGroup();//声明三维变换组
		tranGroup.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);//允许在其编译或者激活之后动态添加子结点
		Transform3D transform3D = new Transform3D();//创建三维变换对象
		transform3D.setTranslation(new Vector3f(0.0f, 0.0f, 0.0f));//设置Transform移动物体到指定位置
		tranGroup.setTransform(transform3D);//三维变换组添加三维变换对象
		tranGroup.addChild(sphere);//添加子节点
		root.addChild(tranGroup);
		BoundingSphere bounds = new BoundingSphere(new Point3d(0.0, 0.0, 0.0),1000.0);//指定一个中心点和球的半径来设置一个区域球体
		Color3f color=new Color3f(1.8f,0.1f,0.1f); //创建一个从在点延伸100米的红色光源
		Vector3f direction = new Vector3f(4.0f, -7.0f, -12.0f);//为物体指定位置
		DirectionalLight light = new DirectionalLight(color,
				direction);//创建定向光源
		light.setInfluencingBounds(bounds);
		root.addChild(light);
		Color3f ambientColor = new Color3f(1.0f, 1.0f, 1.0f);//设置环境光
		AmbientLight ambientLightNode = new AmbientLight(ambientColor);
		ambientLightNode.setInfluencingBounds(bounds);
		root.addChild(ambientLightNode);
		return root;
	}
	public void keyPressed(KeyEvent e) {//键盘按下的事件
		if (e.getKeyChar() == 'd') {//按下d键
			X = X + 0.1f;
		}
		if (e.getKeyChar() == 'a') {//按下a键
			X = X - 0.1f;
		}
	}
	public void keyTyped(KeyEvent e) {//有字符被输入事件
	}
	public void keyReleased(KeyEvent e) {//键被弹起
	}
	public void actionPerformed(ActionEvent e) {//监听按钮事件和定时器
		if (e.getSource() == start) {//按下开始按钮
			if (!timeController.isRunning()) {
				timeController.start();//启动定时器
			}
		} else {
			Y += 0.1 * symbol;// 定时器事件
			if (Math.abs(Y * 2) >= 1) {//到端点处变换方向
				symbol = -1.0f * symbol;
			}
			if (Y < -0.4f) {
				trans.setScale(new Vector3d(1.0, 0.8, 1.0));//设置适当标度的对象
			} else {
				trans.setScale(new Vector3d(1.0, 1.0, 1.0));
			}
			trans.setTranslation(new Vector3f(X, Y, 0.0f));//将球在变换到指定的位置
			tranGroup.setTransform(trans);
		}
	}
	public static void main(String[] args) {//java程序主入口处
		Text3DBall text = new Text3DBall();//实例化对象
		text.addKeyListener(text);//添加键盘监听器
		text.setSize(500, 400);//设置窗口大小
		text.setTitle("三维弹球游戏");//设置标题
		text.setVisible(true);//可视
		text.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作
		
		//异常：
		//Exception in thread "main" java.lang.UnsatisfiedLinkError: no j3dcore-d3d in java.library.path
	}
}

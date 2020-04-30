package crm.frontend.demo;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;
public class AB {
	public static void main(String[] args){
		//(1)创建一个显示器
		Display display=new Display();
		//(2)在显示器中创建一个窗口，窗口的类型
		Shell parentShell=new Shell(display,SWT.SHELL_TRIM);
		parentShell.setText("I am parent_Window");
		//(3)在窗口中添加按钮部件
		Button createButton=new Button(parentShell,SWT.CENTER);
		createButton.setText("create a new Window");
		//(4)窗口的显示与打开
		parentShell.pack();//窗口自适应
//		parentShell.setSize(400,400);//窗口大小自定义
		parentShell.open();
		createButton.setSize(200,100);
		//(5)关闭窗口
		while(!parentShell.isDisposed()){//当窗口没有释放（关闭）的时候
			if(!display.readAndDispatch()){//当操作系统的队列中没有等待处理的事件的时候
				display.sleep();//显示器休息一会儿
			}
		}//parentShell在关闭窗口的时候就已经dispose释放了
		display.dispose();//显示器释放系统资源
	}
}

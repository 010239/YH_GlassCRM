package crm.frontend.demo;

import org.eclipse.swt.widgets.*;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.jface.dialogs.*;
public class B {
	public static void main(String[] args){
		//功能：从一个窗口创建出一个子窗口，实际上就是触发一个事件
		//(1)创建一个显示器
		Display display=new Display();
		//(2)在显示器中创建一个窗口，窗口的类型
		final Shell parentShell=new Shell(display,SWT.SHELL_TRIM);
		parentShell.setText("I am parent_Window");
		//(3)在窗口中添加按钮部件
		Button createButton=new Button(parentShell,SWT.CENTER);
		createButton.setText("create a new Window");
		//(4)窗口的显示与打开
		//parentShell.pack();//窗口自适应
		parentShell.setSize(400,400);//窗口自定义
		parentShell.open();
		createButton.setSize(200,100);
		//(5)在窗口上添加一个跳转事件
		createButton.addSelectionListener(new SelectionListener()//new SelectionAdapter()两个结果一模一样
		{
			public void widgetSelected(SelectionEvent event)
			{
				MessageDialog.openInformation(parentShell, "information dialog", "I am an information");
			}
			public void widgetDefaultSelected(SelectionEvent event)
			{
				
			}
		});
		//(6)关闭窗口
		while(!parentShell.isDisposed()){//当窗口没有释放（关闭）的时候
			if(!display.readAndDispatch()){//当操作系统的队列中没有等待处理的事件的时候
				display.sleep();//显示器休息一会儿
			}
		}//parentShell在关闭窗口的时候就已经dispose释放了
		display.dispose();//显示器释放系统资源
	}
}

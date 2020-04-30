package crm.frontend.demo;

import org.eclipse.swt.SWT;//SWT常量
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
public class C {
	public static void main(String[] args){
		//功能：从一个窗口创建出多个子窗口，实际上就是触发多个事件
		//(1)创建一个显示器
		Display display=new Display();
		//(2)在显示器中创建一个窗口
		final Shell parentShell=new Shell(display);
		parentShell.setText("I am parent_shell");		
		//(3)在窗口中添加按钮部件
		Button createButton=new Button(parentShell,SWT.CENTER);
		createButton.setText("create a new Window");
		//(4)窗口的显示与打开
		//parentShell.pack();//窗口自适应
		parentShell.setSize(400,400);//窗口大小自定义
		parentShell.open();
		createButton.setSize(200,100);		
		//(5)在窗口上添加一个跳转事件
		createButton.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent event)
			{
				createChildrenShell(parentShell);
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
	
	public String getTestValue() {
		return "hello";
	}
	
	public static Shell createChildrenShell(Shell parent){
//		parent.setEnabled(false);
//		parent.setTouchEnabled(false);
		//(1)在父窗口中创建一个子窗口对象
		Shell childrenShell=new Shell(parent);//在父窗口中创建子窗口
		childrenShell.setText("I am child_shell");		
		//(2)显示子窗口
		//childrenShell.pack();窗口自适应
		childrenShell.setSize(200,200);
		childrenShell.open();
		//(3)返回子窗口
		return childrenShell;
	}
}
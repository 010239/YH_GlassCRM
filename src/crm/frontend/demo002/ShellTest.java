package crm.frontend.demo002;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class ShellTest {
	/*
	 * 通过display来创建shell Shell(Display display)
	 */
	public static void createShell1() {
// 新建一个Display对象
		Display display = new Display();
// 根据已创建的Display对象新建一个Shell对象
// Shell的实例表示当前受Windows所管理的窗口
		Shell shell = new Shell(display);
// 设置shell的大小（宽度和高度）
		shell.setSize(500, 500);
// 设置shell的窗口名
		shell.setText("shell demo");
// 打开shell窗口
		shell.open();
// 控制窗口不关闭，如果没有下面的代码，窗口会立即自动关闭
		while (!shell.isDisposed()) {
// 监听用户所引发的事件
			if (!display.readAndDispatch()) {
// 让窗口处于睡眠状态
				display.sleep();
			}
		}
// 当用户关闭窗口时，释放display占用的内存资源
		display.dispose();
	}

	/*
	 * 通过display和样式值来创建shell Shell(Display display[,int style])
	 */
	public static void createShell2() {
// 新建一个Display对象
		Display display = new Display();
// 根据已创建的Display对象和样式值新建一个Shell对象
// 可以通过|来组全不同的样式值来达到特定的效果
		Shell shell = new Shell(display, SWT.RESIZE | SWT.CLOSE | SWT.BORDER_SOLID);
// 设置shell的大小（宽度和高度）
		shell.setSize(500, 500);
// 设置shell的窗口名
		shell.setText("shell demo");
// 打开shell窗口
		shell.open();
// 控制窗口不关闭，如果没有下面的代码，窗口会立即自动关闭
		while (!shell.isDisposed()) {
// 监听用户所引发的事件
			if (!display.readAndDispatch()) {
// 让窗口处于睡眠状态
				display.sleep();
			}
		}
// 当用户关闭窗口时，释放display占用的内存资源
		display.dispose();
	}

	/*
	 * 在父Shell上创建子Shell Shell(Shell parent[,int tyle])
	 */
	public static void createChildShell() {
		Display display = new Display();
// 创建父Shell
		Shell parent = new Shell(display);
		parent.setSize(500, 500);
		parent.setText("parent");
		parent.open();
// 在父Shell的基础之上创建几个子Shell
		Shell cs1 = new Shell(parent);
		cs1.setSize(250, 250);
		cs1.setText("child1");
		cs1.open();

		Shell cs2 = new Shell(parent);
		cs2.setSize(250, 250);
		cs2.setText("child2");
		cs2.open();

		Shell cs3 = new Shell(parent);
		cs3.setSize(250, 250);
		cs3.setText("child3");
		cs3.open();

		while (!parent.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	/*
	 * 创建模态窗口的对话框
	 */
	public static void createDialog() {
		Display display = new Display();
		Shell parent = new Shell(display);
		parent.setSize(500, 500);
		parent.setText("parent");
//		parent.setImage(new Image(display, "images/Info.png"));
		parent.open();
// 通过SWT.DIALOG_TRIM|SWT.APPLICATION_MODAL样式值来创建dialog
		Shell dialog = new Shell(parent, SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);
		dialog.setSize(200, 200);
		dialog.setText("dialog");
//		dialog.setImage(new Image(display, "images/Alert.png"));
		dialog.open();

		while (!parent.isDisposed()) {
			if (display.readAndDispatch()) {
				display.sleep();
			}
		}
		display.dispose();
	}

	public static void main(String[] args) {
//		ShellTest.createShell1();
//ShellTest.createShell2();
//		ShellTest.createChildShell();
		ShellTest.createDialog();
	}
}

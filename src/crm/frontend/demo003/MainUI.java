package crm.frontend.demo003;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Layout;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

public class MainUI {
	static Table table = null;

	public static void main(String args[]) {
		final Display display = new Display();
		final Shell shell = new Shell(display);
		// 创建窗体
		shell.setLayout(new FillLayout());
		shell.setText("学生成绩管理系统");
		shell.setBounds(0, 0, 600, 600);
		shell.setVisible(true);
		// 创建表单
		table = new Table(shell, SWT.MULTI | SWT.FULL_SELECTION);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		// 创建列
		TableColumn column1 = new TableColumn(table, SWT.NONE);
		column1.setText("学号");
		column1.setWidth(100);
		TableColumn column2 = new TableColumn(table, SWT.NONE);
		column2.setText("姓名");
		column2.setWidth(100);
		TableColumn column3 = new TableColumn(table, SWT.NONE);
		column3.setText("成绩");
		column3.setWidth(100);
		TableColumn column4 = new TableColumn(table, SWT.NONE);
		column4.setText("班级");
		column4.setWidth(100);
		// 创建按钮容器
		Composite post = new Composite(shell, SWT.NONE);
		Button button1 = new Button(post, SWT.NONE);
		// 创建按钮
		button1.setText("添加");
		button1.setBounds(30, 30, 100, 50);
		Button button2 = new Button(post, SWT.NONE);
		button1.setBackground(new Color(display, SWT.COLOR_DARK_RED, 200, 20));
		button2.setText("删除");
		button2.setBounds(200, 30, 100, 50);
		button2.setFont(new Font(display, "宋体", 20, SWT.NONE));
		Button button3 = new Button(post, SWT.NONE);
		button3.setText("修改");
		button3.setBounds(30, 150, 100, 50);
		Button button4 = new Button(post, SWT.NONE);
		button3.setEnabled(true);
		button4.setText("查询");
		button4.setBounds(200, 150, 100, 50);
		// table初始化
		new TableItem(table, SWT.LEFT).setText(new String[] { "10", "张三", "60", "08楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "11", "李四", "90", "09电本" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "12", "王倩", "70", "08计本" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "13", "李明", "80", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "14", "刘德华", "50", "08机电" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "15", "范伟", "40", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "16", "朱元璋", "70", "08经贸" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "17", "周星驰", "65", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "18", "李连杰", "55", "08楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "19", "赵薇", "78", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "20", "林心如", "70", "08机械" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "21", "周润发", "88", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "22", "成龙", "73", "08汉语言" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "23", "赵本山", "80", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "24", "郭德纲", "56", "08小品" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "25", "周迅", "35", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "26", "王络丹", "49", "08土木" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "27", "刘亦菲", "60", "09楼宇" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "28", "张静初", "55", "08建工" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "29", "文章", "78", "09通信" });
		new TableItem(table, SWT.LEFT).setText(new String[] { "30", "王力宏", "80", "09楼宇" });
		// 为添加按钮添加事件处理
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = table.getItems();
				for (int i = 0; i < item.length; i++) {
					item[i].setBackground(new Color(display, 255, 255, 255));
				}
				System.out.println("test");
				AddStudentUI.addStuShow(display, table);
			}
		});
		// 为删除按钮添加事件处理
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = table.getItems();
				for (int i = 0; i < item.length; i++) {
					item[i].setBackground(new Color(display, 255, 255, 255));
				}
				if (table.getSelectionIndex() == -1) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请选择要删除的内容");
					box.open();
				} else {
					int[] selInices = table.getSelectionIndices();// 将选中的序号放在数组中
					table.remove(selInices);
				}

			}
		});
		// 为修改按钮添加事件处理
		button3.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = table.getItems();
				for (int i = 0; i < item.length; i++) {
					item[i].setBackground(new Color(display, 255, 255, 255));
				}
				if (table.getSelectionIndex() == -1) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请选择要修改的内容");
					box.open();
				} else {
					ModifyStudentUI.modifyStuShow(display, table);
				}
			}
		});
		// 为查找按钮添加事件处理
		button4.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = table.getItems();
				for (int i = 0; i < item.length; i++) {
					item[i].setBackground(new Color(display, 255, 255, 255));
				}
				FindStuUI.findStuShow(display, table);
			}
		});

		shell.pack();
		shell.open();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

}

package crm.frontend.demo003;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

class AddStudentUI {
	Display display = null;
	Shell shell = new Shell(display);

	public AddStudentUI(Display dy) {
		display = dy;
	}

	public static void addStuShow(Display dy, Table table) {
		AddStudentUI ast = new AddStudentUI(dy);
		ast.run(table);
	}

	private void run(final Table table) {
		shell.setBounds(500, 200, 250, 400);
		shell.setText("添加学生信息");
		// 添加标签
		Label id = new Label(shell, SWT.NONE);
		id.setText("学号");
		id.setBounds(40, 50, 60, 40);
		Label name = new Label(shell, SWT.NONE);
		name.setText("姓名");
		name.setBounds(40, 100, 60, 40);
		Label score = new Label(shell, SWT.NONE);
		score.setText("成绩");
		score.setBounds(40, 150, 60, 40);
		Label cls = new Label(shell, SWT.NONE);
		cls.setText("班级");
		cls.setBounds(40, 200, 60, 40);
		// 添加文本框
		final Text text1 = new Text(shell, SWT.NONE);
		text1.setBounds(100, 45, 100, 25);
		text1.setTextLimit(2);// 学号必须是两位
		final Text text2 = new Text(shell, SWT.NONE);
		text2.setBounds(100, 95, 100, 25);
		text2.setTextLimit(6);// 姓名最多为三位
		final Text text3 = new Text(shell, SWT.NONE);
		text3.setBounds(100, 145, 100, 25);
		final Text text4 = new Text(shell, SWT.NONE);
		text4.setBounds(100, 195, 100, 25);
		// 添加按钮
		Button button1 = new Button(shell, SWT.NONE);
		button1.setText("确定");
		button1.setBounds(55, 250, 60, 40);
		Button button2 = new Button(shell, SWT.NONE);
		button2.setText("取消");
		button2.setBounds(135, 250, 60, 40);
		// 为确定按钮添加事件处理，添加信息
		button1.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				try {
					Student stu = new Student();
					stu.setId(Integer.parseInt(text1.getText()));
					stu.setName(text2.getText());
					stu.setScore(Float.valueOf(text3.getText()).floatValue());
					stu.setCls(text4.getText());
					new TableItem(table, 0).setText(new String[] { Integer.toString(stu.getId()), stu.getName(),
							Float.toString(stu.getScore()), stu.getCls() });
					shell.close();
				} catch (NumberFormatException e1) {
					MessageBox box = new MessageBox(shell, 0);
					box.setMessage("输入信息无效");
					box.open();
				}

			}
		});
		// 为取消按钮添加事件处理
		button2.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {
				shell.close();
			}
		});
		shell.open();
	}
}

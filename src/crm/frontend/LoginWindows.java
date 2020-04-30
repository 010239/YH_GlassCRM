package crm.frontend;

import java.util.List;

import javax.persistence.EntityManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;
import org.h2.util.geometry.EWKBUtils.EWKBTarget;

import crm.backend.dao.DAOFactory;
import crm.backend.entity.Account;

public class LoginWindows {
	private static Text loginName;
	private static Text loginPasswod;
	
	
	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Display display = Display.getDefault();
		Shell shell = new Shell(SWT.BORDER);
//		shell.setBackground(SWTResourceManager.getColor(30, 144, 255));
		shell.setSize(610, 385);

		Label tipMessage = new Label(shell, SWT.NONE);
		tipMessage.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		tipMessage.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
//		tipMessage.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		tipMessage.setBounds(126, 104, 322, 34);

		Label loginNameLabel = new Label(shell, SWT.NONE);
		loginNameLabel.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
//		loginNameLabel.setFont(SWTResourceManager.getFont("Wingdings 3", 18, SWT.NORMAL));
		loginNameLabel.setBounds(126, 193, 70, 40);
		loginNameLabel.setText("\u5BC6 \u7801");

		Label loginNameLabel_1 = new Label(shell, SWT.NONE);
		loginNameLabel_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		loginNameLabel_1.setText("\u8D26 \u53F7");
//		loginNameLabel_1.setFont(SWTResourceManager.getFont("Wingdings 3", 18, SWT.NORMAL));
		loginNameLabel_1.setBounds(126, 143, 70, 40);

		loginName = new Text(shell, SWT.BORDER);
		loginName.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 18, SWT.NORMAL));
//		loginName.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 18, SWT.NORMAL));
		loginName.setBounds(194, 143, 254, 40);

		loginPasswod = new Text(shell, SWT.PASSWORD);
		loginPasswod.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 18, SWT.NORMAL));
		// loginPasswod.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 18,
		// SWT.NORMAL));
		loginPasswod.setBounds(194, 193, 254, 40);

		EntityManager em = DAOFactory.getEntityManager();
		final List<Account> accountList = DAOFactory.getAccountDao(em).findAll(); 
		final Account account =  new Account();
		if(accountList.size() == 0) {			
			account.setName("admin");
			account.setPassword("123456");
			DAOFactory.getAccountDao(em).save(account);
		}
		
		Button Ok_Button = new Button(shell, SWT.NONE);
		Ok_Button.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		Ok_Button.addSelectionListener(new SelectionAdapter() {
									
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				String name = loginName.getText();
				String password = loginPasswod.getText();
				if (null == name || "".equals(name)) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请输入账户");
					box.open();
					tipMessage.setText("请输入账户！！！");
				} else if (null == password || "".equals(password)){
					MessageBox box = new MessageBox(shell);
					box.setMessage("请输入密码");
					box.open();
					tipMessage.setText("请输入密码！！！");
				}
				if(accountList.size() == 0) {
					if( name.equals("admin") && password.equals("123456") )  {
						shell.close();
						WorkWindow window = new WorkWindow();
						window.open();
					}else {
						tipMessage.setText("亲，账号密码不正确，请重新登录！！！");
					}
				}else {
					for(int i = 0; i < accountList.size(); i++) {
						Account account = accountList.get(i);
						if( name.equals(account.getName()) && password.equals(account.getPassword()) )  {
							shell.close();
							WorkWindow window = new WorkWindow();
							window.open();
						}else {
							tipMessage.setText("亲，账号密码不正确，请重新登录！！！");
						}
					} 
				}
				
	
			}
		});

		Ok_Button.setText("\u786E \u5B9A");
		// Ok_Button.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 18,
		// SWT.NORMAL));
		Ok_Button.setBounds(194, 255, 108, 45);

		Button CancelButton = new Button(shell, SWT.NONE);
		CancelButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
//		CancelButton.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 18, SWT.NORMAL));
		CancelButton.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				shell.close();
				DAOFactory.close();
			}
		});
		CancelButton.setBounds(340, 255, 108, 45);
		CancelButton.setText("\u53D6 \u6D88");

		Label label = new Label(shell, SWT.CENTER);
		label.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 20, SWT.BOLD));
//		label.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 30, SWT.NORMAL));
		label.setBounds(10, 42, 584, 43);
		label.setText("\u9752\u5C11\u5E74\u89C6\u529B\u5065\u5EB7\u6863\u6848\u7BA1\u7406\u4FE1\u606F\u7CFB\u7EDF");

		Label label_1 = new Label(shell, SWT.CENTER);
		label_1.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
//		label_1.setFont(SWTResourceManager.getFont(".AppleSystemUIFont", 14, SWT.NORMAL));
		label_1.setBounds(10, 321, 584, 27);
		label_1.setText("\u5E73\u9065\u82F1\u6D77\u773C\u955C\u89C6\u5149\u4E2D\u5FC3");

		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);

		
		
		
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {

			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}

	}

}

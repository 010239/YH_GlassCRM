package crm.frontend;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import java.lang.reflect.InvocationTargetException;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import crm.backend.dao.CustomerDaoImpl;
import crm.backend.dao.DAOFactory;
import crm.backend.entity.Customer;

import org.eclipse.swt.layout.RowLayout;

public class AddCustomerWindow {

	protected Shell shell;
	private Text mobilephoneText;
	private Text membershipCardText;
	private Text addressText;
	private Text nameText;
	private Combo parentsWearGlassesText;
	private Combo professionText;
	private Combo healthText;
	private Combo individualEyeHistoryText;
	private Button sexbtn_1;
	private Button sexbtn_2;
	private Button hereditaryOphthalmopathyBtn_1;
	private Button hereditaryOphthalmopathyBtn_2;

	private Long customerInfoId;
	private Customer selectedCustomer;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddCustomerWindow window = new AddCustomerWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents(null);
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

	public void open(Table table) {
		Display display = Display.getDefault();
		createContents(table);
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		shell.open();
		shell.layout();
		
	}

	public void setEditValue(String customerInfoId) {
		shell.setText("编辑客户基本信息");		
		EntityManager em = DAOFactory.getEntityManager();
		selectedCustomer = DAOFactory.getCustomerDao(em).find(Customer.class, Long.parseLong(customerInfoId));
		
		nameText.setText(selectedCustomer.getName());
		mobilephoneText.setText(selectedCustomer.getMobilephone());
		membershipCardText.setText(selectedCustomer.getMembershipCard());
		;
		addressText.setText(selectedCustomer.getAddress());
		if ("男".equals(selectedCustomer.getSex())) {
			sexbtn_1.setSelection(true);
			sexbtn_2.setSelection(false);
		} else if ("女".equals(selectedCustomer.getSex())){
			sexbtn_1.setSelection(false);
			sexbtn_2.setSelection(true);
		}
		if (selectedCustomer.getHereditaryOphthalmopathy() != null) {
			if ("无".equals(selectedCustomer.getHereditaryOphthalmopathy())) {
				hereditaryOphthalmopathyBtn_1.setSelection(true);
				hereditaryOphthalmopathyBtn_2.setSelection(false);
			} else if ("有".equals(selectedCustomer.getHereditaryOphthalmopathy())) {
				hereditaryOphthalmopathyBtn_1.setSelection(false);
				hereditaryOphthalmopathyBtn_2.setSelection(true);
			}
		}
		
		if(selectedCustomer.getParentsWearGlasses().equals("近视")) {
			parentsWearGlassesText.select(01);
		}else if(selectedCustomer.getParentsWearGlasses().equals("远视")) {
			parentsWearGlassesText.select(12);
		}else if(selectedCustomer.getParentsWearGlasses().equals("散光")) {
			parentsWearGlassesText.select(2);
		}
		
		if(selectedCustomer.getHealth().equals("良好")) {
			healthText.select(0);
		}else if(selectedCustomer.getHealth().equals("心脏病")) {
			healthText.select(1);
		}else if(selectedCustomer.getHealth().equals("高血压")) {
			healthText.select(2);
		}else if(selectedCustomer.getHealth().equals("糖尿病")) {
			healthText.select(3);
		}
		
		if(selectedCustomer.getProfession().equals("电脑和手机")) {
			professionText.select(0);
		}else if(selectedCustomer.getProfession().equals("司机")) {
			professionText.select(1);
		}else if(selectedCustomer.getProfession().equals("学生")) {
			professionText.select(2);
		}else if(selectedCustomer.getProfession().equals("其他")) {
			professionText.select(3);
		}

		if(selectedCustomer.getIndividualEyeHistory().equals("角膜炎")) {
			individualEyeHistoryText.select(0);
		}else if(selectedCustomer.getIndividualEyeHistory().equals("沙眼")) {
			individualEyeHistoryText.select(1);
		}else if(selectedCustomer.getIndividualEyeHistory().equals("外伤")) {
			individualEyeHistoryText.select(2);
		}else if(selectedCustomer.getIndividualEyeHistory().equals("白内障")) {
			individualEyeHistoryText.select(3);
		}else if(selectedCustomer.getIndividualEyeHistory().equals("青光眼")) {
			individualEyeHistoryText.select(4);
		}else if(selectedCustomer.getIndividualEyeHistory().equals("手术史")) {
			individualEyeHistoryText.select(5);
		}

	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Table table) {
		shell = new Shell(SWT.DIALOG_TRIM | SWT.SYSTEM_MODAL);
		shell.setSize(760, 522);
		shell.setText("\u65B0\u589E\u5BA2\u6237\u57FA\u672C\u4FE1\u606F");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

//		Button btnNewButton = new Button(shell, SWT.NONE);
//		btnNewButton.setBounds(48, 97, 98, 30);
//		btnNewButton.setText("New Button");

		Composite composite = new Composite(shell, SWT.NONE);
//		composite.setEnabled(false);
		composite.setLayout(new GridLayout(6, false));
		new Label(composite, SWT.NONE);

		Label lblNewLabel_7 = new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_2 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		GridData gd_label_2 = new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1);
		gd_label_2.widthHint = 235;
		label_2.setLayoutData(gd_label_2);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel.setText("\u59D3\u540D");

		nameText = new Text(composite, SWT.BORDER);
		nameText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("\u6027\u522B");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		Group group = new Group(composite, SWT.SHADOW_ETCHED_OUT);
		GridData gd_group = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_group.widthHint = 194;
		group.setLayoutData(gd_group);
		
				sexbtn_2 = new Button(group, SWT.RADIO);
				sexbtn_2.setBounds(126, 10, 39, 20);
				sexbtn_2.setText("\u5973");
				//Group group1 = new Group(shell, SWT.SHADOW_ETCHED_OUT);
				sexbtn_1 = new Button(group, SWT.RADIO);
				sexbtn_1.setBounds(31, 10, 39, 20);
				sexbtn_1.setSelection(true);
				sexbtn_1.addSelectionListener(new SelectionAdapter() {
					@Override
					public void widgetSelected(SelectionEvent e) {
					}
				});
				sexbtn_1.setText("\u7537");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("\u8054\u7CFB\u65B9\u5F0F");

		mobilephoneText = new Text(composite, SWT.BORDER);
		mobilephoneText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label.setText("\u4F1A\u5458\u5361\u53F7");

		membershipCardText = new Text(composite, SWT.BORDER);
		membershipCardText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_1.setText("\u5BB6\u5EAD\u4F4F\u5740");

		addressText = new Text(composite, SWT.BORDER);
		addressText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_5 = new Label(composite, SWT.NONE);
		lblNewLabel_5.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_5.setText("\u5DE5\u4F5C");

		professionText = new Combo(composite, SWT.NONE);
		professionText.setItems(
				new String[] { "\u7535\u8111\u548C\u624B\u673A", "\u53F8\u673A", "\u5B66\u751F", "\u5176\u4ED6" });
		professionText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_6 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_6.setText("\u5BB6\u65CF\u53F2");
		GridData gd_label_6 = new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1);
		gd_label_6.widthHint = 406;
		label_6.setLayoutData(gd_label_6);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_3 = new Label(composite, SWT.NONE);
		label_3.setText("\u662F\u5426\u6709\u5BB6\u65CF\u9057\u4F20\u6027\u773C\u75C5");

		hereditaryOphthalmopathyBtn_1 = new Button(composite, SWT.RADIO);
		hereditaryOphthalmopathyBtn_1.setSelection(true);
		hereditaryOphthalmopathyBtn_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		hereditaryOphthalmopathyBtn_1.setText("\u65E0");

		hereditaryOphthalmopathyBtn_2 = new Button(composite, SWT.RADIO);
		hereditaryOphthalmopathyBtn_2.setText("\u6709");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("\u7236\u6BCD\u662F\u5426\u6234\u955C");

		parentsWearGlassesText = new Combo(composite, SWT.NONE);
		parentsWearGlassesText.setItems(new String[] { "\u8FD1\u89C6", "\u8FDC\u89C6", "\u6563\u5149" });
		GridData gd_parentsWearGlassesText = new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1);
		gd_parentsWearGlassesText.heightHint = 12;
		parentsWearGlassesText.setLayoutData(gd_parentsWearGlassesText);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_7 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_7.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("\u4E2A\u4EBA\u5168\u8EAB\u5065\u5EB7\u60C5\u51B5");

		healthText = new Combo(composite, SWT.NONE);
		healthText.setItems(
				new String[] { "\u826F\u597D", "\u5FC3\u810F\u75C5", "\u9AD8\u8840\u538B", "\u7CD6\u5C3F\u75C5" });
		healthText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("\u4E2A\u4EBA\u773C\u75C5\u53F2");

		individualEyeHistoryText = new Combo(composite, SWT.NONE);
		individualEyeHistoryText.setItems(new String[] { "\u89D2\u819C\u708E", "\u6C99\u773C", "\u5916\u4F24",
				"\u767D\u5185\u969C", "\u9752\u5149\u773C", "\u624B\u672F\u53F2" });
		individualEyeHistoryText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 3, 1));
		new Label(composite, SWT.NONE);

		Label label_5 = new Label(composite, SWT.NONE);

		Label label_8 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Composite composite_1 = new Composite(composite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		GridData gd_composite_1 = new GridData(SWT.FILL, SWT.CENTER, false, false, 3, 1);
		gd_composite_1.widthHint = 517;
		composite_1.setLayoutData(gd_composite_1);

		// 保存按钮
		Button btn_ok = new Button(composite_1, SWT.NONE);
		btn_ok.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Customer customer = new Customer();
				TableItem tableitem = null;
				if ("新增客户基本信息".equals(shell.getText())) {

					tableitem = new TableItem(table, SWT.NONE);
				} else if ("编辑客户基本信息".equals(shell.getText())) {
					
					tableitem = table.getItem(table.getSelectionIndex());
					try {
						BeanUtils.copyProperties(customer, selectedCustomer);
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				customer.setName(nameText.getText());
				customer.setSex(sexbtn_1.getSelection() == false ? sexbtn_2.getText() : sexbtn_1.getText());
				customer.setAddress(addressText.getText());
				customer.setHealth(healthText.getText());
				customer.setHereditaryOphthalmopathy(
						hereditaryOphthalmopathyBtn_1.getSelection() == false ? hereditaryOphthalmopathyBtn_2.getText()
								: hereditaryOphthalmopathyBtn_1.getText());
				customer.setIndividualEyeHistory(individualEyeHistoryText.getText());
				customer.setMembershipCard(membershipCardText.getText());
				customer.setMobilephone(mobilephoneText.getText());
				customer.setParentsWearGlasses(parentsWearGlassesText.getText());
				customer.setProfession(professionText.getText());
				if ("新增客户基本信息".equals(shell.getText())) {
					EntityManager em = DAOFactory.getEntityManager();
					DAOFactory.getCustomerDao(em).save(customer);
					
				} else if ("编辑客户基本信息".equals(shell.getText())) {
					EntityManager em = DAOFactory.getEntityManager();
					DAOFactory.getCustomerDao(em).update(customer);
				}

//						if(customer.getCustomerId() != null) {

				tableitem.setText(new String[] { customer.getCustomerId().toString(), customer.getName(),
						customer.getSex(), customer.getMobilephone(), customer.getMembershipCard(),
						customer.getAddress(), customer.getHereditaryOphthalmopathy(), customer.getParentsWearGlasses(),
						customer.getHealth(), customer.getIndividualEyeHistory(), customer.getProfession() });
//						}
				
				shell.setVisible(false);
			}
		});
		btn_ok.setText("\u4FDD \u5B58");

		// 取消按钮
		Button btn_cancel = new Button(composite_1, SWT.NONE);
		btn_cancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		btn_cancel.setText("\u53D6 \u6D88");
		new Label(composite, SWT.NONE);

	}
}

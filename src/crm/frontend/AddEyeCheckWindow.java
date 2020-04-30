package crm.frontend;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;

import java.lang.reflect.InvocationTargetException;
import java.util.*;

import javax.persistence.EntityManager;

import org.apache.commons.beanutils.BeanUtils;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.wb.swt.SWTResourceManager;

import crm.backend.dao.DAOFactory;
import crm.backend.entity.Customer;
import crm.backend.entity.CustomerCheckInfo;
import crm.backend.entity.EyeCheckItem;

import org.eclipse.swt.widgets.DateTime;

public class AddEyeCheckWindow {

	protected Shell shell;
	private Text ageText;
	private Text hightText;
	private Text wightText;
	private Text nameText;
	private Text nakedVision;
	private Text nakedVision_2;
	private Text oldGlassDegree;
	private Text oldGlassDegree_2;
	private Text oldGlassInterpupillaryDistance;
	private Text oldGlassInterpupillaryDistance_2;
	private Text oldGlassVision;
	private Text oldGlassVision_2;
	private Text prescription;
	private Text prescription_2;
	private Text prescriptiveInterpupillaryDistance;
	private Text prescriptiveInterpupillaryDistance_2;
	private Text correctedVision;
	private Text correctedVision_2;
	private Text eyeShaftLength;
	private Text eyeShaftLength_2;
	private Text cornealCurvature;
	private Text cornealCurvature_2;
	private Text positionOfEye;
	private Text stressOfEye;
	private Text positionOfEye_2;
	private Text stressOfEye_2;
	
	private String customerId;
	private String customerCheckInfoid;
	private Customer selectedCustomer;
	
	Label customerIdLable ;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			AddEyeCheckWindow window = new AddEyeCheckWindow();
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

	/**
	 * Create contents of the window.
	 */
	protected void createContents(Table table) {
		shell = new Shell(SWT.DIALOG_TRIM | SWT.SYSTEM_MODAL);
		shell.setSize(760, 768);
		shell.setText("\u65B0\u589E\u5BA2\u6237\u89C6\u529B\u5065\u5EB7\u4FE1\u606F");
		shell.setLayout(new FillLayout(SWT.HORIZONTAL));

//		Button btnNewButton = new Button(shell, SWT.NONE);
//		btnNewButton.setBounds(48, 97, 98, 30);
//		btnNewButton.setText("New Button");

		Composite composite = new Composite(shell, SWT.NONE);
//		composite.setEnabled(false);
		composite.setLayout(new GridLayout(6, false));
		new Label(composite, SWT.NONE);

		Label lblNewLabel_7 = new Label(composite, SWT.NONE);
		
		customerIdLable = new Label(composite, SWT.NONE);
		customerIdLable.setEnabled(false);
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
		lblNewLabel.setText("\u68C0\u67E5\u65F6\u95F4");
		
				DateTime dateTime = new DateTime(composite, SWT.BORDER | SWT.LONG | SWT.DROP_DOWN);
				dateTime.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_1.setText("\u59D3      \u540D");
		
				nameText = new Text(composite, SWT.BORDER);
				GridData gd_nameText = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
				gd_nameText.widthHint = 120;
				nameText.setLayoutData(gd_nameText);
		new Label(composite, SWT.NONE);
		
		Button btnNewButton_2 = new Button(composite, SWT.NONE);
		btnNewButton_2.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
			}
		});
		btnNewButton_2.setText("选 择");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_2 = new Label(composite, SWT.NONE);
		lblNewLabel_2.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_2.setText("\u5E74      \u9F84");

		ageText = new Text(composite, SWT.BORDER);
		ageText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_6 = new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblkm = new Label(composite, SWT.NONE);
		lblkm.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblkm.setText("\u8EAB\u9AD8(km)");

		hightText = new Text(composite, SWT.BORDER);
		hightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblkg = new Label(composite, SWT.NONE);
		lblkg.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblkg.setText("\u4F53\u91CD(kg)");

		wightText = new Text(composite, SWT.BORDER);
		wightText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
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
		label_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_3.setText("\u773C      \u522B");

		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		label.setText("\u53F3\u773C");

		Label label_9 = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_RED));
		label_9.setAlignment(SWT.CENTER);

		Label label_1 = new Label(composite, SWT.NONE);
		label_1.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		label_1.setText("\u5DE6\u773C");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_4 = new Label(composite, SWT.NONE);
		label_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_4.setText("\u88F8\u773C\u89C6\u529B");

		nakedVision = new Text(composite, SWT.BORDER);
		nakedVision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		nakedVision_2 = new Text(composite, SWT.BORDER);
		GridData gd_nakedVision_2 = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_nakedVision_2.widthHint = 186;
		nakedVision_2.setLayoutData(gd_nakedVision_2);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_10 = new Label(composite, SWT.NONE);
		label_10.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_10.setText("\u65E7\u955C\u5EA6\u6570");

		oldGlassDegree = new Text(composite, SWT.BORDER);
		oldGlassDegree.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		oldGlassDegree_2 = new Text(composite, SWT.BORDER);
		oldGlassDegree_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_11 = new Label(composite, SWT.NONE);
		label_11.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_11.setText("\u65E7\u955C\u77B3\u8DDD");

		oldGlassInterpupillaryDistance = new Text(composite, SWT.BORDER);
		oldGlassInterpupillaryDistance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		oldGlassInterpupillaryDistance_2 = new Text(composite, SWT.BORDER);
		oldGlassInterpupillaryDistance_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_12 = new Label(composite, SWT.NONE);
		label_12.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_12.setText("\u65E7\u955C\u89C6\u529B");

		oldGlassVision = new Text(composite, SWT.BORDER);
		oldGlassVision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		oldGlassVision_2 = new Text(composite, SWT.BORDER);
		oldGlassVision_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_13 = new Label(composite, SWT.NONE);
		label_13.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_13.setText("\u6700\u7EC8\u5904\u65B9");

		prescription = new Text(composite, SWT.BORDER);
		prescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		prescription_2 = new Text(composite, SWT.BORDER);
		prescription_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_14 = new Label(composite, SWT.NONE);
		label_14.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_14.setText("\u5904\u65B9\u77B3\u8DDD");

		prescriptiveInterpupillaryDistance = new Text(composite, SWT.BORDER);
		prescriptiveInterpupillaryDistance.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		prescriptiveInterpupillaryDistance_2 = new Text(composite, SWT.BORDER);
		prescriptiveInterpupillaryDistance_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_3 = new Label(composite, SWT.NONE);
		lblNewLabel_3.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_3.setText("\u77EB\u6B63\u89C6\u529B");

		correctedVision = new Text(composite, SWT.BORDER);
		correctedVision.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		correctedVision_2 = new Text(composite, SWT.BORDER);
		correctedVision_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label lblNewLabel_4 = new Label(composite, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblNewLabel_4.setText("\u773C\u7403\u8F74\u957F");

		eyeShaftLength = new Text(composite, SWT.BORDER);
		eyeShaftLength.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		eyeShaftLength_2 = new Text(composite, SWT.BORDER);
		eyeShaftLength_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_7 = new Label(composite, SWT.NONE);
		label_7.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_7.setText("\u89D2\u819C\u66F2\u7387");

		cornealCurvature = new Text(composite, SWT.BORDER);
		cornealCurvature.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		cornealCurvature_2 = new Text(composite, SWT.BORDER);
		cornealCurvature_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_15 = new Label(composite, SWT.NONE);
		label_15.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_15.setText("\u773C      \u4F4D");

		positionOfEye = new Text(composite, SWT.BORDER);
		positionOfEye.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		positionOfEye_2 = new Text(composite, SWT.BORDER);
		positionOfEye_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		Label label_16 = new Label(composite, SWT.NONE);
		label_16.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		label_16.setText("\u773C      \u538B");

		stressOfEye = new Text(composite, SWT.BORDER);
		stressOfEye.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);
		
		stressOfEye_2 = new Text(composite, SWT.BORDER);
		stressOfEye_2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		new Label(composite, SWT.NONE);

		Label label_5 = new Label(composite, SWT.NONE);

		Label label_8 = new Label(composite, SWT.SEPARATOR | SWT.HORIZONTAL);
		label_8.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);
		
		// 保存按钮
		Button btnNewButton = new Button(composite, SWT.NONE);
		btnNewButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				Customer customer = new Customer();
				TableItem tableitem = null;
				TableItem tableitem_2 = null;
				if ("新增客户视力健康信息".equals(shell.getText())) {

					tableitem = new TableItem(table, SWT.NONE);
					tableitem_2 = new TableItem(table, SWT.NONE);
				} else if ("编辑客户视力健康信息".equals(shell.getText())) {
					
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
								
				CustomerCheckInfo customerCheckInfo = new CustomerCheckInfo();
				
				customerCheckInfo.setCheckDate(new Date(dateTime.getYear(), dateTime.getMonth(), dateTime.getDay(), dateTime.getHours(), dateTime.getMinutes(), dateTime.getSeconds()));
				customerCheckInfo.setAge(ageText.getText());
				customerCheckInfo.setHeight(hightText.getText());
				customerCheckInfo.setWight(wightText.getText()); 
				customerCheckInfo.setCustomer(selectedCustomer);
				
				EyeCheckItem eyeCheckItem_r = new EyeCheckItem();
				eyeCheckItem_r.setCornealCurvature(cornealCurvature.getText());
				eyeCheckItem_r.setCorrectedVision(correctedVision.getText());
				eyeCheckItem_r.setEyeShaftLength(eyeShaftLength.getText());
				eyeCheckItem_r.setEyeType("右眼");
				eyeCheckItem_r.setNakedVision(nakedVision.getText());
				eyeCheckItem_r.setOldGlassDegree(oldGlassDegree.getText());
				eyeCheckItem_r.setOldGlassInterpupillaryDistance(oldGlassInterpupillaryDistance.getText());
				eyeCheckItem_r.setOldGlassVision(oldGlassVision.getText());
				eyeCheckItem_r.setPositionOfEye(positionOfEye.getText());
				eyeCheckItem_r.setPrescription(prescription.getText());
				eyeCheckItem_r.setPrescriptiveInterpupillaryDistance(prescriptiveInterpupillaryDistance.getText());
				eyeCheckItem_r.setStressOfEye(stressOfEye.getText());
				eyeCheckItem_r.setCustomerCheckInfo(customerCheckInfo);
				
				EyeCheckItem eyeCheckItem_l = new EyeCheckItem();
				eyeCheckItem_l.setCornealCurvature(cornealCurvature_2.getText());
				eyeCheckItem_l.setCorrectedVision(correctedVision_2.getText());
				eyeCheckItem_l.setEyeShaftLength(eyeShaftLength_2.getText());
				eyeCheckItem_l.setEyeType("左眼");
				eyeCheckItem_l.setNakedVision(nakedVision_2.getText());
				eyeCheckItem_l.setOldGlassDegree(oldGlassDegree_2.getText());
				eyeCheckItem_l.setOldGlassInterpupillaryDistance(oldGlassInterpupillaryDistance_2.getText());
				eyeCheckItem_l.setOldGlassVision(oldGlassVision_2.getText());
				eyeCheckItem_l.setPositionOfEye(positionOfEye_2.getText());
				eyeCheckItem_l.setPrescription(prescription_2.getText());
				eyeCheckItem_l.setPrescriptiveInterpupillaryDistance(prescriptiveInterpupillaryDistance_2.getText());
				eyeCheckItem_l.setStressOfEye(stressOfEye_2.getText());
				eyeCheckItem_l.setCustomerCheckInfo(customerCheckInfo);
				
				List<EyeCheckItem> eyeCheckItemList = new ArrayList<EyeCheckItem>();
				eyeCheckItemList.add(eyeCheckItem_r);
				eyeCheckItemList.add(eyeCheckItem_l);
				customerCheckInfo.setEyeCheckItemList(eyeCheckItemList);
				
				EntityManager em = DAOFactory.getEntityManager();
				selectedCustomer = DAOFactory.getCustomerDao(em).find(Customer.class, Long.parseLong(customerIdLable.getText()));				
				List<CustomerCheckInfo> customerCheckInfoList = selectedCustomer.getCustomerCheckInfoList();
				System.out.println("customerCheckInfoList是否为空" + customerCheckInfoList);
				if(customerCheckInfoList == null) {
					customerCheckInfoList = new ArrayList<CustomerCheckInfo>();
					selectedCustomer.setCustomerCheckInfoList(customerCheckInfoList);
				}
				customerCheckInfoList.add(customerCheckInfo);
				customerCheckInfo.setCustomer(selectedCustomer);
				
				if ("新增客户视力健康信息".equals(shell.getText())) {
					
					DAOFactory.getCustomerDao(em).update(selectedCustomer);
					
				} else if ("编辑客户视力健康信息".equals(shell.getText())) {
					
					DAOFactory.getCustomerDao(em).update(selectedCustomer);
				}

//						if(customer.getCustomerId() != null) {
				
				// 将新增结果添加到客户视力健康信息列表中
				tableitem.setText(new String[] { customerCheckInfo.getCheckDate().toLocaleString(), 
						customerCheckInfo.getAge(), customerCheckInfo.getHeight(), customerCheckInfo.getWight(),
						eyeCheckItem_r.getEyeType(), eyeCheckItem_r.getNakedVision(), eyeCheckItem_r.getOldGlassDegree(),
						eyeCheckItem_r.getOldGlassInterpupillaryDistance(), eyeCheckItem_r.getOldGlassVision(),
						eyeCheckItem_r.getPrescription(), eyeCheckItem_r.getPrescriptiveInterpupillaryDistance(),
						eyeCheckItem_r.getCorrectedVision(), eyeCheckItem_r.getEyeShaftLength(),
						eyeCheckItem_r.getCornealCurvature(), eyeCheckItem_r.getPositionOfEye(),
						eyeCheckItem_r.getStressOfEye() });
				tableitem_2.setText(new String[] { customerCheckInfo.getCheckDate().toLocaleString(), 
						customerCheckInfo.getAge(), customerCheckInfo.getHeight(), customerCheckInfo.getWight(),
						eyeCheckItem_l.getEyeType(), eyeCheckItem_l.getNakedVision(), eyeCheckItem_l.getOldGlassDegree(),
						eyeCheckItem_l.getOldGlassInterpupillaryDistance(), eyeCheckItem_l.getOldGlassVision(),
						eyeCheckItem_l.getPrescription(), eyeCheckItem_l.getPrescriptiveInterpupillaryDistance(),
						eyeCheckItem_l.getCorrectedVision(), eyeCheckItem_l.getEyeShaftLength(),
						eyeCheckItem_l.getCornealCurvature(), eyeCheckItem_l.getPositionOfEye(),
						eyeCheckItem_l.getStressOfEye() });
//						}
			
				
				shell.setVisible(false);
			}
		});
		btnNewButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnNewButton.setText("\u4FDD \u5B58");
		new Label(composite, SWT.NONE);
		
		// 取消按钮
		Button btnNewButton_1 = new Button(composite, SWT.NONE);
		btnNewButton_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				shell.setVisible(false);
			}
		});
		btnNewButton_1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		btnNewButton_1.setText("\u53D6 \u6D88");
		new Label(composite, SWT.NONE);

	}
	
	
	
	public void setEditValue(String customerInfoId, String customerCheckInfoId) {
		shell.setText("编辑客户视力健康信息");		
		EntityManager em = DAOFactory.getEntityManager();
		selectedCustomer = DAOFactory.getCustomerDao(em).find(Customer.class, Long.parseLong(customerInfoId));
//		selectedCustomer.getCustomerCheckInfoList()
//		ageText.setText(selectedCustomer);
		
				


	}

	
	
	public void setCustomer(String customerInfoId, String customerName, String customerCheckInfoId) {
		this.customerId = customerInfoId;
		this.customerCheckInfoid = customerCheckInfoId;
		customerIdLable.setText(customerInfoId);
		customerIdLable.setVisible(false);
		nameText.setText(customerName);
	}
}

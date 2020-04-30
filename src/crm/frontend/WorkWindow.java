package crm.frontend;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.CoolBar;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Text;
//import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.eclipse.swt.widgets.Group;
import org.eclipse.wb.swt.SWTResourceManager;

import com.ibm.icu.text.SimpleDateFormat;

import crm.backend.dao.CustomerDaoImpl;
import crm.backend.dao.DAOFactory;
import crm.backend.entity.Customer;
import crm.backend.entity.CustomerCheckInfo;
import crm.backend.entity.EyeCheckItem;
import swing2swt.layout.BorderLayout;
import org.eclipse.swt.widgets.CoolItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.custom.TableCursor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlListener;
import java.util.function.Consumer;

import javax.persistence.EntityManager;

import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseEvent;

public class WorkWindow {

	protected Shell shell;
	private Text searchText;
	private Table customerInfoTable;
	private Table customerEyeCheckTable;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			WorkWindow window = new WorkWindow();
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
		createContents();
				
		shell.setLocation(Display.getCurrent().getClientArea().width / 2 - shell.getShell().getSize().x / 2,
				Display.getCurrent().getClientArea().height / 2 - shell.getSize().y / 2);
		
		Label label = new Label(shell, SWT.NONE);
		label.setForeground(SWTResourceManager.getColor(SWT.COLOR_RED));
		FormData fd_label = new FormData();
		fd_label.left = new FormAttachment(100, -503);
		fd_label.top = new FormAttachment(sashForm, 6);
		fd_label.right = new FormAttachment(100, -10);
		label.setLayoutData(fd_label);
		label.setText("重要提示：默认显示50条客户资料，请使用搜索功能精确查找客户资料！！！");
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
		
		DAOFactory.close();
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(1551, 877);
		shell.setText("青少年视力健康档案管理信息系统");
		shell.setLayout(new FormLayout());

		sashForm = new SashForm(shell, SWT.BORDER);
		sashForm.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		sashForm.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		FormData fd_sashForm = new FormData();
		fd_sashForm.top = new FormAttachment(0, 10);
		fd_sashForm.bottom = new FormAttachment(100, -36);
		fd_sashForm.right = new FormAttachment(100);
		fd_sashForm.left = new FormAttachment(0, 10);
		sashForm.setLayoutData(fd_sashForm);

		Composite child1 = new Composite(sashForm, SWT.NONE);
		child1.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(child1, SWT.NONE);

		Label lblNewLabel_1 = new Label(child1, SWT.NONE);

		Label lblNewLabel_2 = new Label(child1, SWT.NONE);

		Label lblNewLabel_4 = new Label(child1, SWT.NONE);
		lblNewLabel_4.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_4.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 14, SWT.NORMAL));
		lblNewLabel_4.setAlignment(SWT.CENTER);
		lblNewLabel_4.setText("  平遥英海眼镜中心   ");

		Label lblNewLabel_5 = new Label(child1, SWT.NONE);

		Label lblAddeyecheckwindow = new Label(child1, SWT.NONE);
		lblAddeyecheckwindow.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblAddeyecheckwindow.setAlignment(SWT.CENTER);
		lblAddeyecheckwindow.setText("\u89C6\u754C\u4E4B\u7F8E\uFF0C\u4F60\u6211\u4E4B\u9B45\u3002");

		Label label = new Label(child1, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblNewLabel_3 = new Label(child1, SWT.NONE);

		Label lblNewLabel_6 = new Label(child1, SWT.NONE);
		lblNewLabel_6.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		lblNewLabel_6.setAlignment(SWT.CENTER);
		lblNewLabel_6.setText("\u8F93\u5165\u59D3\u540D\u6216\u8005\u624B\u673A\u53F7");

		searchText = new Text(child1, SWT.BORDER);
		searchText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchText.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 16, SWT.NORMAL));
		Button searchButton = new Button(child1, SWT.PUSH);
		searchButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("===================");
			}
		});

		searchButton.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDown(MouseEvent e) {
				super.mouseDown(e);

				String key = searchText.getText();
				if ("".equals(key) || null == key) {
					MessageBox box = new MessageBox(shell);
//					box.setText("提示:");
					box.setMessage("请输入姓名或者手机号");
					box.open();
					return;
				}
				customerInfoTable.removeAll();
//				customerInfoTable.clearAll();
				customerEyeCheckTable.removeAll();
//				customerEyeCheckTable.clearAll();
				
				EntityManager em = DAOFactory.getEntityManager();
				List<Customer> customerList = DAOFactory.getCustomerDao(em).findByNameOrPhone(key, key);
				createCustomerTableContent(customerList);

			}

//			@Override
//			public void mouseDoubleClick(MouseEvent e) {				
//				super.mouseDoubleClick(e);
//				System.out.println("=============mouseDoubleClick");
//			}

		});
		searchButton.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		searchButton.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 18, SWT.NORMAL));
		searchButton.setText("\u641C \u7D22");

		Composite child2 = new Composite(sashForm, SWT.NONE);
		child2.setLayout(new FillLayout());

		SashForm sashForm_1 = new SashForm(child2, SWT.BORDER | SWT.VERTICAL);
		sashForm_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		sashForm_1.setSashWidth(1);

		Composite child2_1 = new Composite(sashForm_1, SWT.NONE);
		child2_1.setLayout(new BorderLayout(0, 0));

		Group grpKk = new Group(child2_1, SWT.SHADOW_NONE);
		grpKk.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		grpKk.setText("\u5BA2\u6237\u57FA\u672C\u4FE1\u606F\u5217\u8868");
		grpKk.setLayout(new BorderLayout(0, 0));

		ToolBar toolBar = new ToolBar(grpKk, SWT.FLAT | SWT.RIGHT);
		toolBar.setLayoutData(BorderLayout.NORTH);

		// 新增客户基本信息
		ToolItem customerInfoIltm = new ToolItem(toolBar, SWT.NONE);
		customerInfoIltm.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				AddCustomerWindow window = new AddCustomerWindow();
				window.open(customerInfoTable);

			}
		});
		customerInfoIltm.setText("\u65B0\u589E");

		// 编辑客户基本信息
		ToolItem tltmNewItem_1 = new ToolItem(toolBar, SWT.NONE);
		tltmNewItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				if (customerInfoTable.getSelectionIndex() == -1) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请选择要编辑的内容");
					box.open();
				} else {
					int index = customerInfoTable.getSelectionIndex();
					String customerInfoId = customerInfoTable.getItem(index).getText();
					// todo:
					AddCustomerWindow window = new AddCustomerWindow();
					window.open(customerInfoTable);
					window.setEditValue(customerInfoId);

				}
			}
		});
		tltmNewItem_1.setText("\u7F16\u8F91");

		customerInfoTable = new Table(grpKk, SWT.BORDER | SWT.CHECK | SWT.FULL_SELECTION);
		customerInfoTable.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(ControlEvent e) {
				// TODO Auto-generated method stub
				super.controlResized(e);
				customerInfoTable.getColumn(1).setWidth(100);
				customerInfoTable.getColumn(3).setWidth(120);
				customerInfoTable.getColumn(4).setWidth(150);
				customerInfoTable.getColumn(5).setWidth(300);
				customerInfoTable.getColumn(10).setWidth(200);
			}

		});
		customerInfoTable.setLinesVisible(true);
		customerInfoTable.setHeaderVisible(true);
		customerInfoTable.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent event) {
				customerEyeCheckTable.removeAll();

				int index = customerInfoTable.getSelectionIndex();
				String customerId = customerInfoTable.getItem(index).getText();
//				System.out.println("==================选择的ID:" + customerId);
				List<CustomerCheckInfo> customerCheckInfoList = customerCheckInfoMap.get(Long.parseLong((customerId)));
				if (customerCheckInfoList != null) {
					for (int j = 0; j < customerCheckInfoList.size(); j++) {
						CustomerCheckInfo customerCheckInfo = customerCheckInfoList.get(j);
						List<EyeCheckItem> list = customerCheckInfo.getEyeCheckItemList();
						String[] tableItems_1 = { customerCheckInfo.getCheckDate().toLocaleString(),
								customerCheckInfo.getAge(), customerCheckInfo.getHeight(), customerCheckInfo.getWight(),
								list.get(0).getEyeType(), list.get(0).getNakedVision(), list.get(0).getOldGlassDegree(),
								list.get(0).getOldGlassInterpupillaryDistance(), list.get(0).getOldGlassVision(),
								list.get(0).getPrescription(), list.get(0).getPrescriptiveInterpupillaryDistance(),
								list.get(0).getCorrectedVision(), list.get(0).getEyeShaftLength(),
								list.get(0).getCornealCurvature(), list.get(0).getPositionOfEye(),
								list.get(0).getStressOfEye() };
						TableItem tableItem_1 = new TableItem(customerEyeCheckTable, SWT.NONE);
						tableItem_1.setText(tableItems_1);

						String[] tableItems_2 = { customerCheckInfo.getCheckDate().toLocaleString(),
								customerCheckInfo.getAge(), customerCheckInfo.getHeight(), customerCheckInfo.getWight(),
								list.get(0).getEyeType(), list.get(0).getNakedVision(), list.get(0).getOldGlassDegree(),
								list.get(0).getOldGlassInterpupillaryDistance(), list.get(0).getOldGlassVision(),
								list.get(0).getPrescription(), list.get(0).getPrescriptiveInterpupillaryDistance(),
								list.get(0).getCorrectedVision(), list.get(0).getEyeShaftLength(),
								list.get(0).getCornealCurvature(), list.get(0).getPositionOfEye(),
								list.get(0).getStressOfEye() };
						TableItem tableItem_2 = new TableItem(customerEyeCheckTable, SWT.NONE);
						tableItem_2.setText(tableItems_2);
					}
				}
			}
		});

		TableCursor tableCursor_1 = new TableCursor(customerInfoTable, SWT.NONE);

		// 设置客户基本信息表头
		String[] tableHeader = { "ID", "姓名", "性别", "联系方式", "会员卡号", "家庭住址", "是否有家族遗传性眼病", "父母是否戴镜", "个人全身健康情况", "个人眼病史",
				"工作" };
		for (int i = 0; i < tableHeader.length; i++) {
			TableColumn tableColumn = new TableColumn(customerInfoTable, SWT.NONE);
			tableColumn.setText(tableHeader[i]);
			//
			tableColumn.setMoveable(true);
		}

		// 重新布局表格
		for (int i = 0; i < tableHeader.length; i++) {
			customerInfoTable.getColumn(i).pack();
			if (i == 0) {// 隐藏ID列
				customerInfoTable.getColumn(i).setWidth(0);
				customerInfoTable.getColumn(i).setResizable(false);
			}
		}
		// 为这个table加一个事件,如果点击某一个element,则在控制台显示该element的坐标
//		customerInfoTable.addListener(SWT.MouseDown, new Listener() {  
//            
//			@Override
//			public void handleEvent(Event event) {
//				int index = customerInfoTable.getTopIndex(); 
//				final TableItem item = customerInfoTable.getItem(index); 
//				System.out.println(index + "====" + item.getText(7));
//			}  
//        });  

		Composite child2_2 = new Composite(sashForm_1, SWT.NONE);
		child2_2.setLayout(new FillLayout(SWT.HORIZONTAL));

		Group group = new Group(child2_2, SWT.NONE);
		group.setFont(SWTResourceManager.getFont("Microsoft YaHei UI", 12, SWT.NORMAL));
		group.setText("客户视力检查跟踪列表");
		group.setLayout(new BorderLayout(0, 0));

		customerEyeCheckTable = new Table(group, SWT.BORDER | SWT.FULL_SELECTION);
		customerEyeCheckTable.addControlListener(new ControlAdapter() {

			@Override
			public void controlResized(ControlEvent e) {
				// TODO Auto-generated method stub
				super.controlResized(e);
				customerEyeCheckTable.getColumn(0).setWidth(170);
			}

		});
		customerEyeCheckTable.setLayoutData(BorderLayout.CENTER);
		customerEyeCheckTable.setHeaderVisible(true);
		customerEyeCheckTable.setLinesVisible(true);

		TableCursor tableCursor = new TableCursor(customerEyeCheckTable, SWT.NONE);

		// 设置客户视力信息表头
		String[] tableHeader_1 = { "检查时间", "年龄", "身高(cm)", "体重(kg)", "眼别", "裸眼视力", "旧镜度数", "旧镜瞳距", "旧镜视力", "最终处方",
				"处方瞳距", "矫正视力", "眼球轴长", "角膜曲率", "眼位", "眼压" };
		for (int i = 0; i < tableHeader_1.length; i++) {
			TableColumn tableColumn = new TableColumn(customerEyeCheckTable, SWT.NONE);
			tableColumn.setText(tableHeader_1[i]);
			//
			tableColumn.setMoveable(true);
		}
		// 添加数据

//		for (int i = 0; i < customerList.size(); i++) {
//			TableItem tableItem = new TableItem(customerEyeCheckTable, SWT.NONE);
//
//			Customer customer = customerList.get(i);
//			String[] tableItems = { customer.getName(), customer.getSex(), customer.getMobilephone(),
//					customer.getMembershipCard(),
//
//					customer.getAddress(), customer.getHereditaryOphthalmopathy(), customer.getParentsWearGlasses(),
//					customer.getHealth(), customer.getIndividualEyeHistory() };
//			tableItem.setText(tableItems);
//		}
		for (int i = 0; i < tableHeader_1.length; i++) {
			customerEyeCheckTable.getColumn(i).pack();
		}
		// 默认展现数据
		initCustomerTableContent();

		ToolBar toolBar_1 = new ToolBar(group, SWT.FLAT | SWT.RIGHT);
		toolBar_1.setLayoutData(BorderLayout.NORTH);

		// 新增客户视力健康信息
		ToolItem toolItem = new ToolItem(toolBar_1, SWT.NONE);
		toolItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int index = customerInfoTable.getSelectionIndex();
				if (index == -1) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请在客户基本信息列表中选择要新增视力健康跟踪的客户");
					box.open();
				} else {	
					String customerInfoId = customerInfoTable.getItem(index).getText();
					String customerName = customerInfoTable.getItem(index).getText(1);
					AddEyeCheckWindow window = new AddEyeCheckWindow();
					window.open(customerEyeCheckTable);
					window.setCustomer(customerInfoId, customerName, null);//todo:
				}
			}
		});
		toolItem.setText("\u65B0\u589E");

		toolBar.setLayoutData(BorderLayout.NORTH);

		ToolItem deleteCustomerInfoButton = new ToolItem(toolBar, SWT.NONE);
		deleteCustomerInfoButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem[] item = customerInfoTable.getItems();
//				for (int i = 0; i < item.length; i++) {
//					item[i].setBackground(new Color(display, 255, 255, 255));
//				}
				if (customerInfoTable.getSelectionIndex() == -1) {
					MessageBox box = new MessageBox(shell);
					box.setMessage("请选择要删除的内容");
					box.open();
				} else {
					MessageBox box = new MessageBox(shell, SWT.OK|
						     SWT.CANCEL|
						     SWT.ICON_WARNING);
					box.setMessage("请慎重操作删除客户资料，确定要删除吗？");
					if(box.open() == SWT.OK) {
						int index = customerInfoTable.getSelectionIndex();
						String customerInfoId = customerInfoTable.getItem(index).getText();

						EntityManager em = DAOFactory.getEntityManager();
						DAOFactory.getCustomerDao(em).delete(Customer.class, Long.parseLong(customerInfoId));
						
						int[] selInices = customerInfoTable.getSelectionIndices();// 将选中的序号放在数组中
						customerInfoTable.remove(selInices);

						customerEyeCheckTable.removeAll();
					}
					
					
					
				}

			}
		});
		deleteCustomerInfoButton.setText("\u5220\u9664");
		
		ToolItem toolItem_1 = new ToolItem(toolBar, SWT.NONE);
		toolItem_1.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				System.out.println("================刷新");
				MessageBox box = new MessageBox(shell);
				box.setMessage("默认显示50条数据");
				box.open();
				cleanAll();
				initCustomerTableContent();
			}
		});
		toolItem_1.setText("刷新");
		sashForm_1.setWeights(new int[] { 1, 1 });

		sashForm.setSashWidth(1);
		sashForm.setWeights(new int[] { 235, 1279 });

//		FormData fd_coolBar = new FormData();
//		fd_coolBar.bottom = new FormAttachment(100);
//		fd_coolBar.left = new FormAttachment(0);
//		fd_coolBar.right = new FormAttachment(100);
//		fd_coolBar.top = new FormAttachment(200);
//		coolBar.setLayoutData(fd_coolBar);

//		CoolItem coolItem_1 = new CoolItem(coolBar, SWT.NONE);
//		coolItem_1.setText("12312");
//		
//		CoolItem coolItem = new CoolItem(coolBar, SWT.NONE);
//		coolItem.setText("\u7535\u52A8");

//		sashForm.setWeights(new int[] {});
//		Display display = Display.getDefault();
//		final Runnable timer = new Runnable() {  
////        	
//            public void run() {  
//                if (display.isDisposed()) {  
//                    return;  
//                }  
//                Date dt = new Date();  
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" + " ");  
//                coolItem.setText(sdf.format(dt));  
//                display.timerExec(500, this);  
//            }  
//        };  
		//
//        display.timerExec(500, timer); 

	}

	Map<Long, List<CustomerCheckInfo>> customerCheckInfoMap = new HashMap<Long, List<CustomerCheckInfo>>();
	private SashForm sashForm;

	//
	private void initCustomerTableContent() {
		EntityManager em = DAOFactory.getEntityManager();
		List<Customer> customerList = DAOFactory.getCustomerDao(em).find(0, 50);
		createCustomerTableContent(customerList);
	}
	
	private void cleanAll() {
		customerInfoTable.removeAll();
		customerEyeCheckTable.removeAll();
		customerCheckInfoMap.clear();
	}

	// 组装数据
	private void createCustomerTableContent(List<Customer> customerList) {
		for (int i = 0; i < customerList.size(); i++) {
			Customer customer = customerList.get(i);

			// 将查询结果添加到客户基本信息列表中
			TableItem tableItem = new TableItem(customerInfoTable, SWT.NONE);
			String[] tableItems = { customer.getCustomerId().toString(), customer.getName(), customer.getSex(),
					customer.getMobilephone(), customer.getMembershipCard(), customer.getAddress(),
					customer.getHereditaryOphthalmopathy(), customer.getParentsWearGlasses(), customer.getHealth(),
					customer.getIndividualEyeHistory(), customer.getProfession() };
			tableItem.setText(tableItems);

			// 将客户视力健康档案信息先暂存在map中
			List<CustomerCheckInfo> customerCheckInfoList = customer.getCustomerCheckInfoList();
			customerCheckInfoMap.put(customer.getCustomerId(), customer.getCustomerCheckInfoList());
		}
	}
}

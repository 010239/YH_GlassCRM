package crm.frontend.demo;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionListener;
import java.util.function.Consumer;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

public class TwoTable {

	protected Shell shell;
	private Table table;
	private Table table_1;

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			TwoTable window = new TwoTable();
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
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(746, 520);
		shell.setText("SWT Application");
		shell.setLayout(null);

		table = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION);
		table.setBounds(0, 0, 364, 473);
		table.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				super.widgetSelected(e);
				
				int index = table.getSelectionIndex();
				table_1.getItem(2*index).setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));;
			}
			
//			@Override
//			public SelectionListener widgetSelectedAdapter(Consumer<SelectionEvent> c) {
//				
//				return (SelectionListener) null;
//			}
		});
		table.setLinesVisible(true);
		table.setTouchEnabled(true);
		table.setHeaderVisible(true);

		TableColumn tblclmnNewColumn_1 = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn_1.setWidth(100);
		tblclmnNewColumn_1.setText("New Column");

		TableColumn tblclmnNewColumn = new TableColumn(table, SWT.NONE);
		tblclmnNewColumn.setWidth(100);
		tblclmnNewColumn.setText("New Column");

		TableItem tableItem = new TableItem(table, SWT.NONE);
		tableItem.setText("New TableItem");
		table.addListener(SWT.MeasureItem, new Listener() {
            public void handleEvent(Event event) {
            	System.out.println("+++++++++++++++++++++");
                // 设置行高度
//                event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 2);
            	//int itemHeight = table.getItemHeight();
            	//System.out.println(itemHeight);
            	event.height = 48;
            }
        });
		table.setItemCount(2);

		

		TableItem tableItem_3 = new TableItem(table, SWT.NONE);
		tableItem_3.setText("New TableItem");

		TableItem tableItem_6 = new TableItem(table, SWT.NONE);
		tableItem_6.setText("New TableItem");

		table_1 = new Table(shell, SWT.BORDER | SWT.FULL_SELECTION | SWT.VIRTUAL);
		table_1.setBounds(364, 0, 364, 473);
		table_1.setHeaderVisible(true);
		table_1.setLinesVisible(true);

		TableColumn tblclmnNewColumn_2 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_2.setWidth(75);
		tblclmnNewColumn_2.setText("New Column");

		TableColumn tblclmnNewColumn_3 = new TableColumn(table_1, SWT.NONE);
		tblclmnNewColumn_3.setWidth(100);
		tblclmnNewColumn_3.setText("New Column");

		TableItem tableItem_1 = new TableItem(table_1, SWT.NONE);
		tableItem_1.setText("New TableItem");

		TableItem tableItem_2 = new TableItem(table_1, SWT.NONE);
		tableItem_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_TITLE_BACKGROUND_GRADIENT));
		tableItem_2.setText("New TableItem");

		TableItem tableItem_4 = new TableItem(table_1, SWT.NONE);
		tableItem_4.setText("New TableItem");

		TableItem tableItem_5 = new TableItem(table_1, SWT.NONE);
		tableItem_5.setText("New TableItem");
		
		
		
		table_1.getColumn(0).addListener(SWT.MeasureItem, new Listener() {
			public void handleEvent(Event event) {
				System.out.println("--------------------");
				// 设置行高度
//                event.height = (int) Math.floor(event.gc.getFontMetrics().getHeight() * 2);
				// int itemHeight = table.getItemHeight();
				// System.out.println(itemHeight);
				event.height = 90;
			}
		});

	}
}

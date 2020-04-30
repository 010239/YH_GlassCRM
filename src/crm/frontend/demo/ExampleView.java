package crm.frontend.demo;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.ui.part.ViewPart;

/**
 * After initial creation:
 * https://lh4.googleusercontent.com/-fqnKdhe4tlI/TgoYDnSH9nI
 * /AAAAAAAAASI/b-r50-gV-sk/ViewWithoutActios.png
 * 
 * After first click, and what should look like in hidden state
 * https://lh3.googleusercontent
 * .com/-KSuSvvwESgI/TgoYD9HpH5I/AAAAAAAAASE/Kkd8geVqlWc/UNcollapsed.png
 * 
 * After second click and what should look like in revealed state
 * https://lh3.googleusercontent
 * .com/-WtqXPCqFIjE/TgoYDkBykWI/AAAAAAAAASA/0SWJCVLYwTY/Collapsed.png
 * 
 */
public class ExampleView extends ViewPart {
	public static void main(String[] args) {
		Display display = new Display ();
		Shell shell = new Shell (display);
		Composite composite = new Composite (shell, SWT.BORDER);
		ExampleView exampleView = new ExampleView();
		exampleView.createPartControl(composite);
		shell.open ();
		while (!shell.isDisposed ()) {
			if (!display.readAndDispatch ()) display.sleep ();
		}
		display.dispose ();
	}
	

	public static final String ID = "eclipsedsm.views.ExampleView";
	private static final String FIRST_COLUMN_TEXT = "Names";

	private TableViewer viewer;
	private ExampleTableModel model = new ExampleTableModel();

	private Listener columnListener = new Listener() {

		@Override
		public void handleEvent(Event event) {
			String columnText = ((TableColumn) event.widget).getText();
			if (!FIRST_COLUMN_TEXT.equals(columnText) && ExampleTableModel.NAMES_MAP.get(columnText) == 1) {
				model.colapsedColumns = !model.colapsedColumns;
				updateCollapsedColumns();
			}
		}
	};

	/**
	 * The constructor.
	 */
	public ExampleView() {
	}

	private void updateCollapsedColumns() {
		Table table = viewer.getTable();
		if (model.colapsedColumns) {
			table.getColumn(0).setWidth(viewer.getTable().getSize().x - 40 * 2);
			table.getColumn(1).setWidth(40);
			table.getColumn(2).setWidth(40);
			table.getColumn(3).setWidth(0);
			table.getColumn(4).setWidth(0);
		} else {
			table.getColumn(0).setWidth(viewer.getTable().getSize().x - 40 * 4);
			table.getColumn(1).setWidth(40);
			table.getColumn(2).setWidth(40);
			table.getColumn(3).setWidth(40);
			table.getColumn(4).setWidth(40);
		}
		viewer.refresh();

	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	@Override
	public void createPartControl(Composite parent) {

		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);

		Table table = viewer.getTable();
		table.setHeaderVisible(true);

		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(model);

		viewer.setInput(model.getInput());
		setColumns();

	}

	private void setColumns() {
		viewer.getTable().setLayoutData(new GridData(SWT.LEFT, SWT.FILL, false, true));

		TableColumn firstColumn = new TableColumn(viewer.getTable(), SWT.LEFT);
		firstColumn.setText(FIRST_COLUMN_TEXT);
		firstColumn.setResizable(false);
		for (String name : ExampleTableModel.NAMES) {
			TableColumn column = new TableColumn(viewer.getTable(), SWT.CENTER);
			column.setResizable(false);

			column.setText(name);
			column.addListener(SWT.Selection, columnListener);
		}
		updateCollapsedColumns();

	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	@Override
	public void setFocus() {
		viewer.getControl().setFocus();
	}

	private static class ExampleTableModel implements ITableLabelProvider {
		private static final String[] NAMES = { "name1", "name2", "name21", "name22" };
		private static final Map<String, Integer> NAMES_MAP = new HashMap<String, Integer>();
		private static final String[][] CONTENT = { { "11", "12", "13", "14" }, { "21", "22", "23", "24" },
				{ "31", "32", "33", "34" }, { "41", "42", "43", "44" } };
		private boolean colapsedColumns = true;
		static {
			NAMES_MAP.put("name1", 0);
			NAMES_MAP.put("name2", 1);
			NAMES_MAP.put("name21", 2);
			NAMES_MAP.put("name22", 3);
		}

		@Override
		public String getColumnText(Object element, int columnIndex) {
			if (columnIndex == 0) {
				return NAMES[(Integer) element];
			} else {
				return CONTENT[(Integer) element][columnIndex - 1];
			}
		}

		public Object getInput() {
			return new Integer[] { 0, 1, 2, 3 };
		}

		@Override
		public void addListener(ILabelProviderListener listener) {
		}

		@Override
		public void dispose() {
		}

		@Override
		public boolean isLabelProperty(Object element, String property) {
			return false;
		}

		@Override
		public void removeListener(ILabelProviderListener listener) {
		}

		@Override
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

	}
}
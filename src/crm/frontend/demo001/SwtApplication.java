package crm.frontend.demo001;

import org.eclipse.swt.SWT;  
import org.eclipse.swt.events.SelectionAdapter;  
import org.eclipse.swt.events.SelectionEvent;  
import org.eclipse.swt.widgets.Button;  
import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;  
  
public class SwtApplication {  
    protected Shell shell;  
  
    public static void main(String[] args) throws Exception {  
        SwtApplication window = new SwtApplication();  
        window.open();  
    }  
  
    public void open() {  
        final Display display = Display.getDefault();  
        createContents();  
        shell.open();  
        shell.layout();  
        while (!shell.isDisposed()) {  
            if (!display.readAndDispatch()) {  
                display.sleep();  
            }  
        }  
    }  
  
    protected void createContents() {  
        shell = new Shell();  
        shell.setSize(500, 375);  
        shell.setText("SWT");  
  
        final Button button = new Button(shell, SWT.NONE);  
        button.addSelectionListener(new SelectionAdapter() {  
            public void widgetSelected(SelectionEvent e) {  
                new CustomDialog(Display.getCurrent().getActiveShell()).open();  
            }  
        });  
        button.setText("button");  
        button.setBounds(438, 308, 44, 23);  
    }  
  
}  

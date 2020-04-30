package crm.frontend.demo001;

import org.eclipse.swt.SWT;  
import org.eclipse.swt.widgets.Button;  
import org.eclipse.swt.widgets.Dialog;  
import org.eclipse.swt.widgets.Display;  
import org.eclipse.swt.widgets.Shell;  
  
  
public class CustomDialog extends Dialog {  
    protected Object result;  
    protected Shell shell;  
  
    public CustomDialog(Shell parent) {  
        super(parent, SWT.NONE);  
    }  
  
    public Object open() {  
        createContents();  
        shell.open();  
        shell.layout();  
        Display display = getParent().getDisplay();  
        while (!shell.isDisposed()) {  
            if (!display.readAndDispatch())  
                display.sleep();  
        }  
        return result;  
    }  
  
    protected void createContents() {  
        shell = new Shell(getParent(), SWT.DIALOG_TRIM | SWT.APPLICATION_MODAL);  
        shell.setSize(312, 212);  
        shell.setText("SWT Dialog");  
        
        final Button button = new Button(shell, SWT.NONE);  
        button.setText("button");  
        button.setBounds(127, 74, 44, 23);  
    }  
}  
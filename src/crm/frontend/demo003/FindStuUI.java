package crm.frontend.demo003;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;

public class FindStuUI {
  Display display=null;
  Shell shell=new Shell(display);
  public FindStuUI(Display dy)
  {
    this.display=dy;
  }
  static void findStuShow(Display dy,Table table)
  {
    FindStuUI fst=new FindStuUI(dy);
    fst.run(table);
  }
  public void run(final Table table)
  {
    shell.setBounds(500,200,280,400);
    shell.setText("查询学生信息");
    //添加标签
    Label shuoming=new Label(shell,SWT.NONE);
    shuoming.setText("请输入所要查询的信息，至少输入一项");
    shuoming.setFont(new Font(display,"宋体",10,SWT.BOLD));
    shuoming.setBounds(10,30,245,20);
    Label id=new Label(shell,SWT.NONE);
    id.setText("请输入要查询的学号");
    id.setBounds(20,70,120,40);
    Label name=new Label(shell,SWT.NONE);
    name.setText("请输入要查询的姓名");
    name.setBounds(20,120,120,40);
    Label score=new Label(shell,SWT.NONE);
    score.setText("请输入要查询的成绩");
    score.setBounds(20,170,120,40);
    Label cls=new Label(shell,SWT.NONE);
    cls.setText("请输入要查询的班级");
    cls.setBounds(20,220,120,40);
    //添加文本框
    final Text text1=new Text(shell,SWT.NONE);
    text1.setBounds(140,65,100,25);
    final Text text2=new Text(shell,SWT.NONE);
    text2.setBounds(140,115,100,25);
    final Text text3=new Text(shell,SWT.NONE);
    text3.setBounds(140,165,100,25);
    final Text text4=new Text(shell,SWT.NONE);
    text4.setBounds(140,215,100,25);
    //添加按钮
    Button button1=new Button(shell,SWT.NONE);
    button1.setText("确定");
    button1.setBounds(55,270,60,40);
    Button button2=new Button(shell,SWT.NONE);
    button2.setText("取消");
    button2.setBounds(135,270,60,40);
    //为确定按钮添加事件处理
    button1.addSelectionListener(new SelectionAdapter(){
        public void widgetSelected(SelectionEvent e)
              {
          boolean flag=false;
                if("".equals(text1.getText())&&"".equals(text2.getText())&&"".equals(text3.getText())&&"".equals(text4.getText()))
                {
                  MessageBox box = new MessageBox(shell);
            box.setMessage("请至少输入一项信息");
            box.open();
            
                }
                else
                {
                  int count=0;
                    
                  TableItem it[]=table.getItems();
                  for(int i=0;i<it.length;i++)
                  {
                    flag=true;
                    if(text1.getText().equals(it[i].getText(0)))
                    {
                      it[i].setBackground(new Color(display, SWT.COLOR_DARK_RED, 200, 20));flag=false;
                    }
                    else if(text2.getText().equals(it[i].getText(1)))
                    {
                      it[i].setBackground(new Color(display, SWT.COLOR_DARK_RED, 200, 20));flag=false;
                    }
                    else if(text3.getText().equals(it[i].getText(2)))
                    {
                      it[i].setBackground(new Color(display, SWT.COLOR_DARK_RED, 200, 20));flag=false;
                    }
                    else if(text4.getText().equals(it[i].getText(3)))
                    {
                      it[i].setBackground(new Color(display, SWT.COLOR_DARK_RED, 200, 20));flag=false;
                    }
                    if(flag==false)
                    {
                      count++;
                    }
                    
                        }
                  if(count==0)
                  {
                    MessageBox box=new MessageBox(shell);
                    box.setMessage("很抱歉，没有你所要查询的信息");
                    box.open();
                    
                  }
                
                }
                if(flag)
                {
                  shell.close();
                }
                            
              }
            });
      //为取消按钮添加事件处理
                 button2.addSelectionListener(new SelectionAdapter(){
        public void widgetSelected(SelectionEvent e)
              {
                            shell.close();
              }
            });
    shell.open();
  }
    

} 